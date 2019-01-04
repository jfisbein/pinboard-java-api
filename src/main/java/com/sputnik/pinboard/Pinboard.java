package com.sputnik.pinboard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.experimental.UtilityClass;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Data
@UtilityClass
public class Pinboard {

    /**
     * Get Pinboard API client with authentication by username and password.
     *
     * @param username Username
     * @param password Password
     * @return Pinboard API client
     */
    public static PinboardApi getApi(String username, String password) {
        return getApi(username, password, false);
    }

    /**
     * Get Pinboard API client with authentication by username and password.
     *
     * @param username Username
     * @param password Password
     * @param debug    show all request and responses
     * @return Pinboard API client
     */
    public static PinboardApi getApi(String username, String password, boolean debug) {
        return init(new PinboardUserAndPasswordAuthInterceptor(username, password), debug);
    }

    /**
     * Get Pinboard API client with authentication by user token.
     *
     * @param authToken Authentication token
     * @return Pinboard API client
     */
    public static PinboardApi getApi(String authToken) {
        return getApi(authToken, false);
    }

    /**
     * Get Pinboard API client with authentication by user token.
     *
     * @param authToken Authentication token
     * @param debug     show all request and responses
     * @return Pinboard API client
     */
    public static PinboardApi getApi(String authToken, boolean debug) {
        return init(new PinboardTokenAuthInterceptor(authToken), debug);
    }

    /**
     * Initializes Pinboard API client with authentication interceptor.
     *
     * @param authInterceptor Authentication interceptor.
     * @param debug           show all request and responses
     * @return Pinboard API client.
     */
    private static PinboardApi init(Interceptor authInterceptor, boolean debug) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
                .create();

        OkHttpClient httpClient = getHttpClient(authInterceptor);

        if (debug) {
            httpClient = httpClient
                    .newBuilder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.pinboard.in/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();

        return retrofit.create(PinboardApi.class);
    }

    /**
     * Initializes http client with authentication and json format interceptors.
     *
     * @param authInterceptor desired auth interceptor can be token, or username and password.
     * @return configured http client.
     */
    private static OkHttpClient getHttpClient(Interceptor authInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .addInterceptor(new PinboardJsonFormatInterceptor())
                .build();
    }

    /**
     * Add credentials to authenticate using token.
     */
    private static class PinboardTokenAuthInterceptor implements Interceptor {

        private final String authToken;

        private PinboardTokenAuthInterceptor(String authToken) {this.authToken = authToken;}

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl newUrl = request.url().newBuilder().addQueryParameter("auth_token", authToken).build();
            request = request.newBuilder().url(newUrl).build();

            return chain.proceed(request);
        }
    }

    /**
     * Add credentials to authenticate using username and password.
     */
    private static class PinboardUserAndPasswordAuthInterceptor implements Interceptor {
        private final String credentials;

        private PinboardUserAndPasswordAuthInterceptor(String username, String password) {
            credentials = Credentials.basic(username, password);
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder().addHeader("Authorization", credentials).build();

            return chain.proceed(authenticatedRequest);
        }
    }

    /**
     * Add param to force all requests to reply in json format
     */
    private static class PinboardJsonFormatInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl newUrl = request.url().newBuilder().addQueryParameter("format", "json").build();
            request = request.newBuilder().url(newUrl).build();

            return chain.proceed(request);
        }
    }
}

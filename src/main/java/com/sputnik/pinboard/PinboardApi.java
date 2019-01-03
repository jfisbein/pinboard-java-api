package com.sputnik.pinboard;

import com.sputnik.pinboard.model.DatesResponse;
import com.sputnik.pinboard.model.LastUpdateResponse;
import com.sputnik.pinboard.model.Note;
import com.sputnik.pinboard.model.NotesResult;
import com.sputnik.pinboard.model.Post;
import com.sputnik.pinboard.model.PostsResponse;
import com.sputnik.pinboard.model.Result;
import com.sputnik.pinboard.model.YesNo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PinboardApi {
    @GET("/v1/posts/update")
    Call<LastUpdateResponse> lastPostUpdate();

    @GET("/v1/posts/add")
    Call<Result> addPost(@NotNull @Query("url") URL url,
                         @NotNull @Query("description") String description,
                         @Query("extended") String extended,
                         @Query("tags") String tags,
                         @Query("dt") Date dt,
                         @Query("replace") YesNo replace,
                         @Query("shared") YesNo shared,
                         @Query("toread") YesNo toread);

    @GET("/v1/posts/delete")
    Call<Result> deletePost(@NotNull @Query("url") URL url);

    @GET("/v1/posts/recent")
    Call<PostsResponse> getRecentPosts(@Query("tag") String tag,
                                       @Query("count") Integer count);

    @GET("/v1/posts/get")
    Call<PostsResponse> getPosts(@Query("tag") String tag,
                                 @Query("dt") String dt,
                                 @Query("url") URL url,
                                 @Query("meta") YesNo meta);

    @GET("/v1/posts/dates")
    Call<DatesResponse> getPostsDates(@Query("tag") String tag);

    @GET("/v1/posts/all")
    Call<List<Post>> searchPosts(@Query("tag") String tag,
                                 @Query("start") Integer start,
                                 @Query("results") Integer results,
                                 @Query("fromdt") Date fromdt,
                                 @Query("todt") Date todt,
                                 @Query("meta") Integer meta);

    @GET("/v1/posts/suggest")
    Call<List<Map<String, List<String>>>> suggestTags(@NotNull @Query("url") URL url);

    @GET("/v1/tags/get")
    Call<Map<String, Integer>> getUserTags();

    @GET("/v1/tags/delete")
    Call<Result> deleteTag(@NotNull @Query("tag") String tag);

    @GET("/v1/tags/rename")
    Call<Result> renameTag(@NotNull @Query("old") String oldTag, @NotNull @Query("new") String newTag);

    @GET("/v1/user/secret")
    Call<Result> getUserSecret();

    @GET("/v1/user/api_token")
    Call<Result> getApiToken();

    @GET("/v1/notes/list")
    Call<NotesResult> getNotes();

    @GET("/v1/notes/{id}")
    Call<Note> getNote(@NotNull @Path("id") String id);
}

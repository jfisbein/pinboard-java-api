package com.sputnik.pinboard.model;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public class Result {
    @SerializedName("result_code")
    private String resultCode;
    //done, item not found

    @SerializedName("result")
    private String result;
    //done, rename to null

    public String getResult() {
        return Optional.ofNullable(resultCode).orElse(result);
    }

    @Override
    public String toString() {
        return getResult();
    }
}

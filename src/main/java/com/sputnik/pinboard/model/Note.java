package com.sputnik.pinboard.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Note {
    private String id;
    private String hash;
    private String title;
    private long length;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    //TODO use TypeAdapter for dates
}

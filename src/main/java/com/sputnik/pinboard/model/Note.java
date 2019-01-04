package com.sputnik.pinboard.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.sputnik.pinboard.model.typeadapter.NoteDateTypeAdapter;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Note {
    private String id;
    private String hash;
    private String title;
    private long length;
    @SerializedName("created_at")
    @JsonAdapter(NoteDateTypeAdapter.class)
    private Date createdAt;
    @SerializedName("updated_at")
    @JsonAdapter(NoteDateTypeAdapter.class)
    private Date updatedAt;
}

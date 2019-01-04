package com.sputnik.pinboard.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.sputnik.pinboard.model.typeadapter.TagsTypeAdapter;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@ToString
public class Post {
    private String href;
    private String description;
    private String extended;
    private String meta;
    private String hash;
    private Date time;
    @JsonAdapter(TagsTypeAdapter.class)
    private List<String> tags;
    private YesNo shared;
    @SerializedName("toread")
    private YesNo toRead;
}

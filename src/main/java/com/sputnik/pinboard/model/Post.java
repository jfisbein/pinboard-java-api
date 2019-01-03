package com.sputnik.pinboard.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Post {
    private String href;
    private String description;
    private String extended;
    private String meta;
    private String hash;
    private Date time;
    private String tags;
    private YesNo shared;
    @SerializedName("toread")
    private YesNo toRead;
}

package com.sputnik.pinboard.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class LastUpdateResponse {
    @SerializedName("update_time")
    private Date updateTime;
}

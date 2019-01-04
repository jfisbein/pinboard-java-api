package com.sputnik.pinboard.model;

import com.google.gson.annotations.JsonAdapter;
import com.sputnik.pinboard.model.typeadapter.DatesResponseDatesTypeAdapter;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Map;

@Getter
@ToString

public class DatesResponse {
    private String tag;
    private String user;
    @JsonAdapter(DatesResponseDatesTypeAdapter.class)
    private Map<LocalDate, Integer> dates;
}




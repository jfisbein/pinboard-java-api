package com.sputnik.pinboard.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class DatesResponse {
    private String tag;
    private String user;
    private Map<String, Integer> dates;
}

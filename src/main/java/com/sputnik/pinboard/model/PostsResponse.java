package com.sputnik.pinboard.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@ToString
public class PostsResponse {
    private Date date;
    private String user;
    private List<Post> posts;
}

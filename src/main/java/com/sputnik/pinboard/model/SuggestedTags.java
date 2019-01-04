package com.sputnik.pinboard.model;

import com.google.gson.annotations.JsonAdapter;
import com.sputnik.pinboard.model.typeadapter.SuggestedTagsTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@JsonAdapter(SuggestedTagsTypeAdapter.class)
public class SuggestedTags {
    private List<String> popular = new ArrayList<>();
    private List<String> recommended = new ArrayList<>();
}

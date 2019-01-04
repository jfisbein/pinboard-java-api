package com.sputnik.pinboard.model.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sputnik.pinboard.model.SuggestedTags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuggestedTagsTypeAdapter extends TypeAdapter<SuggestedTags> {
    @Override
    public void write(JsonWriter out, SuggestedTags value) throws IOException {

    }

    @Override
    public SuggestedTags read(JsonReader in) throws IOException {
        List<String> popularTags = null;
        List<String> recommendedTags = null;
        in.beginArray();
        while (in.hasNext()) {
            in.beginObject();
            String name = in.nextName();
            if (name.equals("popular")) {
                popularTags = parseArray(in);
            } else if (name.equals("recommended")) {
                recommendedTags = parseArray(in);
            }
            in.endObject();
        }
        in.endArray();

        return new SuggestedTags(popularTags, recommendedTags);
    }

    private List<String> parseArray(JsonReader in) throws IOException {
        List<String> list = new ArrayList<>();

        in.beginArray();
        while (in.hasNext()) {
            list.add(in.nextString());
        }
        in.endArray();

        return list;
    }
}

package com.sputnik.pinboard.model.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TagsTypeAdapter extends TypeAdapter<List<String>> {
    @Override
    public void write(JsonWriter out, List<String> value) throws IOException {
        out.value(String.join(" ", value));
    }

    @Override
    public List<String> read(JsonReader in) throws IOException {
        return Arrays.asList(in.nextString().split(" "));
    }
}

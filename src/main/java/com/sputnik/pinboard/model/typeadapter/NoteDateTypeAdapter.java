package com.sputnik.pinboard.model.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteDateTypeAdapter extends TypeAdapter<Date> {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        out.value(sdf.format(value));
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        try {
            return sdf.parse(in.nextString());
        } catch (ParseException e) {
            throw new IOException("Error parsing date:" + e.getMessage(), e);
        }
    }
}

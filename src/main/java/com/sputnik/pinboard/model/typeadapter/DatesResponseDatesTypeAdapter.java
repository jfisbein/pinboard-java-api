package com.sputnik.pinboard.model.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatesResponseDatesTypeAdapter extends TypeAdapter<Map<LocalDate, Integer>> {
    @Override
    public void write(JsonWriter out, Map<LocalDate, Integer> value) throws IOException {
        out.beginObject();
        List<LocalDate> dates = new ArrayList<>(value.keySet());
        Collections.sort(dates);
        for (LocalDate date : dates) {
            out.name(date.toString()).value(value.get(date));
        }
        out.endObject();
    }

    @Override
    public Map<LocalDate, Integer> read(JsonReader in) throws IOException {
        Map<LocalDate, Integer> dates = new HashMap<>();

        in.beginObject();
        while (in.hasNext()) {
            String date = in.nextName();
            int value = in.nextInt();
            dates.put(LocalDate.parse(date), value);
        }
        in.endObject();
        return dates;
    }
}

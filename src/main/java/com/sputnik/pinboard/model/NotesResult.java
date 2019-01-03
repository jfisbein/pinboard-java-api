package com.sputnik.pinboard.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class NotesResult {
    private long count;
    private List<Note> notes;
}

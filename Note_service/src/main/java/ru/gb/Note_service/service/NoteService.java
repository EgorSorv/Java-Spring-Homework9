package ru.gb.Note_service.service;

import ru.gb.Note_service.model.Note;

import java.util.List;

public interface NoteService {
    // создание заметки
    Note createNote(Note note);

    // получение всех заметок
    List<Note> getAllNotes();

    // получение заметки по id
    Note getNoteById(Long id);

    // обновление заметки по id
    Note updateNoteById(Long id, Note note);

    // удаление заметки по id
    void deleteNoteById(Long id);
}

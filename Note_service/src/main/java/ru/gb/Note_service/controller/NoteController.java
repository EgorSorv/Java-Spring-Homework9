package ru.gb.Note_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.Note_service.model.Note;
import ru.gb.Note_service.service.NoteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    //Проверка свагером http://localhost:8082/swagger-ui/index.html
    private final NoteService service;

    // создание заметки id
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }

    // вывод всех заметок id
    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        return new ResponseEntity<>(service.getAllNotes(), HttpStatus.OK);
    }

    // вывод заметки по id
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") Long id) {
        Note findNote;

        try {
            findNote = service.getNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }

        return new ResponseEntity<>(findNote, HttpStatus.OK);
    }

    // обновление заметки по id
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, @RequestBody Note note) {
        return new ResponseEntity<>(service.updateNoteById(id, note), HttpStatus.OK);
    }

    // удаление заметки по id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        service.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }
}

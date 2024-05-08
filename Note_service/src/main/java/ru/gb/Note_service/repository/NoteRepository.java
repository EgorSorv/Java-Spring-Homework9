package ru.gb.Note_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Note_service.model.Note;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // переопределенный поиск заметки по id
    @Override
    Optional<Note> findById(Long id);
}

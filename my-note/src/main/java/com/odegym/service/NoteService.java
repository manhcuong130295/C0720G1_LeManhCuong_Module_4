package com.odegym.service;

import com.odegym.entity.Note;
import com.odegym.entity.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    List<NoteType> findAllNoteType();
    Note findById(int id);
    Page<Note> findAll(Pageable pageable);
    Page<Note> findAllByNoteTypeId(Pageable pageable, Integer id);
    Page<Note> findAllByTitleContaining(Pageable pageable,String title);
    void save(Note note);
    void deleteById(int id);

}

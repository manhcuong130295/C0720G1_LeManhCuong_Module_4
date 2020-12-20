package com.odegym.service.impl;

import com.odegym.entity.Note;
import com.odegym.entity.NoteType;
import com.odegym.repository.NoteRepository;
import com.odegym.repository.NoteTypeRepository;
import com.odegym.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NoteTypeRepository noteTypeRepository;

    @Override
    public List<NoteType> findAllNoteType() {
        return noteTypeRepository.findAll();
    }

    @Override
    public Note findById(int id) {
        return this.noteRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return this.noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByNoteTypeId(Pageable pageable, Integer id) {
        return this.noteRepository.findAllByNoteType_Id(pageable,id);
    }

    @Override
    public Page<Note> findAllByTitleContaining(Pageable pageable, String title) {
        return this.noteRepository.findAllByTitleContaining(pageable,title);
    }

    @Override
    public void save(Note note) {
       this.noteRepository.save(note);
    }

    @Override
    public void deleteById(int id) {
     this.noteRepository.deleteById(id);
    }
}

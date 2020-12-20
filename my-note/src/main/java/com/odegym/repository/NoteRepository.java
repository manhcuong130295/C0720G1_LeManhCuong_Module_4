package com.odegym.repository;

import com.odegym.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {
    Page<Note> findAllByNoteType_Id(Pageable pageable,int id);
    Page<Note> findAllByTitleContaining(Pageable pageable,String title);
}

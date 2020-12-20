package com.odegym.repository;

import com.odegym.entity.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteTypeRepository extends JpaRepository<NoteType,Integer> {
}

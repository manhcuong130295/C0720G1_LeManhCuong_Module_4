package com.odegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "note_type")
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_type_id")
    int id;
    @Column(name = "type_name")
    private String typeName;

    private String description;

    @OneToMany(mappedBy = "noteType",cascade = CascadeType.ALL)
    private List<Note> notes;

    public NoteType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}

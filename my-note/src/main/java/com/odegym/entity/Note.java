package com.odegym.entity;

import javax.persistence.*;

@Entity(name = "Note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private int id;

    @Column(name = "title",columnDefinition = "VARCHAR(100)")
    private String title;

    @Column(name = "content",columnDefinition = "VARCHAR(500)")
    private String content;

    @ManyToOne
    @JoinColumn(name = "note_type_id")
    private NoteType noteType;

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }
}

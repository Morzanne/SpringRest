package com.wildcodeschool.book.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String description;

    public book(){}

    public book(int id, String title, String author, String description){

        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setDescription(description);

    }

    public void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description +'\''+
                '}';
    }
}

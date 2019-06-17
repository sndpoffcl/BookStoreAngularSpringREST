package com.cg.bookstore.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    private String authorName;
    private Date dateOfBirth;

    @OneToMany(mappedBy = "author" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
  @MapKey
   @JsonManagedReference
    private Map<Integer , Books> books;

    @ManyToOne
    @JsonBackReference
    private Category category;

    private Author(){

    }

    public Author(String authorName, Date dateOfBirth, Map<Integer, Books> books, Category category , int authorId) {
        super();
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
        this.category = category;
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Map<Integer, Books> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Books> books) {
        this.books = books;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

package com.lambdaschool.bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book
{
    //bookid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookid;
    //title
    private String title;
    //ISBN
    private String ISBN;
    //copy
    private int copy;
    //sectionid
    @ManyToOne
    @JoinColumn(name="sectionid")
    @JsonIgnoreProperties("books")
    private Section section;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private Set<Author> authors;

    public Book()
    {
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
    }

    public Set<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(Set<Author> authors)
    {
        this.authors = authors;
    }
}

package com.lambdaschool.bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author
{
    //authorid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorid;
    //fname
    private String fname;
    //lname
    private String lname;

    @ManyToMany
    @JoinTable(name = "wrote",
        joinColumns = {@JoinColumn(name = "authorid")},
        inverseJoinColumns = {@JoinColumn(name= "bookid")})
    @JsonIgnoreProperties("authors")
    private Set<Book> books;

    public Author()
    {
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }
}

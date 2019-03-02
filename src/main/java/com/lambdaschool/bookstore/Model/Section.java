package com.lambdaschool.bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="section")
public class Section
{
    //sectionid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionid;
    //name
    private String name;

    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("sections")
    private Set<Book> books;

    public Section()
    {
    }

    public long getId()
    {
        return sectionid;
    }

    public void setId(long id)
    {
        this.sectionid = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

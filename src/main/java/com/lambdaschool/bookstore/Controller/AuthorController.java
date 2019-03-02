package com.lambdaschool.bookstore.Controller;

import com.lambdaschool.bookstore.Model.Author;
import com.lambdaschool.bookstore.Repository.AuthorRepo;
import com.lambdaschool.bookstore.Repository.BookRepo;
import com.lambdaschool.bookstore.Repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController
{
    @Autowired
    BookRepo bookRepo;
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    SectionRepo sectionRepo;

    @GetMapping("/authors")
    public List<Author> findAllAuthors()
    {
        return authorRepo.findAll();
    }
}
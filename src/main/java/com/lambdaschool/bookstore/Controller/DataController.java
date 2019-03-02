package com.lambdaschool.bookstore.Controller;

import com.lambdaschool.bookstore.Model.Book;
import com.lambdaschool.bookstore.Repository.AuthorRepo;
import com.lambdaschool.bookstore.Repository.BookRepo;
import com.lambdaschool.bookstore.Repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController
{
    @Autowired
    BookRepo bookRepo;
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    SectionRepo sectionRepo;

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book newBook, @PathVariable long id) throws URISyntaxException
    {
        Optional<Book> updateBook = bookRepo.findById(id);
        if (updateBook.isPresent())
        {
            if (newBook.getAuthors() == null)
            {
                newBook.setAuthors(updateBook.get().getAuthors());
            }

            newBook.setBookid(id);
            bookRepo.save(newBook);
            return newBook;
        }
        else
        {
            return null;
        }
    }

    // assigns a book already in the system to an author already in the system
    @PostMapping("/books/{bookid}/authors/{authorid}")
    public String insertBooksandAuthors(@PathVariable("bookid") long bookid, @PathVariable("authorid") long authorid)
    {
        bookRepo.insertWrote(bookid, authorid);
        return "{" + "\"bookid\":" + bookid +
                ",\"authorid\":" + authorid + "}";
    }

    @DeleteMapping("/data/books/{id}")
    public Book deleteBookById(@PathVariable long id)
    {
        Optional<Book> foundBook = bookRepo.findById(id);
        if (foundBook.isPresent())
        {
            bookRepo.deleteBookFromWrote(id);
            bookRepo.deleteById(id);

            return foundBook.get();
        }
        else
        {
            return null;
        }
    }
}
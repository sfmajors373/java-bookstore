package com.lambdaschool.bookstore.Controller;

import com.lambdaschool.bookstore.Model.User;
import com.lambdaschool.bookstore.Repository.AuthorRepo;
import com.lambdaschool.bookstore.Repository.BookRepo;
import com.lambdaschool.bookstore.Repository.SectionRepo;
import com.lambdaschool.bookstore.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController
{
    @Autowired
    BookRepo bookRepo;
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    SectionRepo sectionRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public List<User> findAllUsers()
    {
        return userRepo.findAll();
    }

    @DeleteMapping("/user")
    public User deleteUserById(@PathVariable long id)
    {
        Optional<User> foundUser = userRepo.findById(id);
        if (foundUser.isPresent())
        {
            userRepo.deleteById(id);
            return foundUser.get();
        }
        else
        {
            return null;
        }
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User newUser)
    {
        userRepo.save(newUser);
        return newUser;
    }
}
package com.lambdaschool.bookstore.Service.impl;

import com.lambdaschool.bookstore.Model.User;

import java.util.List;

public interface UserService
{
    User save(User user);
    List<User> findAll();
    void delete(long id);
}

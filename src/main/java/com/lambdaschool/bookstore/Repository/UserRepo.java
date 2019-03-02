package com.lambdaschool.bookstore.Repository;

import com.lambdaschool.bookstore.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}

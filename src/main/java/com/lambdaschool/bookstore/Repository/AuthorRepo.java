package com.lambdaschool.bookstore.Repository;

import com.lambdaschool.bookstore.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long>
{
}

package com.lambdaschool.bookstore.Repository;

import com.lambdaschool.bookstore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepo extends JpaRepository<Book, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM wrote WHERE bookid = :bookid", nativeQuery = true)
    void deleteBookFromWrote(long bookid);

    //insertWrote
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote (bookid, authorid) VALUES (:bookid, :authorid)", nativeQuery = true)
    void insertWrote(long bookid, long authorid);
}

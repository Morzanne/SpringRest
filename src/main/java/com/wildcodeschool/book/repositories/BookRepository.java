package com.wildcodeschool.book.repositories;

import com.wildcodeschool.book.models.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<book, Integer> {

    List<book> findByTitleContainingOrAuthorContaining(String text, String textAgain);
}

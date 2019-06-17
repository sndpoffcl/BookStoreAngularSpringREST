package com.cg.bookstore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.beans.Books;

public interface BooksDao extends JpaRepository<Books,Integer> {
}

package com.cg.bookstore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.beans.Comments;

public interface CommentsDao extends JpaRepository<Comments , Integer> {
}

package com.cg.bookstore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.beans.Customers;

public interface CustomerDao extends JpaRepository<Customers , Integer> {

}

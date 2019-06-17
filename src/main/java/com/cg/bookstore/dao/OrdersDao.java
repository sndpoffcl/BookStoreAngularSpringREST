package com.cg.bookstore.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.beans.Orders;

public interface OrdersDao extends JpaRepository<Orders , Integer> {
}

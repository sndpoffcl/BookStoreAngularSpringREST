package com.cg.bookstore.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private Date orderDate;
    private String orderStatus;

    @OneToMany(mappedBy = "order" , fetch =FetchType.EAGER , cascade = CascadeType.ALL)
    @MapKey
    @JsonManagedReference("order_books")
    private Map<Integer , Book> books;

    public Ordered() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
    @JsonBackReference("customer_order")
    private Customer customer;

    public Ordered(Date orderDate, String orderStatus, Map<Integer, Book> books, Customer customer , int orderId) {
        super();
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.books = books;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }


}

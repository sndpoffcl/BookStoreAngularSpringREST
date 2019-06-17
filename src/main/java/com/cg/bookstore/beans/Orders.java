package com.cg.bookstore.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private Date orderDate;
    private String orderStatus;

    @OneToMany(mappedBy = "order" , fetch =FetchType.EAGER , cascade = CascadeType.ALL)
    @MapKey
    @JsonManagedReference
    private Map<Integer , Books> books;

    private int orderedBycustomerId;

    public Orders(Date orderDate, String orderStatus, Map<Integer, Books> books, Customers customer , int orderId) {
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

    public Map<Integer, Books> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Books> books) {
        this.books = books;
    }


}

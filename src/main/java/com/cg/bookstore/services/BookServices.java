package com.cg.bookstore.services;

import java.util.List;

import com.cg.bookstore.beans.Admin;
import com.cg.bookstore.beans.Author;
import com.cg.bookstore.beans.Books;
import com.cg.bookstore.beans.Category;
import com.cg.bookstore.beans.Comments;
import com.cg.bookstore.beans.Customers;
import com.cg.bookstore.beans.Orders;
import com.cg.bookstore.exceptions.AdmintNotFoundException;
import com.cg.bookstore.exceptions.AuthorNotFoundException;
import com.cg.bookstore.exceptions.BookNotFoundException;
import com.cg.bookstore.exceptions.CategoryNotFoundException;
import com.cg.bookstore.exceptions.CommentNotFoundException;
import com.cg.bookstore.exceptions.CustomerNotFoundException;
import com.cg.bookstore.exceptions.OrderNotFoundException;

public interface BookServices {
    Customers createNewCustomer(Customers customer);
    Customers getCustomerDetails(int customerId) throws CustomerNotFoundException;
    List<Customers> getAllCustomersDetails() ;
    boolean deleteCustomer(int customerId);

    Admin createNewAdmin(Admin admin);
    Admin getAdminDetails(int adminId) throws AdmintNotFoundException;
    List<Admin> getAllAdminDetails() ;
    boolean deleteAdmin(int adminId);
    
    Author createNewAuthor(Author author);
    Author getAuthorDetails(int authorId) throws AuthorNotFoundException;
    List<Author> getAllAuthorDetails();
    boolean deleteAuthor(int authorId);
    
    Books createNewBook(Books book) ;
    Books getBookDetails(int bookId) throws BookNotFoundException;
    List<Books> getAllBookDetails();
    boolean deleteBook(int bookId);

    Category createNewCategory(Category category) ;
    Category getCategoryDetails(int categoryId) throws CategoryNotFoundException;
    List<Category> getAllCategoryDetails();
    boolean deleteCategory(int categoryId);
    

    Comments createNewComment(Comments comment);
    Comments getCommentDetails(int commentId) throws CommentNotFoundException;
    List<Comments> getAllCommentDetails();
    boolean deleteComment(int commentId);
    
    Orders createNewOrder(Orders order);
    Orders getOrderDetails(int orderId) throws OrderNotFoundException;
    List<Orders> getAllOrderDetails();
    boolean deleteOrder(int orderId);

}

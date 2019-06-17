package com.cg.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bookstore.beans.Admin;
import com.cg.bookstore.beans.Author;
import com.cg.bookstore.beans.Books;
import com.cg.bookstore.beans.Category;
import com.cg.bookstore.beans.Comments;
import com.cg.bookstore.beans.Customers;
import com.cg.bookstore.beans.Orders;
import com.cg.bookstore.dao.AdminDao;
import com.cg.bookstore.dao.AuthorDao;
import com.cg.bookstore.dao.BooksDao;
import com.cg.bookstore.dao.CategoryDao;
import com.cg.bookstore.dao.CommentsDao;
import com.cg.bookstore.dao.CustomerDao;
import com.cg.bookstore.dao.OrdersDao;
import com.cg.bookstore.exceptions.AdminListEmptyException;
import com.cg.bookstore.exceptions.AdmintNotFoundException;
import com.cg.bookstore.exceptions.AuthorListIsEmptyException;
import com.cg.bookstore.exceptions.AuthorNotFoundException;
import com.cg.bookstore.exceptions.BookNotFoundException;
import com.cg.bookstore.exceptions.BooksListEmptyException;
import com.cg.bookstore.exceptions.CategoryListIsEmptyException;
import com.cg.bookstore.exceptions.CategoryNotFoundException;
import com.cg.bookstore.exceptions.CommentListEmptExceptions;
import com.cg.bookstore.exceptions.CommentNotFoundException;
import com.cg.bookstore.exceptions.CustomerListEmptyException;
import com.cg.bookstore.exceptions.CustomerNotFoundException;
import com.cg.bookstore.exceptions.OrderListEmptyException;
import com.cg.bookstore.exceptions.OrderNotFoundException;

import java.util.List;

@Component("bookServices")
public class BookServicesImpl implements BookServices {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BooksDao booksDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrdersDao ordersDao;



    /*CUSTOMER SERVICES*/
    @Override
    public Customers createNewCustomer(Customers customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customers getCustomerDetails(int customerId) throws CustomerNotFoundException {
        return customerDao.findById(customerId).orElseThrow(
                ()->new CustomerNotFoundException("Customer for the given details doesnt exist" ));
    }

    @Override
    public List<Customers> getAllCustomersDetails() {
        List<Customers> customers = customerDao.findAll();
        if(customers.isEmpty())
            throw new CustomerListEmptyException("No Customer Found");
        else
            return customers;
    }
  

	@Override
	public boolean deleteCustomer(int customerId) {
		customerDao.deleteById(customerId);
		return false;
	}

    /*ADMIN SERVICES*/
    @Override
    public Admin createNewAdmin(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public Admin getAdminDetails(int adminId) throws AdmintNotFoundException {
        return adminDao.findById(adminId).orElseThrow( ()-> new AdmintNotFoundException("Admin for the given details doesnt exist"));
    }

    @Override
    public List<Admin> getAllAdminDetails() {
        List<Admin> admins = adminDao.findAll();
        if(admins.isEmpty())
            throw new AdminListEmptyException("Admin list is empty");
        else
            return admins;
    }
    @Override
 	public boolean deleteAdmin(int adminId) {
    	Admin admin=getAdminDetails(adminId);
    	adminDao.delete(admin);
 		return false;
 	}


    /*AUTHOR SERVICES*/
    @Override
    public Author createNewAuthor(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Author getAuthorDetails(int authorId) throws AuthorNotFoundException {
        return authorDao.findById(authorId).orElseThrow( ()-> new AuthorNotFoundException("Author for the details does not exist"));
    }

    @Override
    public List<Author> getAllAuthorDetails() {
        List<Author> authors = authorDao.findAll();
        if(authors.isEmpty()){
            throw new AuthorListIsEmptyException("Author list is empty");
        }
        else
            return authorDao.findAll();
    }
    
    @Override
	public boolean deleteAuthor(int authorId) {
    	authorDao.deleteById(authorId);
		return false;
	}


    /*BOOK SERVICES*/
    @Override
    public Books createNewBook(Books book) {
        return booksDao.save(book);
    }

    @Override
    public Books getBookDetails(int bookId) throws BookNotFoundException {
        return booksDao.findById(bookId).orElseThrow(()-> new BookNotFoundException("Book doesnt exist for the given details"));
    }

    @Override
    public List<Books> getAllBookDetails() {
        List<Books> books = booksDao.findAll();
        if(books.isEmpty())
            throw new BooksListEmptyException("Book list is empty");
        else
            return books;
    }
    
    @Override
	public boolean deleteBook(int bookId) {
    	booksDao.deleteById(bookId);
		return false;
	}


    /*CATEGORY SERVICES*/
    @Override
    public Category createNewCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public Category getCategoryDetails(int categoryId) throws CategoryNotFoundException {
        return categoryDao.findById(categoryId).orElseThrow( ()-> new CategoryNotFoundException("Category for the given details doest exist"));
    }

    @Override
    public List<Category> getAllCategoryDetails() {
        List<Category> categories = categoryDao.findAll();
        if(categories.isEmpty())
            throw new CategoryListIsEmptyException("Category list is empty");
        else
            return categories;
    }

    @Override
	public boolean deleteCategory(int categoryId) {
		categoryDao.deleteById(categoryId);
		return false;
	}

    /*COMMENT SERVICES*/
    @Override
    public Comments createNewComment(Comments comment) {
        return commentsDao.save(comment);
    }

    @Override
    public Comments getCommentDetails(int commentId) throws CommentNotFoundException {
        return commentsDao.findById(commentId).orElseThrow(()-> new CommentNotFoundException("Comment doesnt exist for the given details"));
    }

    @Override
    public List<Comments> getAllCommentDetails() {
        List<Comments> comments = commentsDao.findAll();
        if(comments.isEmpty())
            throw new CommentListEmptExceptions("Comment list is empty");
        else
            return comments;
    }
    
    @Override
	public boolean deleteComment(int commentId) {
		commentsDao.deleteById(commentId);
		return false;
	}

    /*ORDER SERVICES*/
    @Override
    public Orders createNewOrder(Orders order) {
        return ordersDao.save(order);
    }

    @Override
    public Orders getOrderDetails(int orderId) throws OrderNotFoundException {
        return ordersDao.findById(orderId).orElseThrow( ()-> new OrderNotFoundException("Order doesnt exist for the given details"));
    }

    @Override
    public List<Orders> getAllOrderDetails() {
        List<Orders> orders = ordersDao.findAll();
        if(orders.isEmpty())
            throw new OrderListEmptyException("Order list is empty");
        else
            return orders;
    }
    
    @Override
	public boolean deleteOrder(int orderId) {
		ordersDao.deleteById(orderId);
		return false;
	}
	

}

package com.cg.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.beans.Admin;
import com.cg.bookstore.beans.Customers;
import com.cg.bookstore.exceptions.AdmintNotFoundException;
import com.cg.bookstore.exceptions.CustomerNotFoundException;
import com.cg.bookstore.services.BookServices;

@RestController
@CrossOrigin(origins = "http:localhost:4200")
public class BookStoreController {
	
	@Autowired
	BookServices bookServices;
	
	@RequestMapping(value= {"/sayHello"},method=RequestMethod.GET)
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("hello world ",HttpStatus.OK);
	}
	
	//CUSTOMER CONTROLLER
	@PostMapping(value="/newCustomer",consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE,headers="Accept=application/json")
	void newCustomer(@RequestBody Customers customer) {	
		bookServices.createNewCustomer(customer);
	}
	
	@GetMapping("/getCustomerDetails")
    public Customers getCustomerDetails(@RequestParam int customerId) throws CustomerNotFoundException{
        return bookServices.getCustomerDetails(customerId);
    }
	
	@RequestMapping(value="/getAllCustomerDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public List<Customers> findAllCustomers() {
		  return bookServices.getAllCustomersDetails();
	}

	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<String> removeCustomerDetails(@RequestParam int customerId) throws CustomerNotFoundException{
		bookServices.deleteCustomer(customerId);
		return new ResponseEntity<>("Customer details successfully removed ",HttpStatus.OK);
	}

	//ADMIN CONTROLLER
	@PostMapping(value="/newAdmin",consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	void newAdmin(@RequestBody Admin admin) {	
		bookServices.createNewAdmin(admin);
	}
	
	@GetMapping("/getAdminDetails")
    public Admin getAdminDetails(@RequestParam int adminId) throws AdmintNotFoundException{
        return bookServices.getAdminDetails(adminId);
    }
	
	@GetMapping(value="/getAllAdminDetails",produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public List<Admin> findAllAdmin() {
		  return bookServices.getAllAdminDetails();
	}

	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<String> removeAdminDetails(@RequestParam int adminId) throws AdmintNotFoundException{
		bookServices.deleteAdmin(adminId);
		return new ResponseEntity<>("Customer details successfully removed ",HttpStatus.OK);
	}
}

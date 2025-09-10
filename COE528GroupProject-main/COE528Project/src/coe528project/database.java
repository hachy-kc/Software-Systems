/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;    

/**
 *
 * @author Yadu
 */
public class database {
    
    private static FileWriter bookList, customerList;
    private static database instance;
            
    private database() {} 
            
    private static database getInstance(){
        if (instance == null) {
            instance  = new database();
            try{
                bookList = new FileWriter("books.txt");
                customerList =  new FileWriter("customers.txt");
            }
            catch (IOException e){
                System.out.println("An error occured.");
                e.printStackTrace();
            }
            return instance;
        }
        return instance;
    }
    
    //this method is invoked during the intial program compilation to load in the Customers's data into the application
    //Effects: returns an ArrayList of Customer.
    
    public ArrayList<User> loadCustomer() {
        
        ArrayList<User> customers = new ArrayList<>();
        try{
            customerList.close();
            int loginCount, points;
            String username, password, status;
            double transactionCost;
            File customerFile = new File(".\\customers.txt");
            Scanner read = new Scanner(customerFile);
            read.useDelimiter("\n");
            while (read.hasNext()) {
                username = read.next();
                password = read.next();
                points = Integer.parseInt(read.next());
                status = read.next();
                transactionCost = Double.parseDouble(read.next());
                loginCount = Integer.parseInt(read.next());
                User customer = new User(username, password);
                customers.add(customer);
            }
        }
        catch(IOException e){
            System.out.println("An error has occured");
            e.printStackTrace();
        }
            
        return customers;
    }
    
    //this method is invoked during the intial program compilation to load in the Book's data into the application
    //Effects: returns an ArrayList of Book.
    
    public ArrayList<Book> loadBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try{            
            bookList.close();
            String bookName = "";
            double Price = 0;
            File bookFile = new File(".\\books.txt");            
            Scanner read = new Scanner(bookFile);
            read.useDelimiter("\n");
            
            while (read.hasNext()) {
                bookName = read.next();
                Price = Double.parseDouble(read.next());
                Book book = new Book(bookName, Price);
                books.add(book);        
            }
            read.close();
        }
        catch(IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
        
        return books;
    }
    
    //this method is invoked to update the BookList database when the application closes. 
    //Effects: Updates the database (Books.txt)   
    
    public void updateBookList(ArrayList<Book> books) {
        
        try{
            for (Book book: books)
                bookList.write(book.getBookName() + "\n" + book.getBookPrice() + "\n");  
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }       
        
    }
    
    
    //this method is invoked to update the CustomerList database when the application closes. 
    //Effects: Updates the database (Customers.txt)  
    
    public void updateCustomerList(ArrayList<User> customers) throws IOException {
        for (User customer: customers)
            customerList.write(customer.getUsername() + "\n" + customer.getPassword() + "\n" + customer.getPoints() + "\n");       
        
    } 

    
}
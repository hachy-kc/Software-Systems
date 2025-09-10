package coe528project;



import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yadu
 */
public class Book {
    private String bookName;
    private double bookPrice;
    CheckBox remark = new CheckBox();
    database x = database.getInstance();
    static ArrayList<Book> books = new ArrayList<>();     

    public Book() {
        
    }
        
    public void add(Book B) {
        books.add(B);
        //System.out.println("Book," + B.getBookName() + "has been added");
    }
    
    public void delete(Book B) {
        books.remove(B);
        //System.out.println("Book," + B.getBookName() + "has been removed");
    }
    
    public ArrayList<Book> getList(){
        return books;
    }
    public Book(String bookName, double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }
    
    public String getBookName() {
        return this.bookName;
    }
    
    public double getBookPrice() {
        return  this.bookPrice;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    
    /*@Override
    public String toString() {
        return "Book Name: " + this.bookName + "\nBook Price: " + this.bookPrice;
    }
    
    public static void main(String[] args) {
        Book test = new Book("test", 25.0);
        
        System.out.println(test);
    }*/

    public CheckBox getRemark() {
        return remark;
    }

    public void setRemark(CheckBox remark) {
        this.remark = remark;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

/**
 *
 * @author Yadu
 */
public class Book {
    private String bookName;
    private double bookPrice;
    
    public Book(String bookName, double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }
    
    public String getBookName() {
        return this.bookName;
    }
    
    public double getBookPrice() {
        return this.bookPrice;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    
    @Override
    public String toString() {
        return "Book Name: " + this.bookName + "\nBook Price: " + this.bookPrice;
    }
    
    public static void main(String[] args) {
        Book test = new Book("test", 25.0);
        
        System.out.println(test);
    }
    
}

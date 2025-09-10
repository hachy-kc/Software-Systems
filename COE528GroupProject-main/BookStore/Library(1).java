/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.util.ArrayList;

/**
 *
 * @author Yadu
 */
public class Library {
    
    private Boolean select;
    private ArrayList<Book> books;
    
    public Library() {
        books = new ArrayList<>();
    }
     
        
    public void add(Book B) {
        books.add(B);
        //System.out.println("Book," + B.getBookName() + "has been added");
    }
    
    public void delete(Book B) {
        books.remove(B);
        //System.out.println("Book," + B.getBookName() + "has been removed");
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Book B: books) {
            s += "Book Name: " + B.getBookName() + "\nBook Price: " + B.getBookPrice();

        }
        return s;
    }
    
}

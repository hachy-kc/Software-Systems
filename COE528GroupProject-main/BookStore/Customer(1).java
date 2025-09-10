/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore;

import java.util.ArrayList;

/**
 *
 * @author andrewsudyk
 */
public class Customer extends User{
    int points = 0;
    String status = "silver";
    int transactionCost = 0;
    int loginCount = 0;
    ArrayList<User> cart;
    
    
    public Customer(String username, String password, int points, String status, int transactionCost, int loginCount) {
        super(username, password);
        this.points = points;
        this.status = status;
        this.transactionCost = transactionCost;
        this.loginCount = loginCount;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(int transactionCost) {
        this.transactionCost = transactionCost;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }
    
    public void Buy(Book bookName,Customer C) { //this method to be repeated for each book that user selects, in the main method
        int currentBookPrice = bookname.getBookPrice();
        C.setTransactionCost(transactionCost + currentBookPrice);
        C.setPoints(currentBookPrice*10);
    }
    
    public void redeemPoints(Customer C) {
        if (transactionCost*100 >= points) {
            int tempStore = transactionCost;
            C.setTransactionCost(transactionCost - points/100);
            C.setPoints(0);
        } else if (transactionCost*100 < points) {
            int tempStore = points;
            C.setPoints(points - transactionCost*100);
            C.setTransactionCost(0);
        }
    }
    
    public void getStatus(Customer C) {
        if (points >= 1000) {
            C.setStatus("gold");
        } else {
            C.setStatus("silver");
        }
        
         @Override
        public String toString() {
            String s = "Welcome" + C.getUsername() + ". You have" + C.getPoints() +"points. Your status is" +C.getStatus();

        return s;
    }
            
    }
}

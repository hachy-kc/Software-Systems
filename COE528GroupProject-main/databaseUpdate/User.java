/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewsudyk
 */
//implement state pattern
public class User {
    private String username;
    private String password;
    private int points = 0;
    private purchase stats;
    private double transactionCost = 0;
    static ArrayList<User> users = new ArrayList<>();
    database x = database.getInstance();
    
    //private String UsernameInput; //temporary variable to store Scanner username input
    //private String PasswordInput; //temporary variable to store Scanner password input
    
    //public String currentlyLoggedUser; //to keep track of currently logged user
    //public boolean currentlyLoggedAdmin; //only true when admin logs in
    
    
    public User() {
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean login(String U, String P) {
        return users.stream().anyMatch((now) -> (U.equals(now.getUsername()) && P.equals(now.getPassword())));
    }
    
    public void register (User C) {
        users.add(C);
    }   
    
    public void unregister (User C) {
        users.remove(C);
    }
    
    public ArrayList<User> getList (){
        return users;
    }
    /*
    public void logout() {
        currentlyLoggedUser = null;
        currentlyLoggedAdmin = false;
         //end session
    }
*/
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
        x.updateCustomerList(this.getList());
    }
    /*
    public String getStatus() {
        return status;
    }
    */
    public double getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(double transactionCost) {
        this.transactionCost = transactionCost;
    }
    //maybe this should be another file
    public User findUser (String U){
        
        for (User now: users)//cycles through all users
            if (U.equals(now.getUsername()))
                return now;
        return null;
    }
    /*
    public void Buy(Book bookName,Customer C) { //this method to be repeated for each book that user selects, in the main method
        double currentBookPrice = bookName.getBookPrice();
        C.setTransactionCost(transactionCost + currentBookPrice);
        C.setPoints((int) (currentBookPrice*10));
    }
    
    public void redeemPoints(Customer C) {
        if (transactionCost*100 >= points) {
            int tempStore = (int) transactionCost;
            C.setTransactionCost(transactionCost - points/100);
            C.setPoints(0);
        } else if (transactionCost*100 < points) {
            int tempStore = points;
            C.setPoints(points - transactionCost*100);
            C.setTransactionCost(0);
        }
    }
    */
    public String getStatus() {
        if (points >= 1000) 
            return("gold");
        else 
            return("silver");
    }
    
    public purchase getStats() {
        return stats;
    }

    public void setStats1() {
        stats = new buy();
    }
    
    public void setStats2() {
        stats = new redeem();
    }
}
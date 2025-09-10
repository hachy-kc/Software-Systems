/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author josh
 */
public class SilverCustomer extends Customer {
    private String username;
    private String password;
    private int bal;
    
    /*OVERVIEW: creates a customer with the silver class 
    REQUIRES: a username, password, and a balance
    EFFECTS: sets the username password and balance to that of the customer
    */
    public SilverCustomer(String u, String pw, int bal){
        username = u;
        password = pw;
        this.bal = bal;
        
        /*
        OVERVIEW: same as above
        REQUIRES: makes sure u pw and bal arent null
        EFFECTS: sets u pw and bal to the variables username password and bal 
        */
    }

    @Override
    public boolean login(String user, String pass) {
        /* REQUIRES: user and pass cant be null
        EFFECTS: user and username must be equal and pass and password are equal
        it returns true if so
        */
        return(username.equals(user)&&password.equals(pass));
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public void deposit(int amount) {
        /*
        REQUIRES: a deposit amount greater than 0
        EFFECTS: adds the amount to balance
        */
        bal = bal + amount;
        
    }

    @Override
    public boolean withdraw(int amount) {
        /*
        REQUIRES: more than 0 in the account
        EFFECTS: subtracts amount from balance and returns true
        */
        if(amount <= bal){
            bal = bal - amount;
            return true;
        }
        return false;
    }

    @Override
    public String getUser() {
        /*
        REQUIRES: a username input
        EFFECTS: returns the username
        */
        return username;
    }

    @Override
    public String getPassword() {
        /*
        REQUIRES: a password input
        EFFECTS: returns the password
        */
        return password;
    }

    @Override
    public int getBal() {
        /*
        REQUIRES: a balance greater than 0
        EFFECTS: returns the balance
        */
        return bal;
    }

    @Override
    public boolean purchase(int amount) {
        /*
        REQUIRES: a balance greater than the purchase amount
        EFFECTS: subtracts the amount of the purchase from the balance
        Since the customer is silver they pay a $20 fee and the order must be 
        over $50*/
        if (amount >= 50 && amount <= bal){
            bal = bal - amount - 20;
            return true;
        }
        return false;          
    }
    
    public boolean repOk(){
        /*
        REQUIRES: username and password to be null 
        EFFECTS: returns false if bal > 10000
        */
        if(username.equals("")||password.equals("")||bal>= 10000){
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        /*REQUIRES: the customer to be a silver client
        EFFECTS: returns the string rep of a silver object        
        */
        return "Username: " + username + "\nPassword: "+ password + "\nBalance: "+ bal + "Level: Silver";
    }
}

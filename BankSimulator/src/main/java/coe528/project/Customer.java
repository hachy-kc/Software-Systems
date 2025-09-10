/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.io.IOException;

/**
 *
 * @author stephen
 */
public class Customer extends User{
    
    private double balance;

    public Customer(String username, String password, double balance) {
        super(username, password);
        this.balance = balance;
    }
    
    @Override
    public boolean login(String inputUsername, String inputPassword){
        try{
            if (Authenticator.checkCustomer(username, password)){
                return true;
            }

            else{
                System.out.println("Failed");
                return false;
            }
        }
        
        catch(IOException e){
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    @Override
    public boolean logout(){
        return true;
    }
    
}

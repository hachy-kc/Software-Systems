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

import java.io.*;

public class Manager {
    
    private String username;
    private String password;
    private String dir = "customerFile";
    private int bal;
    private Customer current;
    
    /*
    Manager has 2 options
    Add a customer
    Delete a customer
    */

    public boolean verify(String u, String pw) { //this makes it able to have customers log in 
        boolean verification;
        verification = false; //verification needs to be false until proven the file exists
        try{
            FileReader readFile = new FileReader(dir + u + pw + ".txt");
            BufferedReader buffer1 = new BufferedReader(readFile);
            
            String line = buffer1.readLine();
            String info[] = line.split(", ");
            
            username = info[0];
            password = info[1];
            bal = Integer.parseInt(info[2]);
            
            Customer c1;
            if(bal < 10000){ //silver class verification
                c1 = new SilverCustomer(username, password, bal);
                if (c1.login(u, pw)){
                    current = c1;
                    verification = true;
                }
            } else if(bal >= 10000 && bal < 20000){ //Gold class verification
                c1 = new GoldCustomer(username, password, bal);
                if(c1.login(u, pw)){
                    current = c1;
                    verification = true;
                }
            } else if(bal > 20000){ //Platinum class verification
                c1 = new PlatinumCustomer(username, password, bal);
                if(c1.login(u, pw)){
                    current = c1;
                    verification = true;
                }
            } else {
                System.out.println("No money");
            }
             
        } catch (Exception e){
            System.out.println("User doesn't exist");
        } return verification;
      
    }
    
    public void addCustomer(String user, String pass) {
        String newDirectory = dir + user + pass + ".txt";
        File customerFile = new File(newDirectory);
        try {
            FileWriter writeToFile = new FileWriter(customerFile);
            BufferedWriter writer = new BufferedWriter(writeToFile);
            
            writer.write(user + ", " + pass + ", " + 100);
        
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error creating new user file.");
        }
    }
    
    public void deleteCustomer(String user, String pass){
        File dFile = new File(dir + user + pass + ".txt");
        try{
            if(dFile.delete()){
              System.out.println("deleted user");  
            } else{
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Error");
        }
    }
    
    public String level(){
        if(current instanceof SilverCustomer){
            return "Silver";
        } else if (current instanceof GoldCustomer){
            return "Gold";
        }
           else {
            return "Platinum";
        }
    }
    
    public boolean logout(){
        return current.logout();
    }
    
    public void updateCustomer(){
        try{
            FileWriter writeToFile = new FileWriter(dir + current.getUser() + ".txt");
            BufferedWriter writer = new BufferedWriter(writeToFile);
            
            writer.write(current.getUser() + ", " + current.getPassword() + ", " + current.getBal());
        
            writer.close();
        }
        catch(Exception e){
            System.out.println("Cant update");
        }
        //this class is mostly the same as verify method just because it connects with the current account
        if(current.getBal() < 10000){
            current = new SilverCustomer(current.getUser(),current.getPassword(), current.getBal());        
        }else if(current.getBal() >= 10000 && current.getBal() < 20000){
            current = new GoldCustomer(current.getUser(),current.getPassword(), current.getBal());
        }else if(current.getBal() > 20000){
            current = new PlatinumCustomer(current.getUser(),current.getPassword(), current.getBal());
        }else
            System.out.println("No money");  
    }
    
    
    public void deposit(int amount){
        current.deposit(amount);
        updateCustomer();           
    }
    
    public boolean withdraw(int amount){
        if(current.withdraw(amount)){
            updateCustomer();
            return true;
        }else{
            return false;
        }
    }
    
    public Customer getCurrent(){
        return current;
    }
    
    public int getBalance(){
        return current.getBal();
    }
    
    public boolean purchase(int amount){
        if(current.purchase(amount)){
            updateCustomer();
            return true;
        }else{
            return false;
        }
    }
}

    
    
    
    
    
    


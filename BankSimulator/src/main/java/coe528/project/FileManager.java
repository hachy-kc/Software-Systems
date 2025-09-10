/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author stephen
 */
public class FileManager {
    
    static String directory = "customers/";
    
    public static boolean writeCustomer(String username, String password, double balance, boolean loggedIn) throws IOException{
        
        File customer = new File(directory + username + ".txt");
        
        if(!customer.createNewFile()){
            customer.delete();
            customer.createNewFile();
        }
        
        FileWriter writer = new FileWriter(customer);
    
        try {
            writer.write(username + "\n");
            writer.write(password + "\n");
            writer.write(""+ balance + "\n");
            writer.write("" + loggedIn + "\n");

            writer.close();
            return true;
        }  
        
        catch (IOException e){
            System.out.println("Error: " + e);
            return false;
        }
    }  
    
    public static boolean removeCustomer(String username){
        File customer = new File(directory + username + ".txt");
        
        if (customer.exists()){
            System.out.println("Deleted");
            customer.delete();
            return true;
        }
        System.out.println("Customer doesn't exist");
        return false;
    }
    
}

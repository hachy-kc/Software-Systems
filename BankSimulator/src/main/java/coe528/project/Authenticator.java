/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author stephen
 */
public class Authenticator {
    
    public static boolean checkCustomer(String username, String password) throws IOException{
        File directory = new File("customers");
        File[] fileList = directory.listFiles();
        
        if (fileList != null){
            for (File customer : fileList){
                if (customer.getName().equals(username + ".txt")){
                    try{
                        Scanner scanner = new Scanner(customer);
                        String fileUsername = scanner.nextLine();
                        String filePassword = scanner.nextLine();
                        Double fileBalance = scanner.nextDouble();
                        
                        if(fileUsername.equals(username) && filePassword.equals(password)){
                            FileManager.writeCustomer(fileUsername, filePassword, fileBalance, true);
                            return true;
                        }
                        else{
                            FileManager.writeCustomer(fileUsername, filePassword, fileBalance, false);
                        }
                    } 
                    catch(FileNotFoundException e){
                        System.out.println("file not found");
                    }
                }   
            }
        }
        
        else{
            System.out.println("No customers on file");
        }
        
        return false;
    }
       
    public static boolean checkManager(String username, String inputUsername, String password, String inputPassword){
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

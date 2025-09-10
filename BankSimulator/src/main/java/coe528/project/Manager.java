/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 *
 * @author stephen
 */
public class Manager extends User{
    
    private static Manager instance;
    
    private Manager(){
       super("admin", "admin");
    } 
    
    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }
    
    @Override
    public boolean login(String inputUsername, String inputPassword){
        if (Authenticator.checkManager(username, inputUsername, password, inputPassword)){
            loggedIn = true;
            return true;
       }
       else{
            System.out.println("Failed");
            return false;
       }
    }   
    
    @Override
    public boolean logout(){
        loggedIn = false;
        return true;
    }
}

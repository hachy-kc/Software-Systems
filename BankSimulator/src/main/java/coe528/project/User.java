/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 *
 * @author stephen
 */
public abstract class User {
    
    protected String username;
    protected String password;
    protected boolean loggedIn;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }
    
    public boolean isLoggedIn(){
        return loggedIn;
    }
    
    protected String getUsername(){
        return username;
    }
    
    protected String getPassword(){
        return password;
    }
    
    public abstract boolean login(String inputUsername, String inputPassword);
       
    public abstract boolean logout();
    
    
}

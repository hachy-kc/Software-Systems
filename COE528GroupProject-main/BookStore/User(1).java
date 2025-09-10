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
public abstract class User {
    public String username;
    public String password;
    ArrayList<User> users;
    
    public String UsernameInput; //temporary variable to store Scanner username input
    public String PasswordInput; //temporary variable to store Scanner password input
    
    public String currentlyLoggedUser; //to keep track of currently logged user
    public boolean currentlyLoggedAdmin; //only true when admin logs in
    

    
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
    
    public void login(String U, String P) {
        for (int i=0;i<users.size();i++) {
            if (UsernameInput == "admin" && PasswordInput == "admin") { // checks if admin logged in
                currentlyLoggedUser = UsernameInput; //assigns admin as the active user
                currentlyLoggedAdmin = true; //flags this as admin user
            } else if
                (UsernameInput == users.get(i).username && PasswordInput == users.get(i).password) { //checks if inputted user credentials are correct or exist
                currentlyLoggedUser = UsernameInput; //assigns this user as the active user
            } else {
                System.out.println("incorrect login details, or user does not exist");
            }
        }
    }
    
    public void logout() {
        currentlyLoggedUser = null;
        currentlyLoggedAdmin = false;
         //end session
    }
}

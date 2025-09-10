/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookStore;

/**
 *
 * @author andrewsudyk
 */
public class Admin extends User {
    
    User A;

    public Admin() {
        this.A = new User("admin", "admin") {};
    }
    
    public void register (Customer C) {
        users.add(C);
    }
    
    public void unregister (Customer C) {
        users.remove(C);
    }
   
}

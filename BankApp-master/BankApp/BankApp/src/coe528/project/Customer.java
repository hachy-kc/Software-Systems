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

// this class is abstract as there is 3 sub sections of Customer
/*
Since there is silver, gold, platinum all we need in this class
is to abstract methods that translate to the sub classes that 
deal with the levels of classes
*/
public abstract class Customer {
    abstract public boolean login(String user, String pass);
    abstract public boolean logout();
    abstract public void deposit(int amount);
    abstract public boolean withdraw(int amount);
    abstract public String getUser();
    abstract public String getPassword();
    abstract public int getBal();
    abstract public boolean purchase(int amount);
   
    
}

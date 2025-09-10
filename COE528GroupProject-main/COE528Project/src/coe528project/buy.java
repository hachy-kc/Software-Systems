/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

/**
 *
 * @author Citizen Kane
 */
public class buy extends purchase{

    public buy() {
    }

    @Override
    public String standing(User current, double money) {
        current.setPoints((int) (current.getPoints() + Math.round(money * 10)));
        return ("Points: " + current.getPoints() + ", Status: " + current.getStatus());
    }
    
    @Override
    public String cost(User current, double money) {
        return ("Total Cost: $" + money);
    }
    
}

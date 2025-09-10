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
public class redeem extends purchase{
    
    database x = database.getInstance();
    
    public redeem() {
    }

    @Override
    public String standing(User current, double money) {
        if (current.getPoints()>=money*100){
            current.setPoints((int) (current.getPoints() - Math.round(money * 100)));
        }
        else{
            money -= current.getPoints()/100;
            current.setPoints((int) Math.round((money*10)));
        }    
        return ("Points: " + current.getPoints() + ", Status: " + current.getStatus());
    }

    @Override
    public String cost(User current, double money) {
        if (current.getPoints()>=money*100)
            return ("Total Cost: $" + 0);
        else
            money -= current.getPoints()/100;
        return ("Total Cost: $" + money);
    }
    
}
package coe318.lab4;

/**
 *
 * @author Hachi Ndu
 */
public class Account {

    private String name;
    private int accnumber;
    private double balance;

    public Account(String name, int number, double initialBalance){
        this.name = name;
        this.accnumber = number;
        balance = initialBalance;

    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.accnumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount){
        if(amount <=0) {
            return false;
        }else {
            this.balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount){
        if((this.balance - amount) >= 0 && amount > 0){
            this.balance -= amount;
            return true;
        }else{
            return false;
        }
    }


    @Override
    public String toString() {//DO NOT MODIFY
        return "(" + getName() + ", " + getNumber() + ", " +
            String.format("$%.2f", getBalance()) + ")";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

/**
 *
 * @author lphew01550
 */
public class VoltageSource extends Components {
    private static int numVol = 1;
    private int identity;
 
     /**
      * This constructor assignees the instance variables of the voltage source
      * after checking if it is correct.
     * @param voltage
     * @param node1
     * @param node2
      */
    public VoltageSource(double voltage, int node1, int node2){
        if (voltage==0){
            throw new IllegalArgumentException("Voltage can't be zero");
        }
        else if (node1<0){
            throw new IllegalArgumentException("The first node can't be negative");
        }
        else if (node2<0){
            throw new IllegalArgumentException("The second node can't be negative");
        }
        else{
            this.a = node1;
            this.b = node2;
            this.value = voltage;
            this.identity = numVol;
            numVol ++;
        }
    }
    
     /**
     * Prints the string representation of the voltage source.
     */
    @Override
    public String toString() {
        String s = "V" + this.identity + " " + this.a + " " + this.b + " DC " + this.value;
        return s;
    }
}
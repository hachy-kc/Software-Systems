/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex6_3;

import java.util.Scanner;

/**
 * A program to check if a given integer is a palindrome without converting it to a string.
 *
 * @author user
 */
public class Ex6_3 {

    // Main method to execute the program
    public static void main(String[] args) {
        
        // Creating a Scanner object for user input
        Scanner input = new Scanner(System.in);
        
        
        // Prompting the user to enter a number
        System.out.print("Enter a number: ");
        
        // Reading the input number provided by the user
        int num = input.nextInt();
        
        // Displaying the result of checking whether the number is a palindrome
        System.out.println("Is " + num + " a palindrome? " + isPalindrome(num) );
    }
    
    // Method to reverse an integer
    public static int reverse(int number) {
        int rev = 0;
        
        while (number > 0 ){
            rev = (rev * 10) + (number % 10);
            number = number / 10;
        }
        
        return rev;
    }
    
    // Method to check if an integer is a palindrome
     public static boolean isPalindrome(int number) {
        
        if ( reverse(number) == (number)){
            
            return true;
        }
        
        else
        
        return false;
    }   

    
}
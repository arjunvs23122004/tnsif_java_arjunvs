
package com.tnsif.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchDemo {
	public static void main(String[] args) {
		System.out.println("I am in main method");
		int numberOne, numberTwo, numberThree;
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("Enter First number: ");
				numberOne = sc.nextInt();
				System.out.println("Enter Second number: ");
				numberTwo = sc.nextInt();
				numberThree = numberOne / numberTwo;
				System.out.println("Division is " + numberThree);
				
			} catch (InputMismatchException e) {
				
				System.out.println("Invalid input. Please enter integers only.");
				sc.nextLine();
			} catch (ArithmeticException e) {
				System.out.println("Exception caught: " + e.getMessage());
				
			} catch (Exception e) {
				System.out.println("Exception caught: " + e.getMessage());
				
			}
		}
	}
}

package odd_number_exception;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int input = sc.nextInt();
		try{
			ValidateInteger validate = new ValidateInteger(input);
			validate.validate();
		} catch(OddNumberException e){
			System.out.println("Exception Occurred: " + e);
		}
	}
}

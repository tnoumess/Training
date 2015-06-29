package day1;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input;
		boolean exit=false;
		/*
		 * Generate positive integer <= 100 
		 */
		int n=(new Random()).nextInt(100)+1;
		int counter=0;
		do{			
			if(counter>0)
				System.out.println("Please try again!");
			System.out.println("Enter a random number in the range [0-100]:");
			Scanner scan=new Scanner(System.in);
			try{
				input = Integer.parseInt(scan.nextLine());
				counter++;
			}catch(Exception e){
				counter++;
				System.out.println("Bad input!");
				continue;
			}
			if((n-input)*(input-n)>-100){
				System.out.println("Random number generated is:"+n);
				exit=true;
			}
		}while(exit==false&&counter<5);
		if(exit!=true)
			System.out.println("sorry:"+n);

	}

}

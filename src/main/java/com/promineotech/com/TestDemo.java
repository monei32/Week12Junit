package com.promineotech.com;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		
		if ( a <= 0 || b <= 0) {
			throw new IllegalArgumentException( "Both parameters must be positive!");
		}
		return a + b; 	
	}  


   public int subtractPositive(int a, int b) {
	   
	   if (a <= 0 || b <= 0 ) {
		   throw new IllegalArgumentException("Both parameters must be positive!");
	   } 
	       return a - b; 
      }
   
   //Method will check if both numbers are positive. If the numbers are positive it will subtract the values 

   public static int getRandomInt() {
	    Random random = new Random();
	    return random.nextInt(10) + 1;
	  }

	  public static int randomNumberSquared() {
	    int randomNumber = getRandomInt();
	    return randomNumber * randomNumber;
	  }
	}
   
   

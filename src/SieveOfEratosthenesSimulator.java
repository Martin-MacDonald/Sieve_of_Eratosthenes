package com.martin_bolton_macdonald;
import com.martin_bolton_macdonald.PrimeCalc;

public class SieveOfEratosthenesSimulator {
	
	public static void main(String[] args){
		
		PrimeCalc pc = new PrimeCalc(10000);
		
		System.out.println(pc.getPrimeNumbersArray());
		
	}
	
}
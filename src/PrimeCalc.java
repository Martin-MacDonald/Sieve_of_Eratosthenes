package com.martin_bolton_macdonald;
import java.util.ArrayList;

public class PrimeCalc{
	
	private ArrayList<Integer> primeNumbersArray = new ArrayList<>();
	private int calcLimit;
	
	public PrimeCalc(int calcLimit){
		
		this.calcLimit = calcLimit;		
		calculatePrimeNumbers();
	}
	
	private void calculatePrimeNumbers(){

		for (int i = 2; i <= calcLimit; i++){
			
			boolean isPrime = true;
			
			for (int j = 2; j < i; j++){
				if (i % j == 0){
					isPrime = false;
					break;
				}				
			}
			
			if(isPrime){
				primeNumbersArray.add(i);
			} 
			
		}
		
		
	}
	
	public int getCalcLimit(){
		return this.calcLimit;
	}
	
	public ArrayList<Integer> getPrimeNumbersArray(){
		return this.primeNumbersArray;
	}
	
}
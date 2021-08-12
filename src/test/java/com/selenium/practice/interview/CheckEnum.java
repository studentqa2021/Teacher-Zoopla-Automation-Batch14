package com.selenium.practice.interview;

import java.util.Scanner;

public class CheckEnum {

	public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
	    THURSDAY, FRIDAY, SATURDAY 
	}	
	

	
	   public static void main(String[] args) {
	
	   Scanner scanner = new Scanner(System.in);
	    System.out.println("Please enter your day name");
	   
	    Day day = Day.valueOf(scanner.nextLine());
	   
	        switch (day) {
	            case MONDAY: 
	                System.out.println("Mondays are bad.");
	                break;

	            case FRIDAY: 
	                System.out.println("Fridays are better.");
	                break;

	            case SATURDAY:
	            case SUNDAY: 
	                System.out.println("Weekends are best.");
	                break;

	            default: 
	                System.out.println("Midweek days are so-so.");
	                break;
	        }
	        scanner.close();
	    }
	}

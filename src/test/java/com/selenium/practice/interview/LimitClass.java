package com.selenium.practice.interview;

public class LimitClass {

    private static LimitClass limInstance;
    public static int objCount=0;

    private LimitClass(){
    	System.out.println("Singleton(): Private constructor invoked");
        objCount++;
    }

    public static synchronized LimitClass getLimInstance(){
    	
        if(objCount<2 ){
            limInstance = new LimitClass();
            
        }
        else {
        	limInstance = null;
        }
        return limInstance;
    }
    
    public static void main(String[] args) {

    	LimitClass obj1= LimitClass.getLimInstance();
        LimitClass obj2 = LimitClass.getLimInstance();
        LimitClass obj3 = LimitClass.getLimInstance();
        LimitClass obj4 = LimitClass.getLimInstance();
        LimitClass obj5 = LimitClass.getLimInstance();
        LimitClass obj6 = LimitClass.getLimInstance();

        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println(obj3);
        System.out.println(obj4);
        System.out.println(obj5);
        System.out.println(obj6);
      }
}
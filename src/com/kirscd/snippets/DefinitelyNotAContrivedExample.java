package com.kirscd.snippets;

public class DefinitelyNotAContrivedExample {
    public static double divideForgiveness(int a, int b) {
        if (b == 0) return 0; //prevent divide by 0 errors
        return (double)a / (double)b;
    }
    
    public static double divideFailFast(int a, int b) {
        if(b == 0) throw new IllegalArgumentException("Attempted to divide by 0.");
        return (double)a / (double)b;
    }
    
    public static void main(String args[]) {
        System.out.println(divideForgiveness(0, 5));
        //no indication we tried to do something stupid
        System.out.println(divideForgiveness(5, 0)); 
        System.out.println(divideFailFast(0, 5));
        //forces us to acknowledge what we are doing is stupid
        System.out.println(divideFailFast(5, 0));
    }
}


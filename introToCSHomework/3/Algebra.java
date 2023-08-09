// Represents algebraic operations as functions.
public class Algebra {
	public static void main(String args[]) {
	    // Some tests of the class functions
	    System.out.println(plus(2,3));           // 2 + 3
	    System.out.println(minus(7,2));          // 7 - 2    
 		System.out.println(times(3,4));          // 3 * 4
 		System.out.println(div(5,3));            // 5 / 3    
   		System.out.println(div(3,5));            // 3 / 5
   		System.out.println(div(4,4));            // 4 / 4
   		System.out.println(div(14,7));           // 14 / 7
   		System.out.println(mod(5,3));            // 5 % 3    
   		System.out.println(pow(5,4));            // 5 ^ 4
   		System.out.println(sqrt(36));            // sqrt(36)
   		System.out.println(sqrt(76123));         // sqrt(76123)
   		System.out.println(times(2,plus(4,3)));  // 2 * (4 + 3)
   		int b = 5, c = 3;
   		System.out.println(minus(pow(b,2),times(4,c))); // b * b - 4 * c
   	}  

	// Returns x1 + x2.
	// Assumption: x1 and x2 are nonnegative.
   	public static int plus(int x1, int x2) {
		// Replace the return statement with your code.
   		for (int i = 0; i< x2 ; i++ ) {
   			x1++ ;


   		}
   		return x1;
   	}

	// Returns x1 - x2.
	// Assumption: x1 and x2 are nonnegative, and x1 >= x2.
   	public static int minus(int x1, int x2) {
		// Replace the return statement with your code.
   		for (int i = 0; i<x2 ; i++ ) {
   			x1-- ;
   		}
   		return x1;
   	}

	// Returns x1 * x2.
	// Assumption: x1 and x2 are nonnegative.
   	public static int times(int x1, int x2) {
        // Replace the return statement with your code.
   		int temp = 0;
   		for (int i = 0; i<x2 ; i++ ) {
   			temp = plus(temp,x1);


   		}
   		return temp ;
   	}

	// Returns x^n.
	// Assumption: x and n are nonnegative.
   	public static int pow(int x, int n) {
		// Replace the return statement with your code.
   		if (n==0) {
   			int one = 1;
   			return one;
   		}else {	
   			int temp1 = x;
   			for (int i = 1 ; i<n ; i++ ) {
   				temp1 = times(temp1,x);
   			}

   			return temp1;	 

   		}
   	}

	// Returns x1 / x2 (integer division). 
	// Assumption: x1 is nonnegative, x2 is positive.
   	public static int div(int x1, int x2) {
       // Replace the return statement with your code.
   		int ans = 0;
   		if (x2>x1) {
   			ans = 0 ; 
   		} else {	
   			for ( int i = 1; i<= x1 ; i++ ) {
   				if (times(i,x2)==x1) {
   					ans =  i;
   					
   				} else if (times(i,x2)<x1 && times(plus(i,1),x2)>x1) {
   					ans = i;
   				}
   			}


   			
   		}
   		return ans;
   	}

	// Returns x1 % x2
	// Assumption: x1 is nonnegative, x2 is positive.
   	public static int mod(int x1, int x2) {
        // Replace the return statement with your code.
   		
   		int ans =  x1-times(div(x1,x2),x2);
   		return ans;	
   	}	

	// Returns the integer part of sqrt(x) 
	// Assumption: x >= 1.
   	public static int sqrt(int x){
        // Replace the return statement with your code.
   		int ans = 0;
   		int i   = 1;
   		while (pow(i,2) <= x) {
   			i++;
   			ans++;
   		}
   		
   		return ans;	
   	}	  	  
}

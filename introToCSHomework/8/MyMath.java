/** A library of commonly used mathematical operations.
 */
public class MyMath {

    // For each one of the three method names listed below, 
    // write the method signature, document the method,
    // and write its implementation.
    // The documentation should be done in JavaDoc.
    // Use the same documentation style we used in Fraction.java. 

    /** gcd */
    /** Returns the greatest common divisor of two positive numbers.
     * Uses Euclid's algorithm.
     */
    public static int gcd(int x, int y) {
        int rem;
        while (y != 0) {
            rem = x % y;
            x = y;
            y = rem;
        }
        return x;
    }

    /** commonDenominator */
    public static int commonDenominator(Fraction x,Fraction y) {
        if (x.getDenominator() % y.getDenominator() == 0) {
            return x.getDenominator();
        }
        if (y.getDenominator() % x.getDenominator() == 0) {
            return y.getDenominator();
        }
        return x.getDenominator() * y.getDenominator();
    }





    /** max */
    public static Fraction max(Fraction x , Fraction y) {
        if(x.compareTo(y) == 0 ){
            return x ;
        }
        if(x.compareTo(y) == -1 ){
            return y ;
        }
        return x;
    }

}
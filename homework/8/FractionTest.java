/** Tests the Fraction and MyMath methods described in Homework 8.
 */
public class FractionTest {

    // Some representative Fraction objects, used in the various tests written in this class.
    static Fraction half = new Fraction(1,2);
    static Fraction minusHalf = new Fraction(-1,2);
    static Fraction quarter = new Fraction(1,4);
    static Fraction minusQuarter = new Fraction(-1,4);
    static Fraction third = new Fraction(1,3);
    static Fraction twoThirds = new Fraction(2,3);
    static Fraction zero = new Fraction(0,1);

    public static void main(String args[]) {
        ///testFraction();
        ///testAbs();
        ///testSignum();
        ///testConvert();
        ///testSubtract();
        ///testCompareTo();
        ///testEquals();
        ///testPow();
        ///testRandomFraction();
        ///testCommonDenominator();
        ///testMax();
    }

    private static void testFraction() {
        // Use this function for writing code that creates and manipulates Fraction objects.
        // You can use the static Fraction objects declared above, but make sure to practice  
        // creating some Fraction objects of your own.
    }

    private static void testAbs() {
        System.out.println("Testing the abs function:");
        System.out.println("abs(" + half + ") = " + half.abs());
        // Complete the testing code here.
        System.out.println("Testing the abs function:");
        System.out.println("abs(" + minusQuarter + ") = " + minusQuarter.abs());
    }

    private static void testSignum() {
        // Complete the testing code here.
        System.out.println("" + quarter.signum());
        System.out.println("" + zero.signum());
        System.out.println("" + minusHalf.signum());


    }

    private static void testConvert() {
       // Complete the testing code here.
        System.out.println("" + quarter.convert());
        System.out.println("" + zero.convert());
        System.out.println("" + minusHalf.convert());

    }

    private static void testSubtract() {
        // Complete the testing code here.
        System.out.println("" + twoThirds.subtract(third));
        System.out.println("" + zero.subtract(minusHalf));

    }

    private static void testCompareTo() {
        // Complete the testing code here.
        Fraction twoquarters = new Fraction(2,4);
        System.out.println("" + half.compareTo(twoquarters));
        System.out.println("" + minusHalf.compareTo(third));
    }

    private static void testEquals() {
        // Complete the testing code here.
    }

    private static void testPow() {
        // Complete the testing code here.
        System.out.println("" + third.pow(3));
        System.out.println("" + minusQuarter.pow(2));
        System.out.println("" + twoThirds.pow(4));
    }

    private static void testRandomFraction() {
        // Complete the testing code here.
        System.out.println(""+ new Fraction(7));
    }

    private static void testCommonDenominator() {
        // Complete the testing code here.
    }

    private static void testMax() {
        // Complete the testing code here.
    }    
}
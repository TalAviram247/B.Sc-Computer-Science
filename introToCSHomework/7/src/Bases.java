public class Bases {

    public static void main(String[] args) {
        // Put your tests here. For example:
        System.out.println(convert(26, 6));
        System.out.println(convert(234, 3));
        System.out.println(convert(767, 10));
        System.out.println(convert(26, 2));

    }

    // Returns the representation of the given decimal number (x) using the given base.
    // For example, convert(17, 2) returns "10001".
    // Assumes that x is nonnegative, and base is nonnegative and not greater than 10.
    public static String convert(int x, int base) { 
        // Replace the following statement with your code:

        if (x / base == 0){
            return "" + (x % base);
        } else {
            return ""  + convert(x / base, base) + (x % base);

        }



    }
}

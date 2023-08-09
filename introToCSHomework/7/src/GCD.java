public class GCD {
    public static void main(String[] args) {
        // Put your tests here. For example:
        System.out.println(gcd(56, 42));
    }

    // Computes the Greatest Common Denominator of the two given integers.
    // Assumes that a is nonnegative and b is greater than 0.
    public static int gcd(int a, int b) {
        // Replace the following statement with your code:
        if (a == b) {
            return a;
        }else if (a > b) {
            return gcd(a-b,b);

        }else if (a < b) {
            return gcd(a,b-a);
        }
        return 0;
    }

}

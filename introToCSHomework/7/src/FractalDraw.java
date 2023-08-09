public class FractalDraw {

    public static void main(String[] args) {
        // Put your testing code here. For example:
        drawCarpet(4);
    }

    // Draws a Sierpinski Carpet fractal of depth n, in the unit square.
    // The initial square is centered at coordinates (0.5, 0.5),
    // and the length of its edge (size) is 1.0/3.0.
    // Assumes that n is nonnegative. 
    public static void drawCarpet(int n) {
        // Write your code here:
        drawCarpet(0.5, 0.5, (1.0 / 3.0), n);
    }

    private static void drawCarpet(double x, double y, double size, int n) {
        // Write your code here:
        if (n == 0) {
            return;
        }
        StdDraw.filledSquare(x, y, size / 2);

        drawCarpet(x - size, y, size / 3, n - 1);
        drawCarpet(x + size, y, size / 3, n - 1);
        drawCarpet(x, y - size, size / 3, n - 1);
        drawCarpet(x, y + size, size / 3, n - 1);
        drawCarpet(x - size, y - size, size / 3, n - 1);
        drawCarpet(x - size, y + size, size / 3, n - 1);
        drawCarpet(x + size, y - size, size / 3, n - 1);
        drawCarpet(x + size, y + size, size / 3, n - 1);

    }
}




import java.awt.Color;

/**
 * Demonstrates the morphing service of Instush.java.
 * The program recieves three command-line arguments: the name of a PPM file
 * that represents the source image (a string), the name of a PPM file that represents
 * the target image (a string), and the number of morphing steps (an int).
 * For example:
 * java Editor3 cake.ppm ironman.ppm 300
 * If the two images don't have the same dimensions, the program scales the target image
 * to the dimensions of the source image.
 */
public class Editor3 {

	public static void main (String[] args) {
		// Write your code here
		String filename1 = args[0];
		String filename2 = args[1];
		int steps = Integer.parseInt(args[2]);

		Color[][] image1 = Instush.read(filename1);
		Color[][] image2 = Instush.read(filename2);

		// If width or height differ, scale the target picture
		if ((image1.length != image2.length) || (image1[0].length != image2[0].length )){

			image2 = Instush.scaled(image2,image1[0].length, image1.length);
		}

		Instush.morph(image1,image2,steps);
	}
}

import java.awt.Color;

/**
 * A library of image processing functions.
 */
public class Instush {

	public static void main(String[] args) {
		// Can be used for testing, as needed.
		Color[][] image_test = read("cake.ppm");
		show(image_test);

	}

	/**
	 * Returns an image created from a given PPM file.
	 * SIDE EFFECT: Sets standard input to the given file.
	 * @return the image, as a 2D array of Color values
	 */
	public static Color[][] read(String filename) {
		StdIn.setInput(filename);
		// Reads the PPM file header (ignoring some items)
		StdIn.readString();
		int numCols = StdIn.readInt();
		int numRows = StdIn.readInt();
		StdIn.readInt();
		// Creates the image
		Color[][] image = new Color[numRows][numCols];
		// Reads the RGB values from the file, into the image.
		// For each pixel (i,j), reads 3 values from the file,
		// creates from the 3 colors a new Color object, and
		// makes pixel (i,j) refer to that object.
		// Replace the following statement with your code
		for(int i = 0 ; i < numRows  ; i++ ){
			for(int j = 0 ; j < numCols ; j++){
				int red = StdIn.readInt();
				int green = StdIn.readInt();
				int blue = StdIn.readInt();
				image[i][j] = new Color(red,green,blue);
			}
		}
		return image ;
	}

	public static void println(Color c) {
		System.out.print("(");
		System.out.printf("%3s", c.getRed());    // Prints the red component
		System.out.print(",");
		System.out.printf("%4s", c.getGreen());  // Prints the green component
		System.out.print(",");
		System.out.printf("%4s", c.getBlue());   // Prints the blue component
		System.out.print(") ");
	}
	/**
	 * Prints the pixels of a given image.
	 * Each pixel is printed as a triplet of (r,g,b) values.
	 * For debugging purposes.
	 * @param image - the image to be printed
	 */
	public static void println(Color[][] image) {
		// Write your code here
		for (int i = 0; i < image.length ; i++) {
			for (int j = 0; j < image[i].length ; j++) {
				println(image[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Returns an image which is the horizontally flipped version of the given image.
	 * @param image - the image to flip
	 * @return the horizontally flipped image
	 */
	public static Color[][] flippedHorizontally(Color[][] image) {
		// Replace the following statement with your code
		Color[][] new_image = new Color[image.length][image[0].length];
		for(int i = 0 ; i < image.length; i++){
			for(int j = 0 ; j < image[i].length ; j++){
				new_image[i][j] = image[i][image[i].length-j-1];
			}
		}
		return new_image;
	}

	/**
	 * Returns an image which is the vertically flipped version of the given image.
	 * @param image - the image to flip
	 * @return the vertically flipped image
	 */
	public static Color[][] flippedVertically(Color[][] image){
		// Replace the following statement with your code
		Color[][] new_image = new Color[image.length][image[0].length];
		for(int i = 0 ; i < image.length ; i++){
			for(int j = 0 ; j < image[i].length ; j++){
				new_image[i][j] = image[image.length-i-1][j];
			}
		}
		return new_image;
	}


	/**
	 * Returns the average of the RGB values of all the pixels in a given image.
	 * @param image - the image
	 * @return the average of all the RGB values of the image
	 */
	public static double average(Color[][] image) {
		// Replace the following statement with your code
		double index_sum = 0;
		double total_sum = 0;
		for (int i = 0 ; i < image.length ; i++) {
			for (int j = 0 ; j < image[0].length ; j++) {
				index_sum += (image[i][j].getRed() + image[i][j].getGreen() + image[i][j].getBlue());
			}
		}
		total_sum = index_sum / (3*(image.length * image.length));
		return total_sum;
	}

	/**
	 * Returns the luminance value of a given pixel. Luminance is a weighted average
	 * of the RGB values of the pixel, given by 0.299 * r + 0.587 * g + 0.114 * b.
	 * Used as a shade of grey, as part of the greyscaling process.
	 * @param pixel - the pixel
	 * @return the greyscale value of the pixel, as a Color object
	 *         (r = g = b = the greyscale value)
	 */
	public static Color luminance(Color pixel) {
		// Replace the following statement with your code
		double green = pixel.getGreen() * 0.587;
		double red = pixel.getRed() * 0.299;
		double blue = pixel.getBlue() * 0.114;
		int lum = (int)(red + green + blue);
		Color new_pixel = new Color(lum , lum , lum);
		return new_pixel;
	}

	/**
	 * Returns an image which is the greyscaled version of the given image.
	 * @param image - the image
	 * @return rhe greyscaled version of the image
	 */
	public static Color[][] greyscaled(Color[][] image) {
		// Replace the following statement with your code
		Color[][] new_image = new Color[image.length][image[0].length];
		for(int i = 0 ; i < image.length ; i++){
			for(int j = 0 ; j < image[0].length ; j++){
				new_image[i][j] = luminance(image[i][j]);
			}
		}
		return new_image;
	}

	/**
	 * Returns an image which is the scaled version of the given image.
	 * The image is scaled (resized) to be of the given width and height.
	 * @param image - the image
	 * @param width - the width of the scaled image
	 * @param height - the height of the scaled image
	 * @return - the scaled image
	 */
	public static Color[][] scaled(Color[][] image, int width, int height) {
		// Replace the following statement with your code
		Color[][] scaled = new Color[height][width];
		int orgnl_height = image.length;
		int orgnl_width = image[0].length;


		for(int i = 0 ; i < height ; i++ ){
			for(int j = 0 ; j < width ; j++ ){
				int relative_height = i * orgnl_height / height ;
				int relative_width = j * orgnl_width / width ;
				int red = image[relative_height][relative_width].getRed();
				int green = image[relative_height][relative_width].getGreen();
				int blue = image[relative_height][relative_width].getBlue();

				scaled[i][j] = new Color(red,green,blue);
			}
		}

		return scaled;
	}

	/**
	 * Returns a blended color which is the linear combination of two colors.
	 * Each r, g, b, value v is calculated using v = (1 - alpha) * v1 + alpha * v2.
	 *
	 * @param c1 - the first color
	 * @param c2 - the second color
	 * @param alpha - the linear combination parameter
	 * @return the blended color
	 */
	public static Color blend(Color c1, Color c2, double alpha) {
		// Replace the following statement with your code
		double new_red = (alpha * c1.getRed()) + ((1 - alpha) * c2.getRed());
		double new_green = (alpha * c1.getGreen()) + ((1 - alpha) * c2.getGreen());
		double new_blue = (alpha * c1.getBlue()) + ((1 - alpha) * c2.getBlue());
		Color blended = new Color((int)new_red, (int)new_green , (int)new_blue);
		return blended;
	}

	/**
	 * Returns an image which is the blending of the two given images.
	 * The blending is the linear combination of (1 - alpha) parts the
	 * first image and (alpha) parts the second image.
	 * The two images must have the same dimensions.
	 * @param image1 - the first image
	 * @param image2 - the second image
	 * @param alpha - the linear combination parameter
	 * @return - the blended image
	 */
	public static Color[][] blend(Color[][] image1, Color[][] image2, double alpha) {
		// Replace the following statement with your code
		Color[][] blended = new Color[image1.length][image1[0].length];
		for (int i = 0; i < image1.length; i++) {
			for (int j = 0; j < image1[0].length; j++) {
				blended[i][j] = blend(image1[i][j], image2[i][j], alpha);
			}
		}

		return blended;
	}



	/**
	 * Morphs the source image into the target image, gradually, in n steps.
	 * Animates the morphing process by displaying the morphed image in each step.
	 * The target image is an image which is scaled to be a version of the target
	 * image, scaled to have the width and height of the source image.
	 * @param source - source image
	 * @param target - target image
	 * @param n - number of morphing steps
	 */
	public static void morph(Color[][] source, Color[][] target, int n) {
		// Write your code here
		Color[][] new_target = scaled(target, source[0].length, source.length);

		for (int i = 0; i < n; i++) {
			double alpha = 1 - (((double) i)/((double) n));
			Color[][] morphed = blend(source,new_target,alpha);
			show(morphed);
		}
	}




	/**
	 * Renders (displays) an image on the screen, using StdDraw.
	 *
	 * @param image - the image to show
	 */
	public static void show(Color[][] image) {
		StdDraw.setCanvasSize(image[0].length, image.length);
		int width = image[0].length;
		int height = image.length;
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.show(25);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Sets the pen color to the color of the pixel
				StdDraw.setPenColor( image[i][j].getRed(),
						image[i][j].getGreen(),
						image[i][j].getBlue());
				// Draws the pixel as a tiny filled square of size 1
				StdDraw.filledSquare(j + 0.5, height - i - 0.5, 0.5);
			}
		}
		StdDraw.show();
	}
}


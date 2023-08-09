import java.util.HashMap;
import java.util.Random;

/* A random text generator. The program "trains" itself by reading and analysing
 * character probabilitie in a given text, and then generates random text that is
 * "similar" to the given text. */
public class TextGen {

	// Length of the moving window
	private static int windowLength; 
	
	// A map for managing the (window, list) mappings 
	private static HashMap<String, List> map;

	// Random number generator, used by the getRandomChar method. 
	private static Random randomGenerator;

	public static void main(String[] args) {
		int windowLength = Integer.parseInt(args[0]);
		String initialText = args[1];
		int generatedTextLength = Integer.parseInt(args[2]);
		boolean randomGeneration = args[3].equals("random");
		String fileName = args[4];
		init(windowLength, randomGeneration, fileName);

		// Creates the map (implemented as a global, class-level variable).
		train();
		
		// Uses the map for generating random text, and prints the text.
		String generatedText = generate(initialText, generatedTextLength);
		System.out.println(generatedText);
	}
	
	// Initializes the training and text generation processes
	private static void init(int length, boolean randomMode, String fileName) {
		windowLength = length;
		map = new HashMap<String, List>();
		StdIn.setInput(fileName);
		if (randomMode) {
			// Creates a random number generator with a random seed:
			// Each program run will produce a different random text.
		    randomGenerator = new Random();    
		} else {
			// Creates a random number generator with a fixed seed:
			// Each program run will produce the same random text.
			// Designed to support consistent testing and debugging.
            randomGenerator = new Random(20);
		}
	}

	/** Trains the model, creating the map. */
	public static void train() {
		/// Put here the code that you wrote in Stage II
		String window = "";
		char c;
		// Constructs the first window
		/// Put your code here
		for (int i = 0; i < windowLength; i++) {
			window +=  StdIn.readChar();
		}





		// Processes the entire text, one character at a time
		while (!StdIn.isEmpty()) {
			c = StdIn.readChar();
			if (map.get(window) == null) {
				map.put(window, new List());
			}

			map.get(window).update(c);
			window = window.substring(1) + c;





		}

		// Computes and sets the p and pp fields of all the
		// CharData objects in each list in the map.
		for (List list : map.values()) {
			calculateProbabilities(list);
		}
	}

	// Computes and sets the probabilities (p and pp fields) of all the
	// characters in the given list. */
	private static void calculateProbabilities(List list) {				
		/// Put here the code that you wrote in Stage I
		double ppsum = 0;
		int totalcount = 0;
		for (int i = 0; i < list.getSize(); i++) {
			totalcount += list.get(i).count;

		}
		list.get(0).pp = (double) list.get(0).count / totalcount;
		ppsum = list.get(0).pp;
		for (int i = 0; i < list.getSize(); i++) {
			list.get(i).p = (double) list.get(i).count / totalcount;

			if (i != 0) {
				ppsum += list.get(i).p;
				list.get(i).pp = ppsum;
			}

		}
	}

	/** Generates a string representation of the map, for debugging purposes. */
	public static String mapString() {
		/// Put here the code that you wrote in Stage II.
		/// We leave this function in the code, in case you want to use it
		/// for debugging.
		StringBuilder ans = new StringBuilder();
		for (String key : map.keySet()) {
			// Put your code here
			ans.append(key + ": ");
			ans.append(map.get(key).toString());
			ans.append(System.getProperty("line.separator"));

		}
		return ans.toString();
	
	}

	/**
	 * Generates random text, based on the map crated by the train() method. 
	 * @param initialText - the beginning of the generated text 
	 * @param textLength - the size of generated text
	 * @return the generated text
	 */
	public static String generate(String initialText, int textLength) {
		/// Replace the following statement with your code
		String generateText = initialText;
		char Rchar = 'c';

		for (int i = 0; i < textLength; i++) {
			if (map.get(initialText) == null || textLength == generateText.length()) {
				return generateText;
			} else {
				Rchar = getRandomChar(map.get(initialText));
				generateText = generateText + Rchar;
				initialText = initialText.substring(1) + Rchar;
			}
		}
		return generateText;
	}

	// Returns a random character from a given list of CharData objects,
    // using Monte Carlo.
	private static char getRandomChar(List list) {
		/// Replace the following statement with the code that you wrote in Test2.txt.
		double r =  randomGenerator.nextDouble();
		char answer = 'c';
		for (int i = 0; i < list.getSize(); i++) {
			if (list.get(i).pp > r) {
				answer = list.get(i).chr;
				break;
			}
		}
		return answer;
	}
}

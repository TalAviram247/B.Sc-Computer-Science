import java.util.HashMap;

/* This class provides the training stage of a random text generator.
 * The program reads text ("corpus") from a given file, and analyses
 * and records the character probabilitie in the given text. */
public class TextTrain {

	// Length of the moving window
	private static int windowLength; 
	
	// A map for managing the (window, list) mappings 
	private static HashMap<String, List> map;

	public static void main(String[] args) {
		int windowLength = Integer.parseInt(args[0]);
		String fileName = args[1];
		init(windowLength, fileName);

		// Creates the map (implemented as a global, class-level variable).
		train();
		
		// Prints a textual representation of the map (for debugging purposes only).
		System.out.println(mapString());
	}
	
	// Initializes the training process.
	
	public static void init(int length, String fileName) {
		windowLength = length;
		map = new HashMap<String, List>();
		StdIn.setInput(fileName);
	}

	/** Trains the model, creating the map. */
	public static void train() {
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
		// Put here the code that you wrote in the test2.java class.
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
		StringBuilder ans = new StringBuilder();
		for (String key : map.keySet()) {
			// Put your code here
			ans.append(key + ": ");
			ans.append(map.get(key).toString());
			ans.append(System.getProperty("line.separator"));

		}
		return ans.toString();
	}
}

/** Performs a sequence of interactive fraction arithmetic exercises.
 */
public class FracPrac {
	
    public static void main(String[] args) {
		// Inputs the difficulty limit
		int limit = Integer.parseInt(args[0]);
		System.out.println("Welcome to fractions practice!");
		System.out.println("Here is your first question:");
		Expression exp = new Expression(limit);
		String ans = "";

		while (!ans.equals("quit")) {

			// Prints the question and gets the answer
			System.out.println(exp + " = ?");
			ans = StdIn.readLine();

            switch(ans) {
			    case "hint":
			        // Prints a hint and repeats the same question
			        printHint(exp);
			        break;
			    case "pass":
			        // Prints the correct answer and creates a new question
			        printCorrectAnswer(exp);
				    System.out.println("New question:");
				    System.out.println();
				    exp = new Expression(limit);
				    break;
				case "quit":
				    System.out.println("Bye now!");
				    break;
			    default:
			        // Gets the user's answer. If the user does not enter a valid answer,
			        // catches the runtime exception and handles it.
				    try {
					    if (isCorrect(exp, ans)) {
					        System.out.println("Correct! Next question:");
					        System.out.println();
					        exp = new Expression(limit);
					    } 
					    else {
					        System.out.println("Incorrect... Try again:");
					    }
				    } catch(NumberFormatException excep) {
				          System.out.println("Enter a valid answer.");
	                }
	        }
	    }
	}

	/**
	 * Computes the value of the given expression, reduces the resulting fraction,
	 * and prints the expression and the value.
	 * For example, if exp is 1/2 + 1/6, prints "1/2 + 1/6 = 2/3"
	 * @param exp - the expression
	 */
	public static void printCorrectAnswer(Expression exp) {
		// Write your code here
		Fraction reduced = exp.value();
		reduced.reduce();
		System.out.println(exp + " = " + reduced);
	}

	/**
	 * Checks if the given answer is the value of the given expression.
	 * @param exp - the expression
	 * @param ans - the user's input
	 * @return true iff the value of the expression is consistent woth the user's input
	 */
	public static boolean isCorrect(Expression exp, String ans) {
		// Distinguishes between two types of expressions: comparisons, and other expressions
		if (exp.getOp() == '>') {
			return isCorrectComp(exp, ans);
		} else {
			return isCorrectAddSubMultDiv(exp, ans);
		}
	}

	/**
	 * Checks if the given answer represents the value of the given expression.
	 * Assumes that the expression is an addition, subtraction, multiplication, or division.
	 * The answer must be either "int/int" or "int".
	 * @param ans - the input string
	 * @param exp - the expression
	 * @return true iff the answer represents the value of the expression.
	 * @throws NumberFormatException - if the answer is neither "int/int" nor "int"
	 */
	public static boolean isCorrectAddSubMultDiv(Expression exp, String ans) {
		// Replace the following statement with your code
		int index = ans.indexOf('/');
		if (index == -1) {
			int ansInt = Integer.parseInt(ans);
			Fraction denominanated = new Fraction(ansInt, 1);
			if (denominanated.equals(exp.value())) {
				return true;
			}
			return false;
		}
		if (index != -1){
			String stringNumerator = ans.substring(0 , index);
			String stringDenomanator = ans.substring(index + 1);
			int numenator = Integer.parseInt(stringNumerator);
			int demomintator = Integer.parseInt(stringDenomanator);
			Fraction args = new Fraction(numenator, demomintator);
			if (args.equals(exp.value())) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Checks if the given answer, which must be "true" or "false",
	 * represents the value of the given expression.
	 * Assumes that the expression is a comparison.
	 * @param exp - the expression
	 * @param ans - the given String (which is either "true" or "false")
	 * @return true iff the boolean value solves the expression.
	 */
	public static boolean isCorrectComp(Expression exp, String ans) {
		// Replace the following statement with your code
		boolean B = false;
		Fraction Value = exp.value();

		if (Value.getNumerator() <= 0 && ans.equals("false")) {
			B = true;
		}else if(Value.getNumerator() > 0 && ans.equals("true")){
			B = true;
		}
		return B;
	}

	/**
	 * Prints a hint for the given expression.
	 * The hint depends on the expression's operator.
     * @param exp - the expression
	 */
	public static void printHint(Expression exp) {
		// Write your code here

		if (exp.getOp() == '-'){
			if(exp.getOp1().getDenominator() == exp.getOp2().getDenominator()){
				System.out.print("Add up the numerators and divide by the common denominator. Try again:");
				System.out.println();
			}else {
				System.out.print("Notice that " + exp + " = " + exp.hint() + ". Try again");
				System.out.println();
			}
		}
		else if (exp.getOp() == ':') {
			System.out.print("Notice that " + exp + " = " + exp.hint() + ". Try again:");
			System.out.println();
		}
		else if (exp.getOp() == '>') {
			System.out.print("Notice that if " +  exp.hint() + " > 0, the answer must be true. Try again:");
			System.out.println();
		}
		else if (exp.getOp() == '+') {
			if(exp.getOp1().getDenominator() == exp.getOp2().getDenominator()){
				System.out.print("Add up the numerators and divide by the common denominator. Try again:");
				System.out.println();
			}else {
				System.out.print("Notice that " + exp + " = " + exp.hint() + ". Try again");
				System.out.println();
			}
		}else {
			System.out.print("Multiply the two numerators, and divide by the product of the denominators. Try again:");
			System.out.println();
		}
	}


}

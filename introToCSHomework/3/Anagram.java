
// A collection of functions for handling anagrams.
public class Anagram {
	public static void main(String args[]) {
	    // Tests the isAnagram function.
   		System.out.println(isAnagram("silent","listen"));  // true
	    System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
	    System.out.println(isAnagram("Madam Curie","Radium came")); // true
	    // Tests the randomAnagram function.
	    System.out.println(randomAnagram("silent")); // Prints a random anagram
	    // Performs a stress test of randomAnagram
	    boolean pass = true;
	    String str = "this is a stress test";
	    for (int i = 0; i < 1000; i++) {
	      	pass = pass && isAnagram(str, randomAnagram(str));	
	    }     
	    System.out.println(pass);	// true if all tests are positive
	}

	    // Returns true if the two given strings are anagrams, false otherwise.
	    public static boolean isAnagram(String str1, String str2) {
		   // Replace the return statement with your code.
	  	    str1 = preProcess(str1);
	  	    str2 = preProcess(str2);
	  	    if (str1.length() != str2.length()) {
	  		   return false;
            }
	  		
	  		while (0 < str1.length() ) {
	  			char first_1 = str1.charAt(0);
	  			int index_2  = str2.indexOf(first_1);

	  			if (index_2 != (-1)) {
	  				str1 = str1.substring(1);
	  				str2 = str2.substring(0,index_2) + str2.substring(index_2 +1);


	  			}else{
	  			    return false;
	  			}	
	  		}

	  		return true;
	  	}

	   // Returns a preprocessed version of the given string: all the letter characters
	   // are converted to lower-case, and all the other characters are deleted. For example, 
	   // the string "What? No way!" becomes "whatnoway"
	  	public static String preProcess(String str) {
		   // Replace the return statement with your code.
	  		String new_string = "" ;
	  		for (int j = 0; j<str.length() ; j++ ) {
	  			char current_char = str.charAt(j);

	  			if ( 'z' >= current_char && 'a' <= current_char) {
	  				new_string = new_string + current_char;

	  				
	  			} else if ( 'Z' >= current_char && 'A' <= current_char) {
	  				new_string = new_string + (char)(current_char + 32);
	  				
	  			}
	  			
	  		}

	  		return new_string;
	  	} 

	   // Returns a random anagram of the given string. The random anagram consists of the same
	   // letter characters as the given string, arranged in a random order.
	  	public static String randomAnagram(String str) {
		   // Replace the return statement with your code.
	  		String rand = "" ;
	  		while ( 0 < str.length()) {
	  			int i = (int) (Math.random() * str.length());
	  			rand  = rand + str.charAt(i);
	  			str   = str.substring(0,i) + str.substring(i+1, str.length());
	  		}

	  		return rand ;
	  	}
	
}	
	  
	  
		
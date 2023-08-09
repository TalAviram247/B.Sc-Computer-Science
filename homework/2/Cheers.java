// Prints a crowd cheering output.
public class Cheers {
    public static void main(String[] args) {
   	    // Complete the program code here:
        String str = args[0];
        int n      = Integer.parseInt(args[1]);
        for(int i = 0; i<=(str.length()-1); i++) {
        	if (str.charAt(i) == 'a'|| str.charAt(i) ==  'e'|| str.charAt(i) ==  'i'||str.charAt(i) ==  'o'
        		||str.charAt(i) ==  'u'||str.charAt(i) ==  'A'||str.charAt(i) ==  'E'|| str.charAt(i) == 'I'||str.charAt(i) ==  'O'||str.charAt(i) ==  'U') {
        		   System.out.println("Give me an "+str.charAt(i)+": "+str.charAt(i)+"!");
        	} else {
        	       System.out.println("Give me a "+str.charAt(i)+": "+str.charAt(i)+"!");	

            }
        }
       
        System.out.println("What does that spell?");
        for(int j = 1; j<=n; j++ ) {
        	System.out.println(str+"!!!");
        }
   

    }  
}

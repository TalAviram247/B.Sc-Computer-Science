/* Tests the "quality" of Java's Math.random function.
*/
public  class  TestRandom {
	static int a = 0;
	public static void main(String[]  args) {
		// Complete the program code here:

		int N = Integer.parseInt(args[0]);
		int smallcounter =  0;
		int bigcounter   = 0;
		for(int i = 1 ; i <= N ; i++) {
			double random = Math.random();
			if (random>0.5) {
				bigcounter++;
			} else {
			    smallcounter++;
			}
			    	
        }
        
        double ratio = (double) bigcounter/smallcounter;
        System.out.println("> 0.5: "+bigcounter+" times");
        System.out.println("<= 0.5: "+smallcounter+" times");
        System.out.println("Ratio: "+ratio);



	}
}

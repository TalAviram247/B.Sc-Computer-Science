// Computes an approximation of PI.
public class CalcPi {

    public static void main(String args[]) { 
		
		double sum = 0;

		// Put the code that calculates the sum here.
		double k = 1;
		int n = Integer.parseInt(args[0]);
		for(int i = 0; i<n; i++ ) {
			if (i%2==0) {
				sum= sum+(1.0/k);
				
			} else {
				sum= sum-(1.0/k);
				
			}	
		    
		    k=k+2;
		}		

				
			

		System.out.println("pi according to Java: " + Math.PI);
		System.out.println("pi, approximated:     " + 4.0 * sum);
	


	}
}
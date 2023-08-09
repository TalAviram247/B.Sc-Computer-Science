// Demonstrates the Collatz conjecture. */
public class Collatz {
	public static void main(String args[]) {
		int seed= Integer.parseInt(args[0]);
		
		
		
		for (int i = 1; i<=seed; i++){
			int num=i;
			
			int counter=1;
			String ans=""+i;
			do{
				if(i%2==0){
					i=i/2;
					ans=ans+" "+i;
				}
				else{
					i=i*3+1;
					ans=ans+" "+i;
				}
				counter++;
				
			}
			while (i!=1);
			
			i=num;
			if(args[1].equals("v")){
				System.out.println(ans+" ("+ counter + ")");
			}
		}
		System.out.println("The first "+ seed + " hailstone sequences reached 1.");
	}
}	
			
			
		

	
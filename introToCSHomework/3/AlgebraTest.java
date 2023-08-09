// Add this java file to your specific folder which Algebra is!
// Compile and run this class, whish you luck

public class AlgebraTest{
	public static void main(String args[]){
		System.out.println("\t\t\t*************************************");
        System.out.println("\t\t\t*        Algebra Testing...         *");
        System.out.println("\t\t\t*************************************");     
		boolean isValid = true;
		for (int i = 0; i<100 ; i++){
			int x1 = (int)(Math.random()*50);
			int x2 = (int)(Math.random()*5)+1;

			if (Algebra.plus(x1,x2)!= (x1+x2)){	
				isValid = false;
				System.out.println("Error - check plus function! x1="+ x1+", x2 ="+ x2);
				break;
				}
			
			if (Algebra.minus(x1,x2)!= (x1-x2)){	
				isValid = false;				
				System.out.println("Error - check minus function! x1="+ x1+", x2 ="+ x2);
				break;
			}
				
			if (Algebra.times(x1,x2)!= (x1*x2)){
				isValid = false;	
				System.out.println("Error - check times function! x1="+ x1+", x2 ="+ x2);
				break;
			}
				
			if (Algebra.div(x1,x2)!= (x1/x2)){	
				isValid = false;
				System.out.println("Error - check div function! x1="+ x1+", x2 ="+ x2);
				break;
			}
				
			if (Algebra.mod(x1,x2)!= (x1%x2)){	
				isValid = false;
				System.out.println("Error - check mod function! x1="+ x1+", x2 ="+ x2);
				break;
			}
				
			if (Algebra.pow(x1,x2)!= (int)Math.pow(x1,x2)){	
				isValid = false;
				System.out.println("Error - check pow function! x1="+ x1+", x2 ="+ x2);
				break;
			}
				
			if (Algebra.sqrt((int)Math.pow(x1,2))!= x1){	
				isValid = false;
				System.out.println("Error - check sqrt function! x1="+ x1+", x2 ="+ x2);
				break;
			}
		}
			if (isValid) System.out.println("Bravo! All function are OK!!!");
	}
	}
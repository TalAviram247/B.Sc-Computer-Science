public class AnagramTest{
	public static void main(String args[]){
		System.out.println("\t\t\t*************************************");
        System.out.println("\t\t\t*      isAnagram Testing...         *");
        System.out.println("\t\t\t*************************************");     
        String str1 = "Let's try: anagram1* is Fun3";
		String str2 = "LetstryanagramisFun";
		System.out.println("str1 = " +str1+ " , str2 = "+str2);    
		System.out.println("This should be TRUE :" + Anagram.isAnagram(str1,str2)); 
         str1 = "Happy8Hippo";
		 str2 = "opphihppya";
		System.out.println("str1 = " +str1+ " , str2 = "+str2);    
		System.out.println("This should be TRUE :" + Anagram.isAnagram(str1,str2));  
         str1 = "Jav@ is SO MucH fun65634";
		 str2 = "fUN545 mUso (is chJaV";
		System.out.println("str1 = " +str1+ " , str2 = "+str2);    
		System.out.println("This should be TRUE :" + Anagram.isAnagram(str1,str2));  		

		
		
		System.out.println("\t\t\t*************************************");
        System.out.println("\t\t\t*     randomAnagram Testing...      *");
        System.out.println("\t\t\t*************************************");
		boolean pass = true;
			String str = "Let's try: anagram1* is Fun3";
			String randomStr = Anagram.randomAnagram(str);
			for (int i = 0; i < 10; i++) {
				pass = pass && Anagram.isAnagram(str, randomStr);
			  
			}
			System.out.println("Result should be true :" + pass + ", original is: "+ str+ " , randomAnagram is = "+ randomStr);			  
	
			str = "&^&$#$@@!   !!!";
			randomStr = "abbcerl#$^%";
			for (int i = 0; i < 10; i++) {
				pass = pass && !Anagram.isAnagram(str, randomStr);
			  
			}
			System.out.println("Result should be false :" + Anagram.isAnagram(str, randomStr) + ", original is: "+ str+ " , randomAnagram is = "+ randomStr);				  
			  
			str = "Happy8Hippo";
			randomStr = Anagram.randomAnagram(str);
			for (int i = 0; i < 10; i++) {
				pass = pass && Anagram.isAnagram(str, randomStr);
			  
			}
			System.out.println("Result should be true :" + pass + ", original is: "+ str+ " , randomAnagram is = "+ randomStr);			  
			str = "Jav@ is SO MucH fun65634";
			randomStr = Anagram.randomAnagram(str);
			for (int i = 0; i < 10; i++) {
				pass = pass && Anagram.isAnagram(str, randomStr);
			  
			}
			System.out.println("Result should be true :" + pass + ", original is: "+ str+ " , randomAnagram is = "+ randomStr);	
			if(pass){
				System.out.println("\n\n\t\t\t*******************************************");
				System.out.println("\t\t\t*   Great job! your code seem to work     *");
				System.out.println("\t\t\t*******************************************");
			}
			else{
				System.out.println("\n\n\t\t\t*******************************************");
				System.out.println("\t\t\t*   Something is wrong with your Code!    *");
				System.out.println("\t\t\t*******************************************");
			}
}
}
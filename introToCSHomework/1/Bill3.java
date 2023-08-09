public class Bill3 {
	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		String s3 = args[2];
		double bill  = Double.parseDouble(args[3]);
		System.out.println("Dear "+s1+", "+s2+ ", "+s3+": pay "+(Math.ceil(bill/3))+ " Shekels each.");
		
	}
}
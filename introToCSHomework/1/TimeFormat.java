
// Represents the hh:mm time format using an AM/PM format. 
public class TimeFormat {

	public static void main(String[] args) {
		// In Java, the command-line arguments args[0], args[1], ... are represented
		// each by a string. In this program, the single "hh:mm" input is represented
		// by the single command-line string argument args[0]. 
		//   
		// Concatenates the empty string "" with the left hour-digit, concatenates
		// the resulting string with the right hour-digit, and casts the resulting
		// string as an int.
		int hours = Integer.parseInt("" + args[0].charAt(0) + args[0].charAt(1));
		// Does the same with the minute digits.
		int minutes = Integer.parseInt("" + args[0].charAt(3) + args[0].charAt(4));
        // Complete the program's code here:
		int new_hours = 0;
		String new_minutes = "";
		if (minutes <=9)
			new_minutes = "0" + minutes;
		else 
			new_minutes = "" + minutes;


		if (hours == 00){			
			System.out.println("00:"+new_minutes+" AM");
			return;
		};

		if (hours <= 12) {
			new_hours = hours;
			if(hours == 12)
				System.out.println(new_hours+":"+new_minutes+" PM");
			else
				System.out.println(new_hours+":"+new_minutes+" AM");
		}
		else {
			new_hours = hours%12;
			System.out.println(new_hours+":"+new_minutes+" PM");
		};
		
	}

}

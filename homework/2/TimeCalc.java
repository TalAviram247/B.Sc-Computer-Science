
/** Performs time calculations. 
 */
public class TimeCalc {

	public static void main(String[] args) {
		int add= Integer.parseInt(args[1]);
		int add_hours=add/60;
		int add_minutes= add%60;
		if (args[0].length()!=5){
			 System.out.print("Invalid input");
		}
		else{
			int hours= Integer.parseInt("" + args[0].charAt(0) + args[0].charAt(1));
			int new_hours=hours+add_hours;
			int minutes = Integer.parseInt("" + args[0].charAt(3) + args[0].charAt(4));
			int new_minutes=minutes+add_minutes;
			
			String am_pm="AM";
			String final_minutes=""+new_minutes;

			if ((hours>23) || (hours<0) ||(minutes>59)||(minutes<0)){
				System.out.print("Invalid input");
			}
			else{			
				if (new_minutes>59){
					new_hours++;
					new_minutes=new_minutes%60;
					final_minutes=""+new_minutes;
				}
					
				if (new_minutes<10){
				final_minutes= "0"+new_minutes;
				}
				
				new_hours=new_hours%24;
				if (new_hours>=12){
						am_pm="PM";
					if (new_hours>12) {
						new_hours-=12;
				}
				}
									
				
				if (new_hours==0){
						System.out.print("00:"+final_minutes+" "+ am_pm);
				}
				else{
				System.out.print(new_hours+":"+final_minutes+" "+ am_pm);
				}

			}
			
			
	}
}
}


public class WindChill {
	public static void main(String[] args) {
	    try {	
			// Taking the temperature value as a command line argument 
			double temperature=Math.abs(Double.parseDouble(args[0]));
			
			//System.out.println(temperature);
			
			// Taking the velocity value as a command line argument 
			double velocity=Double.parseDouble(args[1]);
			
			/*checking the  temperature is less than 50 in absolute value and 
			 velocity is less than 120 and less than 3 */
			
			if (temperature<=50.0 && (velocity>=3&&velocity<=120) ) {
				
				// Finding Wind Chill by using formula and taking into the weather variable 
				double weather=35.74+0.6215*temperature+((0.4275*temperature-35.75)*Math.pow(velocity, 0.16));
				System.out.println("Wind Chill is : "+weather);
			}
			else 
				System.out.println("Please enter the values in valid range:");
	    }
	    catch(Exception ex)
		{
			System.out.println("The \" "+ex+" \" Exception is raised");
		}
		}
	
}

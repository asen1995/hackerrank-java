package introduction;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class IntroductionChallenges {
	
	//Java Date and Time
	public static String findDay(int month, int day, int year) {
		
		String dayNames[] = new DateFormatSymbols().getWeekdays();  
		
		Calendar myCalendar = new GregorianCalendar(year, month, day);

//		int dayOfWeek = myCalendar.get(Calendar.DAY_OF_WEEK);
		return dayNames[myCalendar.get(Calendar.DAY_OF_WEEK)];
	}
}

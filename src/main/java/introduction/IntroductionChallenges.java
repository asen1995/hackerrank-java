package introduction;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class IntroductionChallenges {

	// Java Date and Time
	public static String findDayOfWeek(int month, int day, int year) {

		String dayNames[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		// January is represented as 0
		month = month - 1;
		Calendar myCalendar = new GregorianCalendar(year, month, day);

		String dayString = dayNames[myCalendar.getTime().getDay()];

		return dayString.toUpperCase();
	}
}

package introduction;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;

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

	public static String currencyConverter(double payment) {

		NumberFormat usCurrency = NumberFormat.getCurrencyInstance(Locale.US);
		// Note: India does not have a built-in Locale, so you must construct one where
		// the language is en (i.e., English).
		NumberFormat indiaCurrency = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
		NumberFormat chinaCurrency = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat franceCurrency = NumberFormat.getCurrencyInstance(Locale.FRANCE);

		String us = usCurrency.format(payment);
		String india = indiaCurrency.format(payment);
		String china = chinaCurrency.format(payment);
		String france = franceCurrency.format(payment);

		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
		return "SUCCESS";

	}
	
	public static double calculator(double number1,double number2, String operation) {

		return 0.0;
	}

}

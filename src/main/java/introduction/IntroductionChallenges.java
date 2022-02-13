package introduction;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Calendar;
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

	public static String currencyConverter(double money) {

		NumberFormat usCurrency     = NumberFormat.getCurrencyInstance(Locale.US); 
//	    NumberFormat indiaCurrency  = NumberFormat.getCurrencyInstance(indiaLocale);
	    NumberFormat chinaCurrency  = NumberFormat.getCurrencyInstance(Locale.CHINA);
	    NumberFormat franceCurrency = NumberFormat.getCurrencyInstance(Locale.FRANCE);
	   
	    String us = usCurrency.format(money);
	    String china = chinaCurrency.format(money);

//		System.out.println("US: " + us);
//        //System.out.println("India: " + india);
//        System.out.println("China: " + china);
       // System.out.println("France: " + france);
        
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));        
            System.out.println("US: "     + us.format(us));
           // System.out.println("India: "  + india.format(payment));
            System.out.println("China: "  + china.format(china));
         //   System.out.println("France: " + france.format(payment));
          } catch (Exception e) {
            System.out.println("HackerRank please fix your test terminal");
          }
		return us;

	}

}

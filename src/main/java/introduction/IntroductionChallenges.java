package introduction;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class IntroductionChallenges {

    // Java Date and Time
    public static String findDayOfWeek(int month, int day, int year) {

        String dayNames[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
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

    public static double calculator(double number1, double number2, String operation) {

        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;

            default:
                break;
        }
        return 0.0;
    }

    public static double devide(double number1, double number2) {
        return number1 / number2;
    }

    public static void main(String[] args) {
        System.out.println(findDayOfWeek(8, 5, 2015));
        System.out.println(currencyConverter(12324.134));
        System.out.println(calculator(12.00, 5.00, "+"));
        System.out.println(calculator(12.00, 5.00, "-"));
        System.out.println(calculator(12.00, 5.00, "*"));
        System.out.println(calculator(12.00, 5.00, "/"));
        System.out.println(calculator(12.00, 5.00, "x"));
    }

    int[] arrayOfArrayProducts(int[] arr) {


//        input:  arr = [8, 10, 2]
//        output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]

        if (arr.length <= 1) {
            return new int[]{};
        }

        int result[] = new int[arr.length];

        int productIndex = 1;

        for (int i = 0; i < arr.length; i++) {
            result[i] = productIndex;
            productIndex *= arr[i];
        }

        productIndex = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= productIndex;
            productIndex *= arr[i];
        }

        return result;
    }

    int[][] rotateImage(int[][] a) {

        int[][] result = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[j][a.length - 1 - i] = a[i][j];
            }
        }

        return result;
    }

    int firstDuplicate(int[] a) {

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (result[a[i] - 1] == 0) {
                result[a[i] - 1] = a[i];
            } else {
                return a[i];
            }
        }

        return -1;
    }

    int firstNotRepeatingCharacter(String s) {

        int[] result = new int[26];

        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (result[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return '-';
    }

    int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int index = array.length - 1;

        while (leftIndex < rightIndex) {
            if (Math.abs(array[leftIndex]) > Math.abs(array[rightIndex])) {
                result[index] = array[leftIndex] * array[leftIndex];
                leftIndex++;
            } else {
                result[index] = array[rightIndex] * array[rightIndex];
                rightIndex--;
            }
            index--;
        }

        return result;
    }


}

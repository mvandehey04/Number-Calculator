// Assignment01 Template
// Madeline Vande Hey
// estimated time worked on: 6 hr
package edu.cs2430.assignment1;

import java.util.Scanner;
public class Assignment01{
    // The number of months in a year
    public static final int NUMBER_OF_MONTHS = 12;
    // scanner
    public static Scanner scanner;

    public static void main(String[] args){
        scanner = new Scanner(System.in);
        printDayOfWeek();
        printPerfectNumbers();
        printGCD();

    }

    // Prints the greatest common divisor of two input integers
    public static void printGCD(){
        System.out.println("Enter an integer");
        String num1String = scanner.nextLine();
        int num1 = Integer.parseInt(num1String);
        System.out.println("Enter another integer");
        String num2String = scanner.nextLine();
        int num2 = Integer.parseInt(num2String);
        int gcd = calculateGCD(num1, num2);
        System.out.println(gcd);
    }

    // task # 1
    public static int calculateGCD(int num1, int num2){
        int gcd = -1;
        while(num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 = num1 % num2;

            } else if(num2 > num1){
                num2 = num2 % num1;
            }
        }
        if(num1 == 0){
            gcd = num2;
        }
        else if(num2 == 0){
            gcd = num1;
        }
        return gcd;
    }

    // task # 2
    public static int calculateDayOfWeek(int day, int month, int year){
        // w in equation
        int dayOfWeek = -1;

        // shifts month number
        int m = 0;
        if(month == 1){
            m = 13;
        }
        else if(month == 2){
            m = 14;
        }
        else{
            m = month;
        }

        // the year, if the month is January or February Y = year -1
        int y = 0;
        if(month == 1 || month == 2){
            y = year - 1;
        }
        else{
            y = year;
        }

        int c = y / 100;
        y = y - (100 * c);
        //y = year / 100;
        //int c = y - (100 * y);



        // day of the month
        int d = day;

        dayOfWeek = (((13 * (m + 1)) / 5) + (y / 4) + (c / 4) + d + y - (2 * c)) % 7;

        if(dayOfWeek < 0) {
            dayOfWeek += 7;
        }

        return dayOfWeek;
    }

    /**
     * Prints the day of the week a given input date is
     * Retrieves a day, month, and year from the user
     * Output the day of the week for that given day, month, year
     */
    public static void printDayOfWeek(){
        System.out.println("Enter a day");
        String dayString = scanner.nextLine();
        int dayInt = Integer.parseInt(dayString);
        System.out.println("Enter a month");
        String monthString = scanner.nextLine();
        int monthInt = Integer.parseInt(monthString);
        System.out.println("Enter a year");
        String yearString = scanner.nextLine();
        int yearInt = Integer.parseInt(yearString);
        int dayOfWeek = calculateDayOfWeek(dayInt, monthInt, yearInt);
// An array of week names would be better but arrays have not been taught yet
        if(dayOfWeek == 0){
            System.out.println("Saturday");
        }
        else if(dayOfWeek == 1){
            System.out.println("Sunday");
        }
        else if(dayOfWeek == 2){
            System.out.println("Monday");
        }
        else if(dayOfWeek == 3){
            System.out.println("Tuesday");
        }
        else if(dayOfWeek == 4){
            System.out.println("Wednesday");
        }
        else if(dayOfWeek == 5){
            System.out.println("Thursday");
        }
        else if(dayOfWeek == 6){
            System.out.println("Friday");
        }
    }

    // task # 3
    public static boolean isPerfectNumber(int number){
        boolean isPerfect = false;
        int divisors = 0;

        if(number != 0){
            for(int i = (number - 1); i > 0; i--){
                if(number % i == 0){
                    divisors += i;
                }
            }

            if(divisors == number){
                isPerfect = true;
            }
        }

        return isPerfect;
    }

    public static void printPerfectNumbers(){
        System.out.println("Enter a number");
        String maxNumberString = scanner.nextLine();
        int maxNumber = Integer.parseInt(maxNumberString);
        for(int i=1; i<maxNumber; i++){
            if(isPerfectNumber(i)){
                System.out.println(i);
            }
        }
    }
}

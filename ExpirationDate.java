package paytransactions;


/** Class to represent a calendar date.
 * 
 */

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author k8port
 */
public class ExpirationDate {
    
    private String month;
    private int year; // 4 digits
    
    public ExpirationDate() {
        month = "January";
        year = 1000;
    }
    
    public ExpirationDate(int monthInt, int year) {
        setDate(monthInt, year);
    }
    
    public ExpirationDate(String monthString, int year) {
        setDate(monthString, year);
    }  
    
    public ExpirationDate(int year) {
        setDate(1, year);
    }
    
    public ExpirationDate(ExpirationDate aDate) {
        if (aDate == null) {// not a real date {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        month = aDate.month;
        year = aDate.year;
    }
    
    private void setDate(int monthInt, int year) {
        if (dateOk(monthInt, year)) {    
            this.month = monthString(monthInt);
            this.year = year;
        }
        else    {
            System.out.println("Fatal error.");
            System.exit(0);
        }
    }
    
    private void setDate(String monthString, int year) {
        if (dateOk(monthString, year)) {
            this.month = monthString;
            this.year = year;
        }
        else {
            System.out.println("Fatal error.");
            System.exit(0);
        }
    }
    
    public void setDate(int year) {
        setDate(1, year);
    }
    
    public void setYear(int year) {
        if (year < 1000 || year > 9999) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else    
            this.year = year;
    }            
    
    public void setMonth(int monthNumber) {
        if (monthNumber <= 0 || monthNumber > 12) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }
       
    public int getMonth() {
        switch (month) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                System.out.println("Fatal error.");
                System.exit(0);
                return 0;
        }
    }
    
    public int getYear() {return year;}
    
    @Override
    public String toString() {return month + " " + year;}
    
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) 
            return false;
        else if (getClass() != otherObject.getClass()) 
            return false;
        else {
            ExpirationDate otherDate = (ExpirationDate) otherObject;
            return ((month.equals(otherDate.month)) && (year == otherDate.year));
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.month);
        hash = 31 * hash + this.year;
        return hash;
    }
    
    public Boolean precedes(ExpirationDate otherDate) {
        return ( (year < otherDate.getYear()) ||
                (year == otherDate.getYear() && getMonth() < 
                otherDate.getMonth()) );
    }
    
    public void readInput() {
        boolean tryAgain = true;
        Scanner kbd = new Scanner(System.in);
        while (tryAgain) {
            System.out.println("Enter month, day and year.");
            System.out.println("Don't use a comma.");
            String monthInput = kbd.next();
            int yearInput = kbd.nextInt();
            if (dateOk(monthInput, yearInput)) {
                setDate(monthInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
        }
    }
    
    private boolean dateOk(int monthInt, int yearInt) {
        return (    (monthInt >= 1) && (monthInt <= 12) &&
                (yearInt >= 1000) && (yearInt <= 9999)    );
    }
    
    private boolean dateOk(String monthString, int yearInt) {
        return (    (monthOk(monthString)) &&
                (yearInt >= 1000) && (yearInt <= 9999)    );
    }
    
    private boolean monthOk(String month) {
        return (month.equals("January") || month.equals("February") || 
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") || 
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December"));
    }
    
    private String monthString(int monthNumber) {
        switch (monthNumber) {
            case 1:
                    return "January";
            case 2:
                    return "February";
            case 3:
                    return "March";
            case 4: 
                    return "April";
            case 5:    
                    return "May";
            case 6:
                    return "June";
            case 7:    
                    return "July";
            case 8:
                    return "August";
            case 9:
                    return "September";
            case 10:
                    return "October";
            case 11:    
                    return "November";
            case 12: 
                    return "December";
            default:
                System.out.println("Fatal error.");;
                System.exit(0);
                return "Error"; // to keep compiler happy
        }
    }
}

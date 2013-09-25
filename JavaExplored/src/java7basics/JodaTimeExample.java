/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java7basics;
/*
import org.joda.time.DateTime;
import java.util.Locale;
import org.joda.time.Duration;
import org.joda.time.Period;


/*
 * JodaTime better than jdk's Date Time and Calendar class as their objects are mutable
 * thus arent thread safe and many more advantages
 * http://joda-time.sourceforge.net/quickstart.html
 * http://www.wolkje.net/2010/01/06/java-date-and-time-api-and-jsr-310/
 */

/*


public class JodaTimeExample {
    
    public static void main(String[] args) {
        
        /*****Date and Time *******
        DateTime dt = new DateTime();
        int month = dt.getMonthOfYear();
        
        DateTime year2000 = dt.withYear(2000);
        DateTime twoHoursLater = dt.plusHours(2);
        
        String monthName = dt.monthOfYear().getAsText();
        String frenchShortName = dt.monthOfYear().getAsShortText(Locale.FRENCH);
        boolean isLeapYear = dt.year().isLeap();
        DateTime rounded = dt.dayOfMonth().roundFloorCopy();
        
        System.out.println("month number = " + month);
        System.out.println("date time = " + dt);
        System.out.println("year 2000 = " + year2000);
        System.out.println("month name = " + monthName);
        System.out.println("french short name of month = " + frenchShortName);
        System.out.println("is leap year = " + isLeapYear);
        System.out.println("date rounded = " + rounded);
        
        /********Intervals and time periods******
        DateTime dt2 = new DateTime(2005, 3, 26, 12, 0, 0, 0);
        
        DateTime plusPeriod = dt2.plus(Period.days(1));
        DateTime plusDuration = dt2.plus(new Duration(24L*60L*60L*1000L));
        
        System.out.println("\nmanual date = "+ dt2);
        System.out.println("plus period = "+ plusPeriod);
        System.out.println("plus duration = "+ plusDuration);
        
        
        
    }

}


*/
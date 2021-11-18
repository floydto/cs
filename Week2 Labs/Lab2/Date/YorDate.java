// File: YorDate.java
/**
 *  YorDate is an implementation of a simple Date class that hides the complexity
 *  of the Java 2 Calendars and the associated classes.
 *  It makes no attempt to handle time values - it only stores day-month-year
 *  
 *  Ver2 - extended to add comparison and daysBetween() methods
 *
 *  @author     Tommy Yuan
 *  @version    24 January 2019
 */
 
import java.util.*;

public class YorDate
{
    private int day;
    private int month;
    private int year;

    /**
     *  Constructor for objects of class YorDate
     *  Default constructor sets the values to the current system date
     */
    public YorDate()
    {
        Calendar now = new GregorianCalendar();
        day = now.get( Calendar.DAY_OF_MONTH );
        month = now.get( Calendar.MONTH );
        year = now.get( Calendar.YEAR );
    }

    /**
     *  Constructor for YorDate object built from day-month-year
     *
     *  @param  dayIn       integer representing the day of the month
     *  @param  monthIn integer for month number, January = 1 ...
     *  @param  yearIn  integer representing year, include century
     *
     *  @throws YorDate$InvalidDateException if day-month-year is not valid
     */
    public YorDate( int dayIn, int monthIn, int yearIn )
    {
        if( !isValid( dayIn, monthIn, yearIn ) )
        {
            throw new YorDate.InvalidDateException( dayIn, monthIn, yearIn );
        }
        day = dayIn;
        month = monthIn-1;
        year = yearIn;
    }
    
    /**
     * Constructor for YorDate object built from an existing date object
     * (a "copy constructor").
     * 
     * @param dateIn    YorDate object to be cloned
     */
    public YorDate( YorDate dateIn )
    {   
        day = dateIn.day;
        month = dateIn.month;
        year = dateIn.year;
    }
    
    // Setters and getters for the obvious attributes:
    
    /**
     *  Set the day value of the YorDate
     *  Throws a runtime exception if the new date would be invalid
     *
     *  @param  dayIn   integer representing the new day number
     *  @throws YorDate$InvalidDateException if day-month-year is not valid
     */
    public void setDay( int dayIn )
    {
        if( !isValid( dayIn, month+1, year ) )
            throw new InvalidDateException( dayIn, month+1, year );
        day = dayIn;
    }
    
    /**
     *  Set the month value of the YorDate
     *  Throws a runtime exception if the new date would be invalid
     *
     *  @param  monthIn integer representing the new month number
     *  @throws YorDate$InvalidDateException if day-month-year is not valid
     */
    public void setMonth( int monthIn )
    {
        if( !isValid( day, monthIn, year ) )
            throw new InvalidDateException( day, monthIn, year );
        month = monthIn - 1;
    }
    
    /**
     *  Set the year value of the YorDate
     *  Throws a runtime exception if the new date would be invalid
     *
     *  @param  yearIn  integer representing the new year number
     *  @throws YorDate$InvalidDateException if day-month-year is not valid
     */
    public void setYear( int yearIn )
    {
        if( !isValid( day, month+1, yearIn ) )
            throw new InvalidDateException( day, month+1, yearIn );
        year = yearIn;
    }
    
    /**
     *  Get the day of the month:
     *
     *  @return day (1-31, upper value depends on month)
     */
    public int getDay()
    {
        return day;
    }

    /**
     *  Get the month in the year:
     *
     *  @return month (1-12)
     */
    public int getMonth()
    {
        return (month + 1);
    }

    /**
     *  Get the year number:
     *
     *  @return year
     */
    public int getYear()
    {
        return year;
    }

    
    /**
     *  Test method to check the validity of a day-month-year triple
     *
     *  @param  dayTest     day of month for testing
     *  @param  monthTest   month number for testing
     *  @param   yearTest    year for testing
     *  @return true if dayTest-monthTest-yearTest represents a vaild date
     *              false otherwise
     */
    public static boolean isValid( int dayTest, int monthTest, int yearTest )
    {
        boolean returnValue = true;
        // all values must be >= 1
        if( dayTest < 1 || monthTest < 1 || yearTest < 1 )
            returnValue = false;
        // and months <= 12
        else if( monthTest > 12 )
            returnValue = false;
        // 30 days has September, April, June and November
        else if( ((monthTest == 9) 
                 || (monthTest == 4) 
                 || (monthTest == 6) 
                 || (monthTest == 11))
                 && (dayTest > 30) )
             {
                 returnValue = false;
             }
        // all the rest have 31
        // excepting February
        else if( monthTest == 2 )
            // which has 28 days - except in leap years
            {   if( new GregorianCalendar().isLeapYear( yearTest ) )
                {   if( dayTest > 29 )
                        returnValue = false;
                }
                else if( dayTest > 28 )
                {
                    returnValue = false;
                }
            }
        else if( dayTest > 31 )
            returnValue = false;
        return returnValue;
    }
    
    /**
     *  Provide a String output of the form dd-mm-yyyy
     *  Leading zeros are not shown in the output
     *
     *  @return String dd-mm-yyyy
     */
    public String toString()
    {
        return new String( "" + day + "-" + (month + 1) + "-" + year );
    }
	 
	 /**
	  * Return the day of the week represented by the date.
	  *
	  * @return a string containing Monday, Tuesday ....
	  */
	public String getDayOfWeek()
	{	
		Calendar tCal = new GregorianCalendar( year, month, day );
	 	String returnValue = "";
		switch( tCal.get( Calendar.DAY_OF_WEEK ) )
		{	
			case Calendar.SUNDAY 	: returnValue = "Sunday" ; break;
			case Calendar.MONDAY 	: returnValue = "Monday" ; break;
			case Calendar.TUESDAY 	: returnValue = "Tuesday" ; break;
			case Calendar.WEDNESDAY : returnValue = "Wednesday" ; break;
			case Calendar.THURSDAY 	: returnValue = "Thursday" ; break;
			case Calendar.FRIDAY 	: returnValue = "Friday" ; break;
			case Calendar.SATURDAY	: returnValue = "Saturday" ; break;
		}			
		return returnValue;
	 }
    
    /**
     * Compare two YorDate objects for equality.
     * 
     * The parameter must be of type YorDate
     * 
     * @param obj - the object for comparison
     * @return true IFF obj is of type YorDate and it represents the same date as this object
     * 
     */
    public boolean equals( Object obj )
    {
        boolean returnValue = false;
        if( obj instanceof YorDate )
        {   YorDate that = (YorDate) obj;
            if( this.day == that.day && this.month == that.month && this.year == that.year )
            {
                returnValue = true;
            }
            
        }
        return returnValue;
    }
    
    /**
     * Required because of the overload of equals()
     */
    public int hashcode()
    {
        return year*10000 + month*100 + day;
    }
    
    /**
     * Compare two dates and report if this date is before the one passed as parameter
     * 
     * @param that YorDate the date for comparison
     * @return true if the current date is chronologically before the parameter else false
     */ 
    public boolean isBefore( YorDate that )
    {
        boolean returnValue = false;
        if( this.year < that.year )
        {
            returnValue = true;
        }
        else if( this.year == that.year )
        {
            if( this.month < that.month )
            {
                returnValue = true;
            }
            else if( this.month == that.month )
            {
                if( this.day < that.day )
                {
                    returnValue = true;
                }
            }
        }
        return returnValue;
    }

    /**
     * Compare two dates and report if this date is after the one passed as parameter
     * 
     * @param that  YorDate -  the date for comparison
     * @return true if the current date is chronologically after the parameter else false
     */ 
    public boolean isAfter( YorDate that )
    {
        boolean returnValue = false;
        if( this.year > that.year )
        {
            returnValue = true;
        }
        else if( this.year == that.year )
        {
            if( this.month > that.month )
            {
                returnValue = true;
            }
            else if( this.month == that.month )
            {
                if( this.day > that.day )
                {
                    returnValue = true;
                }
            }
        }
        return returnValue;
    }

    /**
     * Returns the number of days between two dates.
     * 
     * <P>The number of days between two dates is equivalent to the 
     * absolute value of the "arithmetic difference" between the two dates.<br>
     * 
     * If <tt>date1</tt> is 21-10-2003 and <tt>date2</tt> is 22-10-2003 then<br>
     * <tt>date1.daysBetween(date2)</tt> and <tt>date2.daysBetween(date1)</tt> both return 1.
     * 
     * @param that the date for comparison with the date represented by the current object
     * @return the integer vlaue representing difference between the dates
     */
    public int daysBetween( YorDate that )
    {   
        int count = 0;
        YorDate start, end;
        if( this.isBefore( that ) )
        {   
            start = new YorDate( this );
            end = new YorDate( that );
        }
        else
        {
            end = new YorDate( this );
            start = new YorDate( that );
        }
        while( !start.equals(end) )
        {   
            start = start.addOn( 1 );
            count++;
        }
        return count;
    }
    
    /**
     * Creates a new YorDate object that is a given number of days later than the current date.
     * 
     * <P>Given two YorDate objects <tt>d1</tt> and <tt>d2</tt>, where <tt>d1.isBefore(d2)</tt> is <tt>true</tt><br>
     * and calculating <tt>N</tt> as <tt>d1.daysBetween( d2 )</tt> -- or <tt>d2.daysBetween( d1 )</tt><br>
     * then <tt>d1.addOn(N)</tt> will give the same date as is represented by <tt>d2</tt>.
     *  
     * @param days  integer - number of days to add to the current date
     * @return a new YorDate object that is a given number of days after the current date
     */
    public YorDate addOn( int days )
    {   
        YorDate returnDate = new YorDate( this );
        days = Math.abs( days );
        for( int dayCount = 0; dayCount < days; dayCount++ )
        {
            if( isValid( returnDate.day+1, returnDate.month+1, returnDate.year ) )
            {   returnDate.day++;
            }
            else if( isValid( 1, returnDate.month+1+1, returnDate.year ) )
                {   
                    returnDate.day = 1;
                    returnDate.month++;
                }
                else
                {   returnDate.day = 1;
                    returnDate.month = 0;
                    returnDate.year++;
                }
        }
        return returnDate;
    }
    
    /**
     *  Runtime exception to abort program if an attempt to construct
     *  an invalid date is made.
     */
    class InvalidDateException extends RuntimeException
    {
        public InvalidDateException( int d, int m, int y )
        {
            super(  "" + d + "-" + m + "-" + y + " is not a valid date" );
        }
    }
}
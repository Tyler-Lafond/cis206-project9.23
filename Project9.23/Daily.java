
/**
 * Filename: Daily.java
 * Description: Code for the Daily subclass; serves to represent Daily appointments
 * Author: Tyler Lafond
 * E-Mail: tylerl5014@student.vvc.edu
 */
public class Daily extends Appointment                                   //Subclass Daily that extends superclass Appointment
{
    public Daily(String description, int year, int month, int day)       //Constructs a Daily object using the constructor of the superclass Appointment
    {
        super(description, year, month, day);
    }
    
    public boolean occursOn(int year, int month, int day)                //Overrides the Appointment class's occursOn to use for Daily appointments; matches the day of this object with one entered by the user
    {
        return day == getDay();
    }
}

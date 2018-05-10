
/**
 * Filename: Monthly.java
 * Description: Code for the Monthly subclass; serves to represent Monthly appointments
 * Author: Tyler Lafond
 * E-Mail: tylerl5014@student.vvc.edu
 */
public class Monthly extends Appointment                                //Subclass Monthly that extends superclass Appointment
{
    public Monthly(String description, int year, int month, int day)    //Constructs a Monthly object using the constructor of the superclass Appointment
    {
        super(description, year, month, day);
    }
    
    public boolean occursOn(int month, int day)                         //Overrides the Appointment class's occursOn to use for Monthly appointments; matches the day and month of this object with ones entered by the user
    {
        return month == getMonth() && day == getDay();
    }
}

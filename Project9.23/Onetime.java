
/**
 * Filename: Onetime.java
 * Description: Code for the Onetime subclass; serves to represent Onetime appointments
 * Author: Tyler Lafond
 * E-Mail: tylerl5014@student.vvc.edu
 */
public class Onetime extends Appointment                                         //Subclass Onetime that extends superclass Appointment
{
    public Onetime(String description, int year, int month, int day)             //Constructs a Onetime object using the constructor of the superclass Appointment
    {
        super(description, year, month, day);
    }
    
    public boolean occursOn(int year, int month, int day)                        //Overrides the Appointment class's occursOn to use for Onetime appointments; confirms this appointment occurs on the date input by the user
    {
        return year == getYear() && month == getMonth() && day == getDay();
    }
}

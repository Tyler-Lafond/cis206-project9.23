
/**
 * Filename: Appointment.java
 * Description: The base class file for different types of appointments
 * Author: Tyler Lafond
 * E-Mail: tylerl5014@student.vvc.edu
 */

import java.util.Scanner;                                                                      //Imports Scanner and needed util methods
import java.util.*;

public class Appointment                                                                       //Superclass for appointments
{
    private int year;                                                                          //Instance variables for the date and description
    private int month;
    private int day;
    private String description;
    
    public Appointment(String description, int year, int month, int day)                       //Constructs an Appointment object using the current description and date
    {
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public String getDescription()                                                             //Gets the current description of the object
    {
        return this.description;
    }
    
    public int getYear()                                                                       //Gets the current year of the object
    {
        return this.year;
    }
    
    public int getMonth()                                                                      //Gets the current month of the object
    {
        return this.month;
    }
    
    public int getDay()                                                                        //Gets the currrent day of the object
    {
        return this.day;
    }
    
    public boolean occursOn(int year, int month, int day)                                      //Method to confirm that this appointment occurs on the date the user has input
    {
        return year == this.year && month == this.month && day == this.day;
    }
}

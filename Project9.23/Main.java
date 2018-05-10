
/**
 * Filename: Main.Java
 * Description: Program that allows the user to add, check, save, and load appointments that are either Onetime, Monthly, or Daily
 * Author: Tyler Lafond
 * E-Mail: tylerl5014@student.vvc.edu
 */

import java.lang.Class;                                                                                                                //Imports the methods that are needed
import java.util.*;
import java.io.*;
public class Main
{
    public static void checkOnetime(ArrayList<Appointment> apps, int year, int month, int day)                                         //Method to check for Onetime appointments only using a given date
    {
        ArrayList<Appointment> appsOnetime = new ArrayList<Appointment>();                                                             //Creates an arraylist to extract all the onetime appointments
        String lineSpace = System.getProperty("line.separator");                                                                       //Allows lines to be separated on all OS
        for (int i = 0; i < apps.size(); i++)                                                                                          //Checks all appointments in the apps arraylist for Onetime appointments
        {
            boolean check = false;                                                                                                     //Variable to make sure that an appointment is a Onetime appointment
            if (apps.get(i) instanceof Onetime)                                                                                        //Checks for Onetime appointments in arraylist apps
            {
                check = apps.get(i).occursOn(year, month, day);                                                                        //Checks to make sure the date matches on the set appointment with the input date
                if (check == true)
                {
                    appsOnetime.add(apps.get(i));                                                                                      //Adds matches to arraylist appsOnetime
                }
            }
        }
        if (appsOnetime.size() == 0)                                                                                                   //Displays for no matches
        {
            System.out.println("There are no Onetime appointments on this date.");
        }
        else
        {
            System.out.printf("Here are all the Onetime appointments for %s/%s/%s:", month, day, year);                                 //Lists all Onetime appointments on the given date
            System.out.println();
            for (int i = 0; i < appsOnetime.size(); i++)
            {
                System.out.printf("%s/%s/%s : %s" + lineSpace, appsOnetime.get(i).getMonth(), appsOnetime.get(i).getDay(), appsOnetime.get(i).getYear(), appsOnetime.get(i).getDescription());
            }
            appsOnetime.clear();                                                                                                        //Clears the new arraylist
        }
    }
    
    public static void checkDaily(ArrayList<Appointment> apps, int year, int month, int day)                                            //Method to check for all Daily appointments in arraylist apps using a given date
    {
        ArrayList<Appointment> appsDaily = new ArrayList<Appointment>();                                                                //New arraylist for Daily appointments
        String lineSpace = System.getProperty("line.separator");                                                                        //Allows lines to be separated on all OS
        for (int i = 0; i < apps.size(); i++)                                                                                           //Checks all appointments in arraylist apps for daily appointments
        {
            boolean check = false;                                                                                                      //Variable to confirm that an appointment is a daily appointment
            if (apps.get(i) instanceof Daily)
            {
                check = apps.get(i).occursOn(year, month, day);                                                                         //Checks to make sure the day matches for an appointment
                if (check == true && year <= apps.get(i).getYear())                                                                     //Adds all daily appointments for the given date and onwards that match the day
                {
                    if (month <= apps.get(i).getMonth() || (month >= apps.get(i).getMonth() && year < apps.get(i).getYear()))
                    {
                        appsDaily.add(apps.get(i));
                    }
                }
            }
        }
        if (appsDaily.size() == 0)                                                                                                       //Displays when there are no matches to the day
        {
            System.out.println("There are no Daily appointments on this date.");
        }
        else                                                                                                                             //Lists the curerent and future Daily appointments for the given day
        {
            System.out.printf("Here are all the Daily appointments for %s/%s/%s and onwards:", month, day, year);
            System.out.println();
            for (int i = 0; i < appsDaily.size(); i++)
            {
                System.out.printf("%s/%s/%s : %s" + lineSpace, appsDaily.get(i).getMonth(), appsDaily.get(i).getDay(), appsDaily.get(i).getYear(), appsDaily.get(i).getDescription());
            }
            appsDaily.clear();                                                                                                            //Clears the new arraylist
        }
    }
    
    public static void checkMonthly(ArrayList<Appointment> apps, int year, int month, int day)                                            //Method to check for all Monthly appointments in arraylist apps using a given date
    {
        ArrayList<Appointment> appsMonthly = new ArrayList<Appointment>();                                                                //New arraylist for Monthly appointments
        String lineSpace = System.getProperty("line.separator");                                                                          //Allows lines to be separated on all OS
        for (int i = 0; i < apps.size(); i++)                                                                                             //Checks all appointments in arraylist apps for Monthly appointments
        {
            boolean check = false;                                                                                                        //Variable to confirm that an appointment is a Monthly appointment
            if (apps.get(i) instanceof Monthly)                                                                                           //Adds all Monthly appointments for the given month and day
            {
                check = apps.get(i).occursOn(year, month, day);
                if (check == true && year <= apps.get(i).getYear())
                {
                    appsMonthly.add(apps.get(i));
                }
            }
        }
        if (appsMonthly.size() == 0)                                                                                                       //Displays when there are no matches
        {
            System.out.println("There are no Monthly appointments on this date.");
        }
        else                                                                                                                               //Lists the current and future monthly appointments for the given month and day
        {
            System.out.printf("Here are all the Monthly appointments for %s/%s/%s and onwards:", month, day, year);
            System.out.println();
            for (int i = 0; i < appsMonthly.size(); i++)
            {
                System.out.printf("%s/%s/%s : %s" + lineSpace, appsMonthly.get(i).getMonth(), appsMonthly.get(i).getDay(), appsMonthly.get(i).getYear(), appsMonthly.get(i).getDescription());
            }
            appsMonthly.clear();                                                                                                            //Clears the new array
        }
    }
    
    public static void checkAll(ArrayList<Appointment> apps, int year, int month, int day)                                                  //Method to check for all matching appointments in arraylist apps using a given date
    {
        ArrayList<Appointment> appsAll = new ArrayList<Appointment>();                                                                      //New arraylist for all matching appointments
        String lineSpace = System.getProperty("line.separator");                                                                            //Allows lines to be separated on all OS
        String type = "";                                                                                                                   //Variable to record the type of object
        for (int i = 0; i < apps.size(); i++)                                                                                               //Checks for all matching appointments for the given date, and lists fute appointments
        {
            boolean check = false;                                                                                                          //Variable to make sure an appointment matches the date
            if (apps.get(i) instanceof Appointment)                                                                                         //Adds all appointments that match based on their type
            {
                check = apps.get(i).occursOn(year, month, day);
                if (check == true && year <= apps.get(i).getYear())
                {
                    if (month <= apps.get(i).getMonth())
                    {
                        appsAll.add(apps.get(i));
                    }
                }
            }
        }
        if (appsAll.size() == 0)                                                                                                             //Displays when there are no matches
        {
            System.out.println("There are no appointments on this date.");
        }
        else                                                                                                                                 //Lists all appointments that match with their type of appointment listed
        {
            System.out.printf("Here are all the appointments for %s/%s/%s and onwards:", month, day, year);
            System.out.println();
            for (int i = 0; i < appsAll.size(); i++)
            {
                if (appsAll.get(i) instanceof Onetime)
                {
                    type = "Onetime";
                }
                else if (appsAll.get(i) instanceof Daily)
                {
                    type = "Daily";
                }
                else if (appsAll.get(i) instanceof Monthly)
                {
                    type = "Monthly";
                }
                System.out.printf("%s/%s/%s : %s : %s" + lineSpace, appsAll.get(i).getMonth(), appsAll.get(i).getDay(), appsAll.get(i).getYear(), type, appsAll.get(i).getDescription());
            }
            appsAll.clear();
        }
    }
    
    public static String checkApp(ArrayList<Appointment> apps)                                                                             //Method to determine what type of appointments the user wishes to search for while passing the current arraylist of appointments
    {
        String type = "";                                                                                                                  //Variable to record the type of appointment to search for
        int year = 0;                                                                                                                      //variable for year input
        int month = 0;                                                                                                                     //Variable for month input
        int day = 0;                                                                                                                       //Variable for day input
        Scanner in = new Scanner(System.in);                                                                                               //Used for user input
        System.out.println("Enter the type of appointment you want to find.");                                                             //Asks the user for the type of appointmets they are searching for and will validate that input
        System.out.println("(Onetime, Daily, Monthly, and All. Type 'exit' to go back):");
        type = in.next();
        while (((!type.equalsIgnoreCase("Onetime") && !type.equalsIgnoreCase("Daily")) && (!type.equalsIgnoreCase("Monthly") && !type.equalsIgnoreCase("exit"))) && !type.equalsIgnoreCase("All"))
        {
            System.out.println("Please enter a valid input: ");
            type = in.next();
        }
        if (type.equalsIgnoreCase("exit"))                                                                                                  //Returns to the menu if the user types exit
        {
            return type;
        }
        while (year < 1900 || year > 9999)                                                                                                  //Asks the user for a year and will validate to make sure a proper year is entered
        {
            try                                                                                                                             //Normal sequence of steps for integers
            {
                System.out.println("Please enter the year: ");
                year = in.nextInt();
                if (year < 1900 || year > 9999)
                {
                    System.out.println("Please enter a valid input. ");
                }
            }
            catch (InputMismatchException m)                                                                                                 //Clears the scanner and tells the user to enter a valid number
            {
                System.out.println("Please enter a valid number.");
                year = 0;
                in.next();
            }
        }
        while (month < 1 || month > 12)                                                                                                      //Asks the user for a month and will validate to make sure a proper month is entered
        {
            try                                                                                                                              //Normal sequence of steps for integers
            {
                System.out.println("Please enter the month in numeric format: ");
                month = in.nextInt();
                if (month < 1 || month > 12)
                {
                    System.out.println("Please enter a valid input. ");
                }
            }
            catch (InputMismatchException m)                                                                                                 //Clears the scanner and tells the user to enter a valid number
            {
                System.out.println("Please enter a valid number. ");
                month = 0;
                in.next();
            }
        }
        while (day < 1 || day > 31)                                                                                                          //Asks the user for a day and will validate to make sure a proper day is entereed based on month
        {
            try                                                                                                                              //Normal Sequence for integers
            {
                System.out.println("Please enter the day: ");
                day = in.nextInt();
                switch (month)                                                                                                               //Uses the month for a switch statement to determine how many days are in that month
                {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:                                                                //For all months with 31 days
                        while (day < 1 || day > 31)
                        {
                            System.out.println("Please enter a valid input: ");
                            day = in.nextInt();
                        }
                        break;
                    case 4: case 6: case 9: case 11:                                                                                         //For all months with 30 days
                        while (day < 1 || day > 30)
                        {
                            System.out.println("Please enter a valid input: ");
                            day = in.nextInt();
                        }
                        break;
                    case 2:
                        if(((year % 4 == 0) && !(year == 100)) || (year % 400 == 0))                                                         //For leap years on February
                        {
                            while (day < 1 || day > 29)
                            {
                                System.out.println("Please enter a valid input: ");
                                day = in.nextInt();
                            }
                            break;
                        }
                        else
                        {
                            while (day < 1 || day > 28)                                                                                      //For normal years on February
                            {
                                System.out.println("Please enter a valid input: ");
                                day = in.nextInt();
                            }
                            break;
                        }
                }
            }
            catch (InputMismatchException m)                                                                                                 //Clears the scanner and tells the user to enter a valid number
            {
                System.out.println("Please enter a valid number.");
                day = 0;
                in.next();
            }
        }
        if (type.equalsIgnoreCase("Onetime"))                                                                                                //If-else statements to trigger the proper methods based on the types the user entered  
        {
            checkOnetime(apps, year, month, day);                                                                                            //Method for Onetime apps
        }
        else if(type.equalsIgnoreCase("Daily"))
        {
            checkDaily(apps, year, month, day);                                                                                              //Method for Daily apps
        }
        else if(type.equalsIgnoreCase("Monthly"))
        {
            checkMonthly(apps, year, month, day);                                                                                            //Method for Monthly apps
        }
        else if(type.equalsIgnoreCase("All"))
        {
            checkAll(apps, year, month, day);                                                                                                //Method for all apps
        }
        return type;                                                                                                                         //Repeats until the user is satisfied with checking apps
    }
    
    public static String addApp(ArrayList<Appointment> apps)                                                                                 //Method to add appointments to apps
    {
        Scanner in = new Scanner(System.in);                                                                                                 //Scanner for user input
        int year = 0;                                                                                                                        //Variable for year
        int month = 0;                                                                                                                       //Variable for month
        int day = 0;                                                                                                                         //Variable for day
        String description = "";                                                                                                             //Variable for the description of the appointment
        String type = "";                                                                                                                    //Variable for the type of appointment that is desired by the user
        System.out.println("Please enter the reason for the visit (Type 'exit' to go back).");                                               //Asks for the description of the visit
        description = in.nextLine();
        if (description.equalsIgnoreCase("exit"))                                                                                            //Makes the type exit and returns to the menu if the user types exit for the description
        {
            type = "exit";
            return type;
        }
        System.out.println("Please enter the type of appointment (Onetime, Monthly, Daily): ");                                              //Asks for the type of appointment and will validate to obtain proper input
        type = in.next();
        while (((!type.equalsIgnoreCase("Onetime") && !type.equalsIgnoreCase("Daily")) && !type.equalsIgnoreCase("Monthly")))
        {
            System.out.println("Please enter a valid input: ");
            type = in.next();
        }
        while (year < 1900 || year > 9999)                                                                                                   //Asks the user for the year of their appointment and will validate to receive a proper year                                                                                      
        {
            try                                                                                                                              //Normal sequence for integers
            {
                System.out.println("Please enter the year: ");
                year = in.nextInt();
                if (year < 1900 || year > 9999)
                {
                    System.out.println("Please enter a valid input. ");
                }
            }
            catch (InputMismatchException m)                                                                                                 //Clears the scanner and tells the user to enter a valid number
            {
                System.out.println("Please enter a valid number.");
                year = 0;
                in.next();
            }
        }
        while (month < 1 || month > 12)                                                                                                      //Asks the user for the month of their appointment and will validate to receive a proper month
        {
            try                                                                                                                              //Normal sequence of numbers for integers
            {
                System.out.println("Please enter the month in numeric format: ");
                month = in.nextInt();
                if (month < 1 || month > 12)
                {
                    System.out.println("Please enter a valid input. ");
                }
            }
            catch (InputMismatchException m)                                                                                                 //Clears the scanner and tells the user to enter a valid number
            {
                System.out.println("Please enter a valid number.");
                month = 0;
                in.next();
            }
        }
        while (day < 1 || day > 31)                                                                                                          //Asks the user for the day of their appointment and will validate to receive a proper day based on the days in the given month
        {
            try                                                                                                                              //Normal sequence for integers
            {
                System.out.println("Please enter the day: ");
                day = in.nextInt();
                switch (month)                                                                                                               //Uses the given month for a switch statement to determin how many days are in the month
                {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:                                                                //For all months with 31 days
                        while (day < 1 || day > 31)
                        {
                            System.out.println("Please enter a valid input: ");
                            day = in.nextInt();
                        }
                        break;
                    case 4: case 6: case 9: case 11:                                                                                         //For all months with 30 days
                        while (day < 1 || day > 30)
                        {
                            System.out.println("Please enter a valid input: ");
                            day = in.nextInt();
                        }
                        break;
                    case 2:
                        if(((year % 4 == 0) && !(year == 100)) || (year % 400 == 0))                                                         //For leap years on February
                        {
                            while (day < 1 || day > 29)
                            {
                                System.out.println("Please enter a valid input: ");
                                day = in.nextInt();
                            }
                            break;
                        }
                        else
                        {
                            while (day < 1 || day > 28)                                                                                      //For normal years on february
                            {
                                System.out.println("Please enter a valid input: ");
                                day = in.nextInt();
                            }
                            break;
                        }
                }
            }
            catch (InputMismatchException m)                                                                                                 //Clears the scanner and tells the user to enter a valid number
            {
                System.out.println("Please enter a valid number.");
                day = 0;
                in.next();
            }
        }
        if (type.equalsIgnoreCase("Onetime"))                                                                                                //Makes an object to add to arraylist apps based on the type entered using the description and the date
        {
            apps.add(new Onetime(description, year, month, day));                                                                            //For Onetime apps
        }
        else if (type.equalsIgnoreCase("Daily"))
        {
            apps.add(new Daily(description, year, month, day));                                                                              //For Daily apps
        }
        else if (type.equalsIgnoreCase("Monthly"))
        {
            apps.add(new Monthly(description, year, month, day));                                                                            //For Monthly apps
        }
        System.out.println("The appointment has been registered.");                                                                          //Confirms that the appointment has been registered
        return type;                                                                                                                         //Will repeat until the user is satified with the entries
    }
    
    public static void save(ArrayList<Appointment> apps)                                                                                     //Method to save all current appointments in apps to a document; Must load all apps first before saving
    {
        String type = "";                                                                                                                    //Variable to obtain the type of object being saved
        PrintWriter appointments = null;                                                                                                     //Output to the file
        String lineSpace = System.getProperty("line.separator");                                                                             //Allows lines to be separated on all OS
        try                                                                                                                                  //Normal sequence for the file to be saved normally
        {
            appointments = new PrintWriter("Appointments.txt");                                                                              //Given a document to write to
            for (int i = 0; i < apps.size(); i++)                                                                                            //Iterates through apps to add all appointments to the document
            {
                if (apps.get(i) instanceof Daily)                                                                                            //If-else statements to determin the type of object being saved
                {
                    type = "Daily";                                                                                                          //For Daily apps
                }
                else if (apps.get(i) instanceof Monthly)
                {
                    type = "Monthly";                                                                                                        //For Monthly apps
                }
                else if (apps.get(i) instanceof Onetime)
                {
                    type = "Onetime";                                                                                                        //For Onetime apps
                }
                if (i == apps.size() - 1)                                                                                                    //Will not create another line under the last object when printing to the document
                {
                    appointments.printf("%s/%s/%s;%s;%s;", apps.get(i).getMonth(), apps.get(i).getDay(), apps.get(i).getYear(), type, apps.get(i).getDescription());
                }
                else                                                                                                                         //Prints appointment data to the document
                {
                    appointments.printf("%s/%s/%s;%s;%s;" + lineSpace, apps.get(i).getMonth(), apps.get(i).getDay(), apps.get(i).getYear(), type, apps.get(i).getDescription());
                }
            }
            System.out.println("Appointments have been saved.");                                                                             //Confirms the save was successful
        }
        catch (FileNotFoundException f)                                                                                                      //States that the file can't be found
        {
            System.out.println("The file could not be found.");
        }
        catch (IOException e)                                                                                                                //States that the save was unsuccessful
        {
            System.out.println("Could not save the file.");
        }
        finally
        {
            appointments.close();                                                                                                            //Closes the document regardless of the outcome
        }
    }
    
    public static ArrayList load()                                                                                                           //Loads all appointments from a file
    {
        int year, month, day;                                                                                                                //Variables for the date
        String[] appointData;                                                                                                                //String array for the different information for the appointment
        String date;                                                                                                                         //Keeps the date in a string
        String[] dateNum;                                                                                                                    //Array for the split date string into the month, day, and year string values
        ArrayList<Appointment> data = new ArrayList<Appointment>();                                                                          //Arraylist to copy to apps
        File appoints = null;                                                                                                                //File to load for appointments
        Scanner in = null;                                                                                                                   //Input from the file
        try                                                                                                                                  //Normal sequence for a successful load
        {
            appoints = new File("Appointments.txt");                                                                                         //File is declared
            in = new Scanner(appoints);                                                                                                      //Destination of input is given
            while(in.hasNextLine())                                                                                                          //iterates through the file for all the appointments
            {
                appointData = in.nextLine().split(";");                                                                                      //Splits the data in a line
                date = appointData[0];                                                                                                       //Variable date tahkes the date from the sero index in the array appointData
                dateNum = date.split("/");                                                                                                   //Puts the month day, and year separately into array dateNum
                month = Integer.parseInt(dateNum[0]);                                                                                        //Parses the month, day, and year to get the numerical values
                day = Integer.parseInt(dateNum[1]);
                year = Integer.parseInt(dateNum[2]);
                if (appointData[1].equals("Onetime"))                                                                                        //Uses the Type from the one index to determine the type of object to make with the descrption in index two of appointData and the date
                {
                    data.add(new Onetime(appointData[2], year, month, day));                                                                 //For Onetime apps
                }
                else if(appointData[1].equals("Monthly"))
                {
                    data.add(new Monthly(appointData[2], year, month, day));                                                                 //For Monthly apps
                }
                else if (appointData[1].equals("Daily"))
                {
                    data.add(new Daily(appointData[2], year, month, day));                                                                   //For Daily apps
                }
            }
            System.out.println("Appointments have been loaded.");                                                                            //Confirms all appointments have been loaded
        }
        catch (IOException e)                                                                                                                //States the file was unable to be loaded
        {
            System.out.println("The file could not be loaded properly.");
        }
        catch (RuntimeException n)                                                                                                           //States that the data was unable to be loaded from the file
        {
            System.out.println("Data was not loaded properly.");
        }
        finally
        {
            in.close();                                                                                                                      //Closes the file regardless of outcome
        }
        return data;                                                                                                                         //Returns the arraylist of loaded objects
    }
    
    public static void main(String[] args)                                                                                                   //Program that gives the user the option to check, add, save, and load appointments
    {
        ArrayList<Appointment> apps = new ArrayList<Appointment>();                                                                          //Arraylist of all currently recorded appointments
        int year, month, day;                                                                                                                //Variables for the date
        int choice = 0;                                                                                                                      //Variable for the menu selection
        Scanner in = new Scanner(System.in);                                                                                                 //Scanner for user input
        while (choice != 4)                                                                                                                  //Repeats the program until the user enters 4 for choice
        {
            String type = "";                                                                                                                //Used to know when to stop looping the section of the menu the user is in and also when to save or load
            System.out.println("What would you like to do?");                                                                                //Menu for the user
            System.out.println("Enter the number for the choice you want.");
            System.out.println("1. Check for existing appointments.");
            System.out.println("2. Add new appointments.");
            System.out.println("3. Save/Load existing appointments.");
            System.out.println("4. Exit the program.");
            try                                                                                                                               //Normal sequence for integers    
            {
                choice = in.nextInt();
                while (choice > 4 || choice < 1)                                                                                              //Repeats until choice is an integer between 1 and 4 inclusively
                {
                    System.out.println("Please enter a valid input: ");
                    choice = in.nextInt();
                }
            }
            catch (InputMismatchException i)                                                                                                   //Validates choice for non-integer input and clears the scanner 
            {
                System.out.println("Please enter a valid number.");
                choice = 0;
                in.next();
            }
            if (choice == 1)                                                                                                                    //Triggers the CheckApp method
            {
                while (!type.equalsIgnoreCase("exit"))
                {
                    type = checkApp(apps);
                }
            }
            else if (choice == 2)                                                                                                               //Triggers the addApp method
            {
                while (!type.equalsIgnoreCase("exit"))
                {
                    type = addApp(apps);
                }
            }
            else if (choice == 3)                                                                                                                //Asks the user if they want to save or load a file, and validates the option
            {
                System.out.println("Would you like to save or load a list of appointments? (S/L): ");
                type = in.next();
                if (!type.equalsIgnoreCase("S") && !type.equalsIgnoreCase("L"))
                {
                    System.out.println("Please enter a valid input (S/L): ");
                    type = in.next();
                }
                if (type.equalsIgnoreCase("S"))                                                                                                   //Triggers the save method
                {
                    save(apps);
                }
                else if(type.equalsIgnoreCase("L"))                                                                                                //Triggers the load method
                {
                    ArrayList<Appointment> loadData = new ArrayList<Appointment>();                                                                //Arraylist to hold the loaded data
                    loadData = load();                                                                                                             //Copies the returned arraylist in the load function
                    for (int j = 0; j < loadData.size(); j++)                                                                                      //Adds all loaded appointments to arraylist apps
                    {
                        apps.add(loadData.get(j));
                    }
                    loadData.clear();                                                                                                               //Clears the load arraylist
                }
            }
            else if (choice == 4)                                                                                                                   //Displays that the program is shutting down due to user input
            {
                System.out.println("Closing the program now.");
            }
        }
    }
}

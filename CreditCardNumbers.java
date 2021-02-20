import java.io.*;
import java.util.*;
import java.util.ArrayList;

/**
 * The Credit Card Numbers Class purpose is to take in an input file name and determine whether the file name is valid and openable.
 * If so, it can capture each line of the input file and return the contents as a String ArrayList
 * This Class utilizes the default constructor
 *
 * Class: Winter - COSC 1437.82491
 * Final Project:  CreditCardNumbers Class, CreditCardNumbers Demo Driver Program,
 * ValidateNumber Class,
 * Date 1/10/2021
 * @author Matthew Dotson
 * @verison 1.0.0
 */
public class CreditCardNumbers
{
    // instance variables - replace the example below with your own
    private int numCardNumbers;

    
    /**
     * canOpenFile returns a boolean on whether the file name passed in can be opened without Exceptions
     *
     * @param   infi:String
     * @return   boolean
     */
    public boolean canOpenFile(String inFi)
    {
        int check =0;
        try
       {
           File myInputFile = new File(inFi);
           Scanner inputDataFile = new Scanner(myInputFile);
       
       }
       catch (NullPointerException e)
       {
           java.lang.System.out.println("File Name string given was null" + e.getMessage());
           check++;
        }
       catch (FileNotFoundException e)
       {
           java.lang.System.out.println("File not found.");
           check++;
        }
       catch (java.io.IOException e)
       {
           java.lang.System.out.println("");
        }
        if (check > 0)
        {
              java.lang.System.out.println("Error occured.");
              return false;
        }
        else
        {
           return true;
        }
    }
    
    /**
     * fileToArrayList scans the input file lines to record the contents of each line to an ArrayList that is returned after scanning
     *
     * @param    inFi:String
     * @return   array:ArrayList
     */
    public ArrayList<String> fileToArrayList(String inFi)
    {
       
        ArrayList<String> array = new ArrayList<String>();
        try
       {
           File myInputFile = new File(inFi);
           Scanner inputDataFile = new Scanner(myInputFile);
           
           
           
           while (inputDataFile.hasNext())
           {
            array.add(inputDataFile.nextLine());
           }
           
       }
       catch (NullPointerException e)
       {
           java.lang.System.out.println("File Name string given was null. " + e.getMessage());
           
        }
       catch (FileNotFoundException e)
       {
           java.lang.System.out.println("File not found. " + e.getMessage());
           
        }
       catch (java.io.IOException e)
       {
           java.lang.System.out.println("IOException issue occured. " + e.getMessage());
        }
        
        numCardNumbers= array.size();
        return array;
        
    }
}

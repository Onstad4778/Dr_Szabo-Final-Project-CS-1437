import java.io.*;
import java.util.*;

/**
 * ValidateNumber takes in a string of a potential credit card number and converts it to an integer array.
 * Upon conversion the number is run through the Luhn algorithm to determine whether or not the
 * number could be a valid credit card number.
 *
 * Class: Winter - COSC 1437.82491
 * Final Project:  CreditCardNumbers Class, CreditCardNumbers Demo Driver Program,
 * ValidateNumber Class,
 * Date 1/10/2021
 * @author Matthew Dotson
 * @verison 1.0.0
 */
    
public class ValidateNumber
{
   
    private String numString;
    private long number;
    private int numLength; 
    
    /**
     * Constructor for objects of class ValidateNumber
     * parses the string parameter n into a long variable
     * 
     * @param n:String
     * @return
     */
    public ValidateNumber(String n)
    {
        numString = n;
        
        numLength = n.length();
        
        number = Long.parseLong(n);
    }

    /**
     * Takes the current number variable and processes it through the Luhn algorithm.
     * If the final number is divisible by ten, the number can be a credit card number
     *
     * @param    none
     * @return   boolean
     */
    public boolean isNumberValid()
    {
        long numNoEnd = number/10;
        
        String numNoEndStr= Long.toString(numNoEnd);
        
        int numLengthNow = numLength;
        numLengthNow = java.lang.Math.decrementExact(numLengthNow);
        
        
        
        
        int[] numberArray= new int[numLengthNow];
        
        String[] conversion = new String[numLengthNow];
        
        int arrayTotal=0;
            for(int i= 0; i < numLengthNow; i++)
          {
              conversion[i]=("" + numNoEndStr.charAt(numLengthNow - (1+i)));
        
              numberArray[i] = Integer.parseInt(conversion[i]);
        
              if ((i % 2)==0)
              numberArray[i] *=2;
        
              if (numberArray[i] > 9)
              numberArray[i] -=9;
        
              arrayTotal += numberArray[i];
    
          }
        
        
          if    (((number+arrayTotal)%10) == 0)
                return true;
        
          else
                return false;
        
    }
}

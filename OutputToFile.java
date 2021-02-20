import java.util.*;
import java.io.*;
/**
 * This class is capable of opening an output file to print to with the name of the file as the string given.
 * It can print Strings to the output file in the form of headers. It can also print the contents of an ArrayList
 * to the output file. It also gives the capability to close this particular file.
 * 
 * Class: Winter - COSC 1437.82491
 * Final Project:  CreditCardNumbers Class, CreditCardNumbers Demo Driver Program,
 * ValidateNumber Class,
 * Date 1/10/2021
 * @author Matthew Dotson
 * @verison 1.0.0
 */
public class OutputToFile
{
    
    private PrintWriter outputFile;
    private String header;

    /**
     * Constructor for objects of class OutputToFile
     * fileName is used as the name of the output file
     * 
     * @param fileName:String
     * @return none
     */
    public OutputToFile(String fileName)
    {
         try
         {
             outputFile = new PrintWriter(fileName);
          }
         catch(NullPointerException e)
         {
               System.out.println("Output file name was null");
           }
         catch(FileNotFoundException e)
         {
               System.out.println("File was not found.");
           }
         catch(IOException e)
         {
               System.out.println("IO could not open file.");
           }
    }
    
    /**
     * Constructor for objects of class OutputToFile
     * fileName is used as the name of the output file
     * h is used as the header of the file, it makes sure the header is on top
     * 
     * @param fileName:String ,  @h:String
     */
    public OutputToFile(String fileName, String h)
    {
        header =h;
        try
         {
             outputFile = new PrintWriter(fileName);
          }
         catch(NullPointerException e)
         {
               System.out.println("Output file name was null");
           }
         catch(FileNotFoundException e)
         {
               System.out.println("File was not found.");
           }
         catch(IOException e)
         {
               System.out.println("IO could not open file.");
           }
    }

    /**
     * printHeader prints a header on the output file. 
     * It takes the string parameter h and prints it with header formatting
     *
     * @param  h:String
     * @return  none
     */
    public void printHeader(String h)
    {
        header =h;
        printHeader();
    }
    
    /**
     * printHeader prints whatever is currently set as a header to the output file in header formatting.
     *
     * @param  none
     * @return none
     */
    public void printHeader()
    {
        outputFile.printf("%50s%n%n", header);
    }
    
    /**
     * printGroup prints the contents of a String ArrayList with a formatted group title above it
     *
     * @param  g:String ,  c:ArrayList<String>
     * @return none
     */
    public void printGroup(String g, ArrayList<String> c)
    {
        if (c.size() >0){
        outputFile.printf("%-25s%n%n", g);
        
        for (String a : c)
        {
            outputFile.printf("%20s%n%n" , a);
            
        }}
    }
    
    /**
     * closeFile closes the outputFile
     *
     * @param  none
     * @return none
     */
    public void closeFile()
    {
        outputFile.close();
    }
}



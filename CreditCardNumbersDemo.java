    import java.io.*;
    import java.util.*;
    
    
    /**
     * This class is to Demonstrate how to use Class CreditCardNumbers
     * to validate or invalidate a list of card numbers
     *
     * Class: Winter - COSC 1437.82491
     * Final Project:  CreditCardNumbers Class, CreditCardNumbers Demo Driver Program,
     * ValidateNumber Class,
     * Date 1/10/2021
     * @author Matthew Dotson
     * @verison 1.0.0
     */
    
    public class CreditCardNumbersDemo
    {
      public static void main(java.lang.String args[]) throws IOException{
                // Greet user
                java.lang.System.out.println("Hello Detective!");
                
                // Store String arguments passed in
                String inputFileName = args[0];
                String outputFile1 = args[1];
                String outputFile2 = args[2];
                
                //set loop value to simplify while loop
                boolean loop =true;
         
        //While the user attempts to respond to the query, it checks to see if the user is involved in the investigation
        while (loop==true)
            {
                    //create keyboard input    
                    java.util.Scanner keyboard = new java.util.Scanner(System.in);
                    //prompt user
                    java.lang.System.out.println("Are you working on case number 20150510-001? (Enter Yes or No)");
                    //Store response
                    String answer = keyboard.nextLine();
        //check to see if the first letter input was n
            if (answer.charAt(0) == 'N' || answer.charAt(0) == 'n')
        {
           java.lang.System.out.println("You do not have access to this process. Have a blessed day.");
           return;
        }
            else
        {
        //check to see if the first letter input was not why either
            if (answer.charAt(0) != 'Y' && answer.charAt(0)!='y')
        {
            java.lang.System.out.println("Your input was invalid. Try Again.");
        }
        else
        {  //the only way the code gets here is if the response started with Y or y and that can break the loop
           loop =false; 
        }
        }}
            
            // remind the user of the file names passed in case there was an error
           java.lang.System.out.println("The input file that was passed in is titled " + inputFileName);
           java.lang.System.out.println("The first output file that was passed in is titled " + outputFile1);
           java.lang.System.out.println("The second output file that was passed in is titled " + outputFile2);
        
           //Make a new CreditCardNumbers Object
           CreditCardNumbers ccn = new CreditCardNumbers();
           
           
           java.lang.System.out.println("Uploading Data File...");
           
           
           
           //Check to see if the file name passed in can be opened and stop the program if it cannot
        if (!ccn.canOpenFile(inputFileName))
           {
               java.lang.System.out.println("Error encountered");
               return;
           }
        else
           {
               java.lang.System.out.println("File opened properly.");
           }
           
           
           java.lang.System.out.println("Scanning Data...");
           
           ArrayList<String> dataArray = new ArrayList<String>();
           
           //Store the input data into an arrayList
           dataArray = ccn.fileToArrayList(inputFileName);
           
           // create array lists to hold parallel data fields
           ArrayList<String> numbersWithValidIssuer = new ArrayList<String>();
           ArrayList<String> validNumberIssuers = new ArrayList<String>();
           ArrayList<String> invalidCardBadIIN = new ArrayList<String>();
           ArrayList<String> invalidCardBadCardNum = new ArrayList<String>();
           
           java.lang.System.out.println("Data Scanned.");
           
           java.lang.System.out.println("Determining validity of IIN and Provider Name for each card number...");
           
           //for every member of the input data list, the DetermineIssuer Class will validate the IIN
           //and determine which provider the card belongs to 
       for( String a : dataArray)
        {    
              DetermineIssuer d = new DetermineIssuer(a);
              
              //if the IIN is defined by a provider, store the number and the parallel provider
              if (d.isValidIIN()==true)
              {
                  validNumberIssuers.add(d.getIssuer());
                  numbersWithValidIssuer.add(a);
                }
              else
                  invalidCardBadIIN.add(a); // if invalid, store it as invalid based on the IIN
        }
           
        java.lang.System.out.println("Validated. Providers Stored."); 
        
        //create ArrayLists for the twice-confirmed-valid credit card numbers and their parallel providers
           ArrayList<String> confirmedCard = new ArrayList<String>();
           ArrayList<String> confirmedCardProvider = new ArrayList<String>();
           
           
        java.lang.System.out.println("Determining validity of card numbers...");
        
        int numbersSize = numbersWithValidIssuer.size();
        
        //check the numbers who had a valid IIN to see if their numbers are confirmed with a ValidateNumber object-loop
        for (int i=0; i < numbersSize; i++)
        {
            String a = numbersWithValidIssuer.get(i);
            String b = validNumberIssuers.get(i);
            ValidateNumber v = new ValidateNumber(a);
            
            if (v.isNumberValid() == true) //if the card number is confirmed add the number and provider to parallel arrays
            {
                confirmedCard.add(a);
                confirmedCardProvider.add(b);
                
            }
            else
                invalidCardBadCardNum.add(a); //if the card number was invalidated because of the card number, store it in the corresponding array
        }
        
           java.lang.System.out.println("Confirmed Valid Cards sorted from Invalid Cards.");
        
           //create an array for each provider to sort the numbers by provider
                ArrayList<String> visaCards = new ArrayList<String>();
                ArrayList<String> masterCards = new ArrayList<String>();
                ArrayList<String> amexCards = new ArrayList<String>();
                ArrayList<String> discoverCards = new ArrayList<String>();
                ArrayList<String> jcbCards = new ArrayList<String>();
                ArrayList<String> dcnaCards = new ArrayList<String>();
                ArrayList<String> dccbCards = new ArrayList<String>();
                ArrayList<String> dciCards = new ArrayList<String>();
                ArrayList<String> maestroCards = new ArrayList<String>();
                ArrayList<String> laserCards = new ArrayList<String>();
                ArrayList<String> visaElectronCards = new ArrayList<String>();
                ArrayList<String> instaPaymentCards = new ArrayList<String>();
                
           java.lang.System.out.println("Sorting Cards By Provider...");
                
             for(int i=0; i<confirmedCard.size(); i++) // for each confirmed number, sort the numbers into their provider name array
           {
               String p = confirmedCardProvider.get(i);
               String n = confirmedCard.get(i);
                if ((p.equals("Visa"))==true)
                {
                    visaCards.add(n);
                }
                
                if ((p.equals("MasterCard"))==true)
                {
                    masterCards.add(n);
                }
            
                if ((p.equals("American Express"))==true)
                {
                    amexCards.add(n);
                }
                if ((p.equals("Discover"))==true)
                {
                    discoverCards.add(n);
                }
                if ((p.equals("JCB"))==true)
                {
                    jcbCards.add(n);
                }
                if ((p.equals("Diners Club - USA & Canada"))==true)
                {
                    dcnaCards.add(n);
                }
                if ((p.equals("Diners Club - Carte Blanche"))==true)
                {
                    dccbCards.add(n);
                }
                if ((p.equals("Diners Club - International"))==true)
                {
                    dciCards.add(n);
                }
                if ((p.equals("Maestro"))==true)
                {
                    maestroCards.add(n);
                }
                if ((p.equals("Laser"))==true)
                {
                    laserCards.add(n);
                }
                if ((p.equals("Visa Electron"))==true)
                {
                    visaElectronCards.add(n);
                }
                if ((p.equals("InstaPayment"))==true)
                {
                    instaPaymentCards.add(n);
                }
            }
          
            java.lang.System.out.println("Cards Sorted by Provider.");
                
            // set the headers for the valid and invalid output files
                String header = "Valid Credit Card Numbers";
                String header2 = "Invalid Credit Card Numbers";
                
            // create two OutputToFile objects one for the valid data and the invalid data
                OutputToFile outFValid = new OutputToFile(outputFile1);
                OutputToFile outFInvalid = new OutputToFile(outputFile2, header2);
            
            // print the header and the sorted data to the valid output file using the OutputToFile object
                outFValid.printHeader(header);
                outFValid.printGroup("Visa:", visaCards);
                outFValid.printGroup("MasterCard:", masterCards);
                outFValid.printGroup("American Express:", amexCards);
                outFValid.printGroup("Discover:", discoverCards);
                outFValid.printGroup("JCB:", jcbCards);
                outFValid.printGroup("Diners Club - North America:", dcnaCards);
                outFValid.printGroup("Diners Club - Carte Blanche:", dccbCards);
                outFValid.printGroup("Diners Club - International:", dciCards);
                outFValid.printGroup("Maestro:", maestroCards);
                outFValid.printGroup("LASER:", laserCards);
                outFValid.printGroup("Visa Electron:", visaElectronCards);
                outFValid.printGroup("InstaPayment:", instaPaymentCards);
                outFValid.closeFile();//close the file
                
            // print the header and the data to the invalid output file using the OutputToFile object    
                outFInvalid.printHeader();
                outFInvalid.printGroup("Invalid due to Bad IIN:", invalidCardBadIIN);
                outFInvalid.printGroup("Invalid due to Bad Card Number:", invalidCardBadCardNum);
                outFInvalid.closeFile();//close the file
                
                
        
        
            // remind the user where to find the sorted data
                java.lang.System.out.println("Results have been printed to files \""+ outputFile1 +"\" and \""+ outputFile2 +"\".");
                
                java.lang.System.out.println("Mobius Duck won't get away with it. Go get him.");
           }
    
    
  }  


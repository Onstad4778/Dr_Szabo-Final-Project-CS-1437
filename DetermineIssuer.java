 
/**
 * The DetermineIssuer Class is capable of taking in a string of potential credit card numbers and determine whether
 * or not the the IIN is valid and what provider's IIN the card number is associated with
 *
 * Class: Winter - COSC 1437.82491
 * Final Project:  CreditCardNumbers Class, CreditCardNumbers Demo Driver Program,
 * ValidateNumber Class,
 * Date 1/10/2021
 * @author Matthew Dotson
 * @verison 1.0.0
 */
public class DetermineIssuer
{
    // instance variables - replace the example below with your own
    private String number;
    private String issuer="void";

    /**
     * Constructor for objects of class DetermineIssuer
     * sets number value to parameter n, runs method setIssuer to make sure isValidIIN will 
     * function immeditaely after construction
     * 
     * @param n:String
     */
    public DetermineIssuer(String n)
    {
        number = n;
        setIssuer();
    }

    /**
     * setIssuer runs the string ' number' variable through a series of tests to determine whether the IIN
     * belongs to a provider or still should remain 'void'
     *
     * @param   none
     * @return  none
     */
    public void setIssuer()
    {
        if (( ( number.startsWith("34")) || ( number.startsWith("37"))) && ( number.length() == 15))
        issuer = "American Express";
        
        if (( ( number.startsWith("300")) || ( number.startsWith("301")) || ( number.startsWith("302")) || ( number.startsWith("303")) ||
        ( number.startsWith("304")) || ( number.startsWith("305")) ) && ( number.length()==14) )
        issuer = "Diners Club - Carte Blanche";
        
        if ( ( number.startsWith("36") ) && ( number.length()==14) )
        issuer = "Diners Club - International";
        
        if ( ( number.startsWith("54") ) && ( number.length()==16) )
        issuer = "Diners Club - USA & Canada";
        
        boolean discoverRange = false;
        
        String discoverRangeNumber;
        
        for (int i = 622126; i < 622926;i++)
        {
            while(discoverRange == false)
            {
            discoverRangeNumber = String.valueOf(i);
            if( number.startsWith(discoverRangeNumber))
            discoverRange=true;
            else
            break;
            }
            
        }
        
        if (( ( number.startsWith("6011"))|| ( number.startsWith("644")) || ( number.startsWith("645")) || ( number.startsWith("646")) ||
        ( number.startsWith("647")) || ( number.startsWith("648")) || ( number.startsWith("649")) || ( number.startsWith("65")) ||
        (discoverRange==true) ) && ( number.length()==16) )
        issuer = "Discover";
        
        if (( ( number.startsWith("637")) || ( number.startsWith("638")) || ( number.startsWith("639")) ) && ( number.length() == 16))
        issuer = "InstaPayment";
        
        boolean JCBRange = false;
        
        String JCBRangeNumber;
        
        for (int i = 3528; i < 3590;i++)
        {
            while(JCBRange == false)
           {
               JCBRangeNumber = String.valueOf(i);
             if( number.startsWith(JCBRangeNumber))
                {   
                    JCBRange=true;
                 }
             else
                    break;
           }
        }
        
        if ((JCBRange==true) && ( number.length()==16))
        issuer = "JCB";
        
        if (( ( number.startsWith("6304")) || ( number.startsWith("6706")) || ( number.startsWith("6771")) || ( number.startsWith("6709")))
         && ( ( number.length()==16) || ( number.length()==17) || ( number.length()==18) || ( number.length()==19)))
        issuer = "Laser";
        
        if (( ( number.startsWith("5018")) || ( number.startsWith("5020")) || ( number.startsWith("5038")) || ( number.startsWith("5893"))
        || ( number.startsWith("6304")) || ( number.startsWith("6759")) || ( number.startsWith("6761")) || ( number.startsWith("6762"))
        || ( number.startsWith("6763")) ) && ( ( number.length()==16) || ( number.length()==17) || ( number.length()==18) || ( number.length()==19) ))
        issuer = "Maestro";
        
        if (( ( number.startsWith("51")) || ( number.startsWith("52"))|| ( number.startsWith("53"))||  ( number.startsWith("54")) 
        || ( number.startsWith("55")))  && ( ( number.length()==16) || ( number.length()==17) || ( number.length()==18) || ( number.length()==19)))
        issuer = "MasterCard";
        
        if (( number.startsWith("4")) && ( ( number.length()==13) || ( number.length()==14) || ( number.length()==15) || ( number.length()==16)))
        issuer = "Visa";
        
        if (( ( number.startsWith("4026")) || ( number.startsWith("417500")) || ( number.startsWith("4508")) || ( number.startsWith("4844"))
         || ( number.startsWith("4913")) || ( number.startsWith("4917")))
        && ( number.length() == 16))
        issuer = "Visa Electron";
        
        
    }
    
    /**
     * isValidIIN checks to see if the issuer is still void after being set, if so, it will return false
     * if the issuer contains a new value, it will return true
     *
     * @param    none
     * @return   none
     */
    public boolean isValidIIN()
    {
        if (!issuer.equals("void"))
        return true;
        else 
        return false;
    }
    /**
     * getIssuer returns the issuer name in a String
     *
     * @param   none
     * @return  issuer:String
     */
    public String getIssuer()
    {
        return issuer;
    }
    
    
}

//this example demonstrates the datatype String and the functions available in that class
package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class StringBasics {
    static Logger logger= Logger.getLogger(StringBasics.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //we can create strings via different methods
        String name="Karina";
        logger.info("The string created using literal is:"+name);

        //strings can also be created using new operator
        char[] nameCharArray={'K','a','r','i','n','a'};
        String nameC = new String(nameCharArray);
        logger.info("String created using character array is:"+ nameC);

        //Even though the strings are same, since the second string is created using new operator, the references would be different
        logger.info("Are the references same:");
        logger.info(name==nameC);

        //functions provided by String class of Java
        //1.Length of the string
        logger.info("Length of the string is:"+name.length());

        //2.String can be converted to character array
        char[] characterArray =name.toCharArray();
        logger.info("Character at the 4th index is:"+ characterArray[4]);  //fetching the character at the 4th index

        //3.To find the index of a character in the string
        logger.info("Index of character 'a' is:"+name.indexOf('a'));

        //4.To find the character at a particular index
        logger.info("Character at index 2 is:"+name.charAt(2));

        //5.To compare a given string with other string could be done using the 'equals' function
        logger.info("Are the two strings same?"+name.equals("karina"));

        //6.In the above function we can ignore the case using function 'equalsIgnoreCase()'
        logger.info("Are the two strings same if case is ignored?"+name.equalsIgnoreCase("karina"));

    }
}

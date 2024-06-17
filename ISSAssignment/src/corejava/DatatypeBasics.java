//This example demonstrates basic datatypes,variable types

package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class Employee{
    private String name;
    private int id;
}

public class DatatypeBasics {

    static Logger logger=Logger.getLogger(DatatypeBasics.class);
    public static void main(String[] args)
    {
        String log4jConfigFile = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //datatypes are of two types
        //primitive and object datatype (Java reference)

        //There are 8 primitive datatypes in Java.They are also called scalar datatypes

        //byte is 8-bit datatype and its value ranges from -128 to 127 (-2^7 to 2^7-1)
        byte byteVal1 = 6;
        byte byteVal2 = 127;

        //if on addition value falls outside the range,wrapping up takes place.
        byte byteAdditionResult = (byte) (byteVal1 + byteVal2);  //here typecasting is necessary because the result is of type int which is a larger datatype

        byte byteSubtractionResult = (byte) (Math.abs(byteVal1 - byteVal2));

        logger.info("Addition result of byte:"+byteAdditionResult);
        logger.info("Subtraction result of byte:"+byteSubtractionResult);

        //short is 16-bit datatype and its value ranges from -32,768 to 32,767 (-2^15 to 2^15-1)
        short shortVal1=1000;
        short shortVal2=200;

        short shortAdditionResult=(short)(shortVal1+shortVal2);
        short shortSubtractionResult=(short)(shortVal1-shortVal2);

        logger.info("Addition result of short:"+shortAdditionResult);
        logger.info("Subtraction result of short:"+shortSubtractionResult);

        //int is 32-bit datatype and its value ranges from -2,147,483,648 to 2,147,483,647 (-2^31 to 2^31-1)
        int intVal1=-986;
        int intVal2=700;

        int intXorResult=intVal1 ^ intVal2;
        int intOrResult=intVal1 | intVal2;
        int intAndResult=intVal1 & intVal2;

        logger.info("XOR result of int:"+intXorResult);
        logger.info("OR result of int:"+intOrResult);
        logger.info("AND result of int:"+intAndResult);

        //long is 64-bit datatype and its value ranges from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (-2^63 to 2^63-1)
        long longVal1=900;
        long longVal2=1000;

        long longMultiplicationResult=longVal1*longVal2;
        long longDivisionResult=longVal1/longVal2;

        logger.info("Multiplication result of long:"+longMultiplicationResult);
        logger.info("Division result of long:"+longDivisionResult);

        //float is single-precision 32-bit floating point datatype
        float floatVal1=98.9f;
        float floatVal2=13.3f;

        float floatMultiplicationResult=floatVal1*floatVal2;
        float floatDivisionResult=floatVal1/floatVal2;

        logger.info("Multiplication result of float:"+floatMultiplicationResult);
        logger.info("Division result of float:"+floatDivisionResult);

        //Double is a double-precision 64-bit floating point datatype
        double doubleVal1=999.33;
        double doubleVal2=67.13;

        double doubleMultiplicationResult=doubleVal1*doubleVal2;
        double doubleDivisionResult =doubleVal1/doubleVal2;

        logger.info("Multiplication result of double:"+doubleMultiplicationResult);
        logger.info("Division result of double:"+ doubleDivisionResult);

        //char is single 16-bit Unicode character

        int charInt=97;
        char character=(char)charInt;

        logger.info("Character with the given int value is:"+character);

        //boolean is a datatype with two possible values
        boolean boolVal=true;

        if (boolVal)
            logger.info("This is printed when boolean value is true");
        else
            logger.info("This is printed when boolean value is true");

        //Java reference
        Employee employee=new Employee();
        //here employee is an object datatype or Java Reference

        logger.info(employee);

    }

}

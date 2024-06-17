package corejava;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import maths.Calculation;  //custom package

public class PackageExample {

    static Logger logger=Logger.getLogger(PackageExample.class);
    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //using a method from another package
        logger.info("Is 9 prime?"+Calculation.checkPrime(9));
        logger.info("Is 11 prime?"+Calculation.checkPrime(11));
        logger.info("Is 25 prime?"+Calculation.checkPrime(25));
        logger.info("Is 71 prime?"+Calculation.checkPrime(71));

        logger.info("Factorial of 5:"+Calculation.calculateFactorial(5));
        logger.info("Factorial of 10:"+Calculation.calculateFactorial(10));
        logger.info("Factorial of 8:"+Calculation.calculateFactorial(8));


    }
}

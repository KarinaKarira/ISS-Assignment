//this example demonstrates the loop control
package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoopControlBasics {

    static Logger logger= Logger.getLogger(LoopControlBasics.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //for loop:with for loop we can traverse a particular range
        //for example if we want to print the even numbers from 1 to 10. We will start from 2 and increment 2 steps each time
        logger.info("Even numbers between 1 to 10 using for loop are:");
        for(int looper=2;looper<=10;looper+=2){
            logger.info(looper);
        }

        //While loop can be used to perform an instruction until a condition is reached.
        logger.info("Numbers between 3 to 10 using while loop are:");
        int num=3;
        while(num<=10){
            logger.info("Value of the looper:"+num);
            num+=1;
        }

        //do while loop can be used to execute the condition at least once
        logger.info("Numbers between 5 to 10 using do while loop are:");

        int val=5;
        do{
            logger.info("Value of the variable is:"+val);
            val+=1;
        }while(val<=10);
    }
}

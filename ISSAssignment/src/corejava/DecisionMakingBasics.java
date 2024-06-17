//This example demonstrates the keywords involved in decision-making
package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DecisionMakingBasics {
    static Logger logger=Logger.getLogger(DecisionMakingBasics.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //decision-making can be with
        //1.If-else statement
        //3.Nested if-else
        //4.switch case statement

        //if statement
        int num=10;
        if (num>10){
            logger.info("Value is greater than 10");
        }
        else{
            logger.info("Value is less than or equal to 10");
        }

        //nested if-else can be used to find the largest number among 3 numbers
        int num1=2,num2=10,num3=9;

        if(num1>num2){
            if(num1>num3) {
                logger.info("Largest among the 3 numbers is:" + num1);
            }
            else
                logger.info("Largest number is:"+num3);
        }
        else if(num2>num3)
            logger.info("Largest number is:"+num2);

        //Switch case
        //In java switch-case is possible with String datatype
        String day="Monday";
        switch(day){
            case "Monday":logger.info("The day is Monday");break;
            case "Tuesday":logger.info("The day is Tuesday");break;
            case "Wednesday":logger.info("The day is Wednesday");break;
            case "Thursday":logger.info("The day is Thursday");break;
            case "Friday":logger.info("The day is Friday");break;
            case "Saturday":logger.info("The day is Saturday");break;
            case "Sunday":logger.info("The day is Sunday");break;
            default:logger.info("Default statement");
        }
    }
}

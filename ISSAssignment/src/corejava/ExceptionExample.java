package corejava;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ExceptionExample {

    static Logger logger= Logger.getLogger(ExceptionExample.class);
    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //multiple catch statements

        int[] array=new int[4];
        for(int i=0;i<4;i++)
            array[i]=i+1;

        logger.info(returnQuotient(5,0));
        try{
            logger.info(array[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            logger.warn(e);
        }
        finally{
            logger.info("Finally block always gets executed");
        }
        try {
            logger.info("Division of two numbers:" + divide(5, 0));
        }
        catch(ArithmeticException ex){
            logger.warn("Arithmetic exception(divide by zero) error caught");
        }
    }
    public static int returnQuotient(int dividend,int divisor){
        int answer=0;
        try{
            answer=dividend/divisor;
        }
        catch(ArithmeticException ex){
            logger.warn(ex);
        }
        catch(Exception e){
            logger.warn(e);
        }
        return answer;
    }

    public static int divide(int num1,int num2) throws ArithmeticException{
        if (num2==0)
        throw new ArithmeticException();

        else
            return num1/num2;
    }
}

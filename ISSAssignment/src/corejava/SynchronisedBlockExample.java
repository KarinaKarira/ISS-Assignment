package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static corejava.SynchronizedMethodExample.logger;

class Calculationn {

    //without synchronised keyword we get output in a different order

        public synchronized static void printTable ( int number){
        for (int iterator = 1; iterator <= 10; iterator++) {
            logger.info(number + "*" + iterator + "=" + iterator * number);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public long calculateFactorial ( long num){

            synchronized (this) {
                long answer = 1;
                for (int iterator = 1; iterator <= num; iterator++)
                    answer *= iterator;
                return answer;
            }
    }

}

class DemoThreadd extends Thread{

    int number;
    DemoThreadd(int number){
        this.number=number;
    }

    public void run(){
        //print table of a given number
        Calculationn calc=new Calculationn();
        calc.printTable(number);
        logger.info("Factorial of "+number+"is:"+calc.calculateFactorial(number));
    }
}

public class SynchronisedBlockExample {

    static Logger logger= Logger.getLogger(SynchronisedBlockExample.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        DemoThreadd demoThreadd1=new DemoThreadd(5);
        DemoThreadd demoThreadd2=new DemoThreadd(6);

        demoThreadd1.start();
        demoThreadd2.start();
    }
}

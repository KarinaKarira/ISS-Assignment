package corejava;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static corejava.SynchronizedMethodExample.logger;

class Calculation {

    //without synchronised keyword we get output in a different order
    public synchronized static void printTable(int number){
        for(int iterator=1;iterator<=10;iterator++) {
            logger.info(number + "*" + iterator + "=" + iterator * number);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DemoThread extends Thread{

    int number;
    DemoThread(int number){
        this.number=number;
    }

    public void run(){
        //print table of a given number
        Calculation.printTable(number);
    }
}
public class SynchronizedMethodExample {
    static Logger logger= Logger.getLogger(SynchronizedMethodExample.class);

    public static void main(String[] args){
        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        DemoThread demoThread1=new DemoThread(5);
        DemoThread demoThread2=new DemoThread(6);

        demoThread1.start();
        demoThread2.start();


    }
}

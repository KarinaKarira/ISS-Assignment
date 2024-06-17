package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static corejava.MultithreadingExample.logger;

class MyThread1 extends Thread{
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logger.info("Table of 5 from thread1:");
        for(int num=1;num<=10;num++)
            logger.info("5*"+num+"="+(5*num));
    }
}
class MyThread2 extends Thread{
    public void run(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        logger.info("Table of 10 from thread2:");   //because of sleep method we will get this statement before thread1's
        for(int num=1;num<=10;num++)
            logger.info("10*"+num+"="+(10*num));
    }
}
public class MultithreadingExample {

    static Logger logger= Logger.getLogger(MultithreadingExample.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        MyThread1 thread1=new MyThread1();
        MyThread2 thread2=new MyThread2();

        thread1.start();
        thread2.start();

    }
}

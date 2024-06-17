package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.css.Counter;

class VolatileData{
    private volatile int counter;
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void incrementCounter(){
        this.counter++;
    }
}
class MyThread extends Thread{
    private VolatileData volatileData;
    MyThread(VolatileData volatileData){
        this.volatileData=volatileData;
    }
    public void incrementCounter(){
        volatileData.incrementCounter();
    }
    public int getCounter(){
        return volatileData.getCounter();
    }
}
public class VolatileKeywordExample {
    static Logger logger= Logger.getLogger(VolatileKeywordExample.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //we will make two threads and check the value of counter
        VolatileData volatileData=new VolatileData();
        MyThread myThread1=new MyThread(volatileData);
        MyThread myThread2=new MyThread(volatileData);

        logger.info("Value of counter as seen by thread 1:"+myThread1.getCounter());
        logger.info("Value of counter as seen by thread 2:"+myThread2.getCounter());

        logger.info("Incrementing the counter by thread1");
        myThread1.incrementCounter();
        logger.info("Value of counter as seen by thread 1:"+myThread1.getCounter());
        logger.info("Value of counter as seen by thread 2:"+myThread2.getCounter());

        logger.info("Incrementing the counter by thread2");
        myThread2.incrementCounter();
        logger.info("Value of counter as seen by thread 1:"+myThread1.getCounter());
        logger.info("Value of counter as seen by thread 2:"+myThread2.getCounter());


    }
}

package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.awt.print.Book;

import static corejava.InterfaceExample.logger;

//Payment is a function that Mobile class implements
interface BookTickets{
    public void logIn(String name,String password);

    public int checkAvailableNumberOfSeats();

    public void bookTickets();
}
interface Payment{


    public void transact(double amount);

    public double checkBalance();
}

class Mobile implements BookTickets,Payment{

    @Override
    public int checkAvailableNumberOfSeats() {
        return 5;  //this number can be anything
    }

    @Override
    public void bookTickets() {
        if(checkAvailableNumberOfSeats()>0) {
            logger.info("Tickets can be booked");
            //logic for booking the ticktes
        }
        else
            logger.info("Houseful!!Tickets could not be booked");

    }

    @Override
    public void logIn(String name,String password) {
        logger.info("Credentials are name:"+name+" and password:"+password);
    }

    @Override
    public void transact(double amount) {
        logger.info("Transacting an amount of Rs."+amount);
    }

    @Override
    public double checkBalance() {
        return 500;
    }
}

public class InterfaceExample {

    static Logger logger=Logger.getLogger(InterfaceExample.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Mobile mobile=new Mobile();
        mobile.logIn("Karina","Karina123");
        logger.info("Available number of seats:"+mobile.checkAvailableNumberOfSeats());
        mobile.bookTickets();
        mobile.transact(500);
        logger.info("Available balance:"+mobile.checkBalance());
    }
}

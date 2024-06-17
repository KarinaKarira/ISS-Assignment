//this example demonstrates the use and importance of constructors
package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class Car {
    private String model_name;
    private int model_no;
    private String color;

    //No-args constructor
    Car() {
        model_name = "BMW";
        model_no = 1918;
        color = "White";
    }

    //Parameterised constructor
    Car(String model_name, int model_no, String color) {
        this.model_name = model_name;
        this.model_no = model_no;
        this.color = color;
    }

    //copy constructor
    Car(Car car) {
        this.model_name = car.model_name;
        this.model_no = car.model_no;
        this.color = car.model_name;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public int getModel_no() {
        return model_no;
    }

    public void setModel_no(int model_no) {
        this.model_no = model_no;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

public class ConstructorBasics {

    static Logger logger= Logger.getLogger(ConstructorBasics.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //creating an object with no-arg constructor
        Car carObj1=new Car();
        logger.info("With no-arg constructor,model_name is:"+carObj1.getModel_name());
        logger.info("With no-arg constructor,model_no is:"+carObj1.getModel_no());
        logger.info("With no-arg constructor,color of the car is:"+carObj1.getColor());

        //creating an object with parameterised constructor
        Car carObj2=new Car("Mercedes",1010,"Black");
        logger.info("With parameterised constructor,model_name is:"+carObj2.getModel_name());
        logger.info("With parameterised constructor,model_no is:"+carObj2.getModel_no());
        logger.info("With parameterised constructor,color of the car is:"+carObj2.getColor());

        //creating object with copy constructor
        Car carObj3=new Car(carObj2);
        logger.info("With copy constructor,model_name is:"+carObj3.getModel_name());
        logger.info("With copy constructor,model_no is:"+carObj3.getModel_no());
        logger.info("With copy constructor,color of the car is:"+carObj3.getColor());
    }
}

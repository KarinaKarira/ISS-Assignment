//this example demonstrates Inheritance and method overriding
package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static corejava.InheritanceBasics.logger;

class Vehicle{
    private String color;
    private double maxSpeed;
    private int capacity;
    private String modelName;

    Vehicle(){
        color="White";
        maxSpeed =45;
        capacity=2;
        modelName="Mercedes";
    }

    Vehicle(String color,double maxSpeed,int capacity,String modelName){
        this.color=color;
        this.maxSpeed=maxSpeed;
        this.capacity=capacity;
        this.modelName=modelName;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }


    public void start(){
        //no code to write here because it depends on the type of vehicle
    }
    public void stop(){
        //no code to write here because it depends on the type of vehicle
    }
}
class Carr extends Vehicle{

    Carr(){
        super();
    }
    Carr(String color,double maxSpeed,String modelName){
        super(color,maxSpeed,4,modelName);

    }


    public void start(){
       logger.info("Car has a different method of starting");
    }
    public void stop(){
        logger.info("Car may have a different method of stopping");
    }
}
class Bike extends Vehicle{

    Bike(){
        super();

    }
    Bike(String color,double speed,String modelName){
        super(color,speed,2,modelName);
    }
    public void start(){
        logger.info("A bike has a different method of starting");
    }
    public void stop(){
        logger.info("A bike may have a different method of stopping");
    }
}
public class InheritanceBasics {

    static Logger logger= Logger.getLogger(InheritanceBasics.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Vehicle vehicle=new Vehicle();
        logger.info("Name of the Vehicle is:"+vehicle.getModelName()+" color is:"+vehicle.getColor()+" capacity and max speed are respectively:"+vehicle.getCapacity()+" "+vehicle.getMaxSpeed());


        Carr carr=new Carr("White",60,"Comet");
        logger.info("Model of the car is:"+carr.getModelName()+" color is:"+carr.getColor()+" capacity and max speed are respectively:"+carr.getCapacity()+" "+carr.getMaxSpeed());

        carr.start();
        carr.stop();

        Bike bike=new Bike("Red",50,"Avenger");
        logger.info("Model of the bike is:"+bike.getModelName()+" color is:"+bike.getColor()+" capacity and max speed are respectively:"+bike.getCapacity()+" "+bike.getMaxSpeed());
        bike.start();
        bike.stop();

    }
}

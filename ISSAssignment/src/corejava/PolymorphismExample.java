//this example demonstrates the concept of Polymorphism
package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static corejava.PolymorphismExample.logger;

class Engineer{
    private String name;

    Engineer()
    {
        name="XYZ";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work(){
        logger.info("Inside Engineer class work method");
    }
}
class SoftwareEngineer extends Engineer{
    SoftwareEngineer(){
        super();
    }

    @Override
    public void work() {
        logger.info("Inside Software Engineer's work method");
    }
}

class AreaCalculator{

    private static final double pi=3.1415;
    public double findArea(double side){
        //area of square

        return side*side;
    }
    public double findArea(double length,double breadth){
        return length*breadth;
    }
    public double findArea(int radius){
        return pi*radius*radius;
    }
}

public class PolymorphismExample {

    static Logger logger= Logger.getLogger(PolymorphismExample.class);

    public static void main(String[] args){
        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //Polymorphism is of two types
        //1.Static or compile-time polymorphism
        //2.Dynamic or run-time polymorphism

        //static polymorphism
        //calling findArea method for three figures
        AreaCalculator areaCalculator=new AreaCalculator();
        logger.info("Area of a square is:"+ areaCalculator.findArea(5.5));
        logger.info("Area of a rectangle is:"+areaCalculator.findArea(5.0,6.0));
        logger.info("Area of a circle is:"+areaCalculator.findArea(5));

        //dynamic polymorphism
        Engineer engineer=new Engineer();
        engineer.work();

        //here even though the reference is of parent, the child's method will be called and hence it is also known as Dynamic Method Dispatch (DMD)
        //A parent reference can refer a child object
        Engineer engineer1=new SoftwareEngineer();
        engineer1.work();
    }
}

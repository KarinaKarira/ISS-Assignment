//This example demonstrates Abstraction and its uses
package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;

abstract class Shape{
    List<Double> sides=new ArrayList<>();


    Shape(){
        //adding atleast one side in the list
        sides.add((double)5);
    }

    //we don't know how many sides a shape can have, so we write ... it means it can accept any number of arguments i.e. var-args(variable arguments)
    Shape(double ...args){
        for(double arg:args){
            sides.add(arg);
        }
    }
    //abstract method to find perimeter and area
    abstract public double calculateArea();

    abstract public double calculatePerimeter();
}

class Rectangle extends Shape{

    //if in a constructor there is no call to this() or super() then it will go to the default constructor of the parent
    Rectangle(){
        sides.add((double)6);
    }
    Rectangle(double length,double breadth){
        super(length,breadth);
    }

    @Override
    public double calculateArea() {
        return sides.get(0)*sides.get(1);
    }

    @Override
    public double calculatePerimeter() {
        return 2*(sides.get(0)+sides.get(1));
    }
}

class Square extends Shape{
    Square(){
        //it goes to the default constructor of the parent
    }
    Square(double side){
        super(side);
    }

    @Override
    public double calculateArea() {
        return sides.getFirst()*sides.getFirst();
    }

    @Override
    public double calculatePerimeter() {
        return 4*sides.getFirst();
    }
}
public class AbstractionExample {
    static Logger logger=Logger.getLogger(AbstractionExample.class);

    public static void main(String[] args){
        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Shape shape;
        //implementing runtime polymorphism by using the reference of abstract class and object of perticular type
        shape=new Rectangle();
        logger.info("Perimeter of rectangle is:"+shape.calculatePerimeter()+" and area is:"+shape.calculateArea());

        shape=new Square();
        logger.info("Perimeter of square is:"+shape.calculatePerimeter()+" and area is:"+shape.calculateArea());
    }
}

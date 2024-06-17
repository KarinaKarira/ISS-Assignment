package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class Person{
    private String name;
    private String address;
    private int age;

    Person(){
        name="XYZ";
        address="PQR";
        age=20;
    }
    Person(String name,String address,int age){
        this.name=name;
        this.address=address;
        this.age=age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class EncapsulationExample {
    static Logger logger=Logger.getLogger(EncapsulationExample.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Person person=new Person("Karina","Ulhasnagar",22);
        logger.info("Name of the person:"+person.getName()+" address is:"+person.getAddress()+" age is:"+person.getAge());

        Person person1=new Person();
        logger.info("Name of the person:"+person1.getName()+" address is:"+person1.getAddress()+" age is:"+person1.getAge());
    }
}

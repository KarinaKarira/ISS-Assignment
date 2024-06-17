/*First example to demonstrate te basics of Java such as Class,Object,State(instance variables) and Methods(behaviour)*/

package corejava;

import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;

class Student {

    //instance variables
    private String name;
    private int id;
    private int marks;

    //methods to the private variables
    public void setName(String name) {
        // if we are using the same name then using "this" keyword is important otherwise the instance variable will be hidden and will be overridden by the local varaible
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    //instance method
    public Student compareMarksAndReturnGreater(Student student){
        if (this.marks > student.marks)
            return this;
        else
            return student;
    }
}

class Basics {
    static Logger logger = Logger.getLogger(Basics.class);

    public static void main(String[] args) {

        String log4jConfigFile = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Student first = new Student();
        Student second = new Student();

//        since we have not initialised the values, the instance variables will be assigned default values
        logger.info("Name of the first student:" + first.getName() + " id:" + first.getId() + " marks:" + first.getMarks());
        logger.info("Name of the second student:" + second.getName() + " id:" + second.getId() + " marks:" + second.getMarks());

        first.setName("Karina");
        first.setId(11);
        first.setMarks(97);

        second.setName("Kashish");
        second.setId(12);
        second.setMarks(85);

        logger.info("Name of the first student:" + first.getName() + " id:" + first.getId() + " marks:" + first.getMarks());
        logger.info("Name of the second student:" + second.getName() + " id:" + second.getId() + " marks:" + second.getMarks());

        Student studentWithGreaterMarks=first.compareMarksAndReturnGreater(second);
        logger.info(studentWithGreaterMarks.getName()+" has greater marks.");

    }
}
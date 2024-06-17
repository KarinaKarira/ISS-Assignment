package collectionExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Student student) {
        if(this.id==student.id)   //if the ids are same compare the objects based on their names
            return this.name.compareTo(student.name);
        return Integer.compare(this.id,student.id);
    }
}

public class SortCustomObjectsComparable {

    static Logger logger= Logger.getLogger(SortCustomObjectsComparable.class);

    public static void main(String[] args){
        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Student student1=new Student(16,"Karina");
        Student student2=new Student(5,"Vishal");
        Student student3=new Student(20,"Diksha");
        Student student4=new Student(22,"Girish");
        Student student5=new Student(16,"Vanshita");

        List<Student> students=new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        logger.info("List of students:");
        for(Student student:students)
            logger.info(student.getId()+" "+student.getName());
        Collections.sort(students);

        logger.info("List of students after sorting using comparable interface according to their ids:");
        for(Student student:students)
            logger.info(student.getId()+" "+student.getName());

    }

}

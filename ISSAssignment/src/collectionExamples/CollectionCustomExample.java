//demonstrating sorting of custom objects
package collectionExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.*;


class Studentt{

    private int id;
    private String name;

    public Studentt(int id, String name) {
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

}
public class CollectionCustomExample {

    static Logger logger = Logger.getLogger(CollectionCustomExample.class);

    public static void main(String[] args) {

        String log4jConfigFile = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //collection of custom object
        List<Studentt> studentsList = new ArrayList<>();
        Studentt student1 = new Studentt(1, "Karina");
        Studentt student2 = new Studentt(2, "Diksha");
        Studentt student3 = new Studentt(3, "Sahil");
        Studentt student4 = new Studentt(4, "Vishal");
        Studentt student5 = new Studentt(5, "Gunjan");
        Studentt student6 = new Studentt(6, "Neeta");

        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);

        logger.info("List of students");
        for (Studentt student : studentsList) {
            logger.info(student.getId() + " " + student.getName());
        }

        //each time we call .next() the pointer moves and therefore we get a different output
        //to prevent the movement of pointer, we will save the value of .next() in a variable

        for(ListIterator<Studentt> it=studentsList.listIterator();it.hasNext();) {
            Studentt student=it.next(); //so that we have to do .next() only one time for a particular student
            logger.info(student.getId() + " " + student.getName());
        }

        //Set of students
        Set<Studentt> studentsSet = new HashSet<>();
        studentsSet.add(student1);
        studentsSet.add(student2);
        studentsSet.add(student3);
        studentsSet.add(student4);
        studentsSet.add(student5);

        logger.info("Set of students");
        for(Iterator<Studentt> setIt=studentsSet.iterator();setIt.hasNext();) {
            Studentt student=setIt.next(); //so that we have to do .next() only one time for a particular student
            logger.info(student.getId() + " " + student.getName());
        }

        Map<Studentt, Studentt> studentsMap = new HashMap<>();
        studentsMap.put(student1,student2);
        studentsMap.put(student3,student4);
        studentsMap.put(student5,student6);

        for(Map.Entry<Studentt,Studentt> entrySet:studentsMap.entrySet())
            logger.info("Student with id "+entrySet.getKey().getId()+" and name:"+entrySet.getKey().getName()+" is mapped to student with id:"+entrySet.getValue().getId()+" and name:"+entrySet.getValue().getName());


    }
}

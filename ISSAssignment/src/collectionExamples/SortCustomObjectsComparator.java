package collectionExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCustomObjectsComparator {

    static Logger logger= Logger.getLogger(SortCustomObjectsComparator.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        List<Studentt> studentsList = new ArrayList<>();
        Studentt student1 = new Studentt(16, "Karina");
        Studentt student2 = new Studentt(20, "Diksha");
        Studentt student3 = new Studentt(10, "Sahil");
        Studentt student4 = new Studentt(5, "Vishal");
        Studentt student5 = new Studentt(3, "Gunjan");
        Studentt student6 = new Studentt(3, "Neeta");

        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);
        studentsList.add(student6);

        logger.info("List of students:");
        for(Studentt student:studentsList)
            logger.info(student.getId()+" "+student.getName());

        //We can write the ONLY function in Functional interface without explicitly creating an object using anonymous classes
        Collections.sort(studentsList, new Comparator<Studentt>() {
            @Override
            public int compare(Studentt o1, Studentt o2) {
                if (o1.getId()==o2.getId())
                    return o1.getName().compareTo(o2.getName());
                return Integer.compare(o1.getId(),o2.getId());
            }
        });

        logger.info("Sorting students using comparator according to their ids:");
        for(Studentt student:studentsList)
            logger.info(student.getId()+" "+student.getName());

    }
}

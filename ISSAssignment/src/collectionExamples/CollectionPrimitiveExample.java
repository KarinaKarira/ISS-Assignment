package collectionExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.*;

public class CollectionPrimitiveExample {

    static Logger logger= Logger.getLogger(CollectionPrimitiveExample.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //Collection of Integers
        List<Integer> list=new ArrayList<>();

        list.add(5);
        list.add(7);
        list.add(3);
        list.add(9);
        list.add(9);

        logger.info("List of numbers:"+list);
        Collections.sort(list);
        logger.info("Sorted numbers:"+list);

        //using an iterator for printing the list
        logger.info("Iterating through an iterator");
        for(ListIterator<Integer> it=list.listIterator();it.hasNext();)
            logger.info(it.next());

        //Set
        Set<Integer> set=new HashSet<>();
        set.add(5);
        set.add(7);
        set.add(3);
        set.add(9);
        set.add(9);

        logger.info("Set of numbers:"+set);
        //we cannot sort the elements of a set

        logger.info("Iterating through an iterator");
        for(Iterator<Integer> setIt=set.iterator();setIt.hasNext();)
                logger.info(setIt.next());
        //Map
        Map<Integer,String> map=new HashMap<>();

        map.put(16,"Karina");
        map.put(20,"Diksha");
        map.put(17,"Vanshita");
        map.put(6,"Varsha");
        map.put(5,"Vishal");

        logger.info("Mapping of birthdays to the people is:"+map);

        //iterating through for loop
        logger.info("Iterating through an iterator");
        for(int key:map.keySet())
            logger.info(key+" "+map.get(key));
    }
}

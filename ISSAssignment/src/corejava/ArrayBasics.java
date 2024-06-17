//this example demonstrates Arrays and the operations we can perform with arrays
package corejava;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class ArrayBasics {
    static Logger logger= Logger.getLogger(ArrayBasics.class);
    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        int[] array={8,5,6,2,9,1,10};
        printArray(array);

        //we can sort an array using the in-built sort() function
        Arrays.sort(array);

       printArray(array);

//       List<Integer> listFromArray= new ArrayList(Arrays.asList(array));
//        Arrays.asList(array) doesn't work with primitive datatype like int[] if we pass a primitive datatype it returns a list with a single object,array itself.That is, the size of list is 1.

        Integer[] wrapperArray=new Integer[array.length];
        for(int looper=0;looper<array.length;looper++)
            wrapperArray[looper]=array[looper];

        //now we can convert array to a list using asList() function
        List<Integer> listFromArray=Arrays.asList(wrapperArray);
        logger.info(listFromArray);

        //Two-D array can be created as
        int rows=4,columns=4;
        int[][] twoDArray=new int[4][4];

        fillTwoDArray(twoDArray,rows,columns);
        printTwoDArray(twoDArray,rows,columns);
    }
    public static void printArray(int[] array){
        for(int looper=0;looper<array.length;looper++)
            logger.info(array[looper]);
    }
    public static void fillTwoDArray(int[][] twoDArray,int rows,int columns){
        int num=1;
        for(int rowPointer=0;rowPointer<rows;rowPointer++){
            for(int cellPointer=0;cellPointer<columns;cellPointer++){
                twoDArray[rowPointer][cellPointer]=num;
                num++;
            }
        }
    }
    public static void printTwoDArray(int[][] twoDArray,int rows,int columns){
        for(int rowPointer=0;rowPointer<rows;rowPointer++){
            for(int cellPointer=0;cellPointer<columns;cellPointer++){
                logger.info(twoDArray[rowPointer][cellPointer]);
            }
        }
    }
}

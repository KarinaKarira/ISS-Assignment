package corejava;

import database.CallableStatementExample;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.*;
import java.util.Scanner;


public class FileHandlingExample {

    static Logger logger = Logger.getLogger(CallableStatementExample.class);
    public static void main(String[] args){

        String log4jConfigFile = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        //creating a new file
        try {
            File file = new File("demoFile.txt");
            if (file.createNewFile()) {
                logger.info("File created: "+ file.getName());
            }
            else {
                logger.info("File already exists.");
            }
        }
        catch (IOException e) {
            logger.info("An error has occurred.");
            e.printStackTrace();
        }

        //write to a file
        try {
            FileWriter Writer= new FileWriter("demoFile.txt");
            Writer.write("Writing to the demo file created");
            Writer.close();
            logger.info("Successfully written.");
        }
        catch (IOException e) {
           logger.info("An error has occurred.");
            e.printStackTrace();
        }

        //reading from the file
        try {
            File file = new File("demoFile.txt");
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                logger.info(data);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            logger.info("An error has occurred.");
            e.printStackTrace();
        }

    }
}

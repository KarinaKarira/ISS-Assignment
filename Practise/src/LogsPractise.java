import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class LogsPractise {
    // Initialize logger
    static Logger logger = Logger.getLogger(LogsPractise.class);

    public static void main(String[] args) {

        String log4jConfigFile = "src/resources/log4.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        // Log messages of different levels
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");

        // Check logger levels for different packages
        Logger serviceLogger = Logger.getLogger("com.example.service");
        serviceLogger.debug("Service debug message");
        serviceLogger.info("Service info message");
        serviceLogger.warn("Service warn message");

        Logger daoLogger = Logger.getLogger("com.example.dao");
        daoLogger.debug("DAO debug message");
        daoLogger.info("DAO info message");
        daoLogger.warn("DAO warn message");
    }
}

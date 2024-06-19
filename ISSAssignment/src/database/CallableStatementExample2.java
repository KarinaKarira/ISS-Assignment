package database;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class CallableStatementExample2 {
    static Logger logger = Logger.getLogger(CallableStatementExample.class);

    public static void main(String[] args) {

        String log4jConfigFile = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        String url = "jdbc:sqlserver://localhost:1433;databaseName=project;encrypt=true;trustServerCertificate=true";
        String username = "Karina";
        String password = "HAPPY";

        try {
            //connecting the database

            //1.Loading the jdbc driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //2.establishing the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            logger.info("Connected to the database");

            String procedureCall = "{call company.sp_fetchEmployee(?)}";

            CallableStatement callableStatement = connection.prepareCall(procedureCall);

            callableStatement.setInt(1, 2); //will fetch the details of the employee with id=2

            //procedure returns the details which we can fetch as follows:
            boolean hasResultSet = callableStatement.execute();

            if (hasResultSet) {
                ResultSet rs = callableStatement.getResultSet();

                while (rs.next()) {
                    logger.info("Name of the employee:" + rs.getString("e_name"));
                    logger.info("Salary of the employee:" + rs.getFloat("salary"));
                    logger.info("Name of the department:" + rs.getString("d_name"));
                    logger.info("Name of the manager:" + rs.getString("m_name"));

                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

package database;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class CallableStatementExample {
    static Logger logger= Logger.getLogger(CallableStatementExample.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        String url = "jdbc:sqlserver://localhost:1433;databaseName=project;encrypt=true;trustServerCertificate=true";
        String username = "Karina";
        String password = "HAPPY";

        try {
            //connecting the database

            //1.Loading the jdbc driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //2.establishing the connection
            Connection connection = DriverManager.getConnection(url,username,password);

            logger.info("Connected to the database");

            String procedureCall="{call company.sp_addEmployee(?,?,?,?)}";

            CallableStatement callableStatement= connection.prepareCall(procedureCall);

            callableStatement.setString(1,"EmployeeAddedFromJava");
            callableStatement.setFloat(2,40000);
            callableStatement.setInt(3,3);
            callableStatement.setInt(4,3);

            callableStatement.execute();
            logger.info("Employee added to the table");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

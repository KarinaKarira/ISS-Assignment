package database;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;

public class PreparedStatementExample {

    static Logger logger= Logger.getLogger(PreparedStatementExample.class);
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

            String sqlQuery="SELECT * FROM company.employee WHERE e_id = ?";

            PreparedStatement pstmt= connection.prepareStatement(sqlQuery);

            pstmt.setInt(1,2); //sets e_id to 2

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                logger.info("Name of the employee:"+rs.getString("e_name"));
                logger.info("Salary:"+rs.getFloat("salary"));
                logger.info("Id of the department:"+rs.getInt("d_id"));
                logger.info("Id of the manager:"+rs.getInt("m_id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

package testcases;

import java.sql.*;

public class SqlConnectionSample {
    public static void main(String[] args) throws SQLException {

        String databaseName = "company";
        String host = "localhost";
        String port = "3306";
        String url = "jdbc:mysql://"+host+":"+port+"/"+databaseName;
        Connection connection = DriverManager.getConnection(url,"root","password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");

        while(resultSet.next()){
            System.out.println(resultSet.getString("first_name"));
            //System.out.println(resultSet.getString("last_name"));
        }



    }
}

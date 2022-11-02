package Start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection(){
        if(connection != null){
            throw new RuntimeException("Not allowed, use getInstance() method!");
        }
    }
    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "akej");
                System.out.println("Successfully connected to the database");
            }catch(SQLException e){
                System.out.println("Failed to create the database connection");
            }
        }else{
            System.out.println("You are already connected to the database!");
        }
        return connection;
    }

}

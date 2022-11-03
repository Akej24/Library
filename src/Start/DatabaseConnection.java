package Start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection(){
    }
    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "root", "akej");
                System.out.println("Successfully connected to the database");
            }catch(SQLException e){
                System.out.println("Failed to create the database connection");
            }
        }
        return connection;
    }

}

package Options;

import Start.DatabaseConnection;

import java.sql.*;

public class DatabaseOperations {
    private static final Connection databaseConnection = DatabaseConnection.getConnection();

    protected static String create(String title, String author, String releaseDate, int numberOfPages, int price) {
        try{
            Statement create = databaseConnection.createStatement();
            create.executeUpdate("INSERT INTO library(title, author, releaseDate, numberOfPages, price) " +
                    "VALUES('"+title+"', '"+author+"', '"+releaseDate+"', "+numberOfPages+", "+price+" );");
            return "Successfully created";
        }catch(SQLException e){
            return "Invalid query, try again!";
        }
    }

    protected  static String deleteById(int id) {
        try {
            Statement deleteById = databaseConnection.createStatement();
            deleteById.executeUpdate("DELETE FROM library WHERE id IN("+id+");");
            return "Successfully deleted";
        }catch(SQLException e){
            return "This ID does not exist!";
        }
    }

    protected  static String getAll() {
        try {
            Statement getAll = databaseConnection.createStatement();
            ResultSet resultSet = getAll.executeQuery("SELECT * FROM library;");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnsNumber = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
            return "Successfully printed";
        }catch(SQLException e){
            return "Something went wrong";
        }
    }

    protected static String editById(int numberOfParameter, int id, String changedData) {
        try{
            Statement editById = databaseConnection.createStatement();
            switch(numberOfParameter){
                case 1 -> editById.executeUpdate("UPDATE library SET title = '"+changedData+"' WHERE id = "+id+";");
                case 2 -> editById.executeUpdate("UPDATE library SET author = '"+changedData+"' WHERE id = "+id+";");
                case 3 -> editById.executeUpdate("UPDATE library SET releaseDate = '"+changedData+"' WHERE id = "+id+";");
                case 4 -> editById.executeUpdate("UPDATE library SET numberOfPages = '"+changedData+"' WHERE id = "+id+";");
                case 5 -> editById.executeUpdate("UPDATE library SET price = '"+changedData+"' WHERE id = "+id+";");
                case 6 -> editById.executeUpdate("UPDATE library SET status = '"+changedData+"' WHERE id = "+id+";");
                default -> System.out.println("Enter a valid number of element to be edited!");
            }
            return "Successfully edited";
        }catch(SQLException exception){
            return "Invalid id or data to change!";
        }
    }
}

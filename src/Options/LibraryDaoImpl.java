package Options;

import Start.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibraryDao {
    private static final Connection databaseConnection = DatabaseConnection.getConnection();

    @Override
    public boolean insertBook(Library book) {
        String sql = "insert into library (title, author, releaseDate, numberOfPages, price) values(?,?,?,?,?)";
        try {
            PreparedStatement insertBookStatement = databaseConnection.prepareStatement(sql);
            insertBookStatement.setString(1, book.getTitle());
            insertBookStatement.setString(2, book.getAuthor());
            insertBookStatement.setString(3, book.getReleaseDate());
            insertBookStatement.setInt(4, book.getNumberOfPages());
            insertBookStatement.setInt(5, book.getPrice());
            return insertBookStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        String sql = "delete from library where id=?";
        try {
            PreparedStatement deleteBookStatement = databaseConnection.prepareStatement(sql);
            deleteBookStatement.setInt(1, id);
            return deleteBookStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Library> getLibrary() {
        List<Library> libraryList = new ArrayList<>();
        try {
            String sql = "select * from library";
            PreparedStatement getLibraryStatement = databaseConnection.prepareStatement(sql);
            ResultSet resultSet = getLibraryStatement.executeQuery();
            while(resultSet.next()){
                libraryList.add(new Library(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getBoolean(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return libraryList;
    }

    @Override
    public Library getBook(int id){
        String sql = "select id, title, author, releaseDate, numberOfPages, price, status from library where id=?";
        try{
        PreparedStatement getBookStatement = databaseConnection.prepareStatement(sql);
        getBookStatement.setInt(1, id);
        ResultSet resultSet = getBookStatement.executeQuery();
            if(resultSet.next()) {
                return new Library(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getBoolean(7));
            }
        }catch(SQLException e){
                e.printStackTrace();
                //throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean updateBook(int numberOfParameter, int id, String changedData) {
        String sql;
        switch(numberOfParameter) {
            case 1 -> sql = "update library set title = ? where id = ?";
            case 2 -> sql = "update library set author = ? where id = ?";
            case 3 -> sql = "update library set releaseDate = ? where id = ?";
            case 4 -> sql = "update library set numberOfPages = ? where id = ?";
            case 5 -> sql = "update library set price = ? where id = ?";
            case 6 -> sql = "update library set status = ? where id = ?";
            default -> {
                System.out.println("Enter a valid number of element to be edited!");
                return false;
            }
        }
        try {
            PreparedStatement updateBookStatement = databaseConnection.prepareStatement(sql);
            updateBookStatement.setString(1, changedData);
            updateBookStatement.setInt(2, id);
            return updateBookStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return false;
    }
}

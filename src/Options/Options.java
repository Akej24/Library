package Options;

import Start.Input;
import java.util.List;

public class Options {

    private final LibraryDaoImpl libraryDaoImpl = new LibraryDaoImpl();

    public boolean insertBook(){
        System.out.println("Give the title: ");
        String title = Input.getInput();
        System.out.println("Give the author: ");
        String author = Input.getInput();
        System.out.println("Give the releaseDate (YYYY-MM-DD): ");
        String releaseDate = Input.getInput();
        System.out.println("Give the number of pages: ");
        try {
            int numberOfPages = Integer.parseInt(Input.getInput());
            System.out.println("Give the price: ");
            int price = Integer.parseInt(Input.getInput());
            return libraryDaoImpl.insertBook(new Library(title, author, releaseDate, numberOfPages, price));
        }catch(NumberFormatException e){
            return printInvalidInput("Invalid input!", e);
        }

    }
    public boolean updateBook(){
        try {
            System.out.println("Give the ID of the book to be edited: ");
            int id = Integer.parseInt(Input.getInput());
            System.out.println("""
                    Give the number of the element to be edited:
                    [1] Title
                    [2] Author
                    [3] ReleaseDate
                    [4] NumberOfPages
                    [5] Price
                    [6] Status""");
            int numberOfParameter = Integer.parseInt(Input.getInput());
            System.out.println("Replace this data with: ");
            String changedData = Input.getInput();
            return libraryDaoImpl.updateBook(numberOfParameter, id, changedData);
        }catch(NumberFormatException e){
            return printInvalidInput("Invalid input!", e);
        }
    }

    public boolean deleteBook(){
        System.out.println("Give the ID of the book to be deleted");
        try {
            int id = Integer.parseInt(Input.getInput());
            return libraryDaoImpl.deleteBook(id);
        }catch(NumberFormatException e){
            return printInvalidInput("Invalid input format!", e);
        }
    }

    public List<Library> getLibrary(){
        return libraryDaoImpl.getLibrary();
    }

    private static boolean printInvalidInput(String x, NumberFormatException e) {
        System.out.println(x);
        e.printStackTrace();
        return false;
    }
}

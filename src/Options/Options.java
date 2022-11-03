package Options;

import Start.Input;
import java.util.List;

public class Options {

    private final LibraryDaoImpl libraryDaoImpl = new LibraryDaoImpl();

    public boolean execute1(){
        System.out.println("Give the title: ");
        String title = Input.getInput();
        System.out.println("Give the author: ");
        String author = Input.getInput();
        System.out.println("Give the releaseDate (YYYY-MM-DD): ");
        String releaseDate = Input.getInput();
        System.out.println("Give the number of pages: ");
        int numberOfPages;
        int price;
        try {
            numberOfPages = Integer.parseInt(Input.getInput());
            System.out.println("Give the price: ");
            price = Integer.parseInt(Input.getInput());
        }catch(NumberFormatException e){
            System.out.println("Invalid input!");
            e.printStackTrace();
            return false;
        }

        return libraryDaoImpl.insertBook(new Library(title, author, releaseDate, numberOfPages, price));
    }
    public boolean execute2(){
        int id;
        int numberOfParameter;
        try {
            System.out.println("Give the ID of the book to be edited: ");
            id = Integer.parseInt(Input.getInput());
            System.out.println("""
                    Give the number of the element to be edited:
                    [1] Title
                    [2] Author
                    [3] ReleaseDate
                    [4] NumberOfPages
                    [5] Price
                    [6] Status""");
            numberOfParameter = Integer.parseInt(Input.getInput());
        }catch(NumberFormatException e){
            System.out.println("Invalid input!");
            e.printStackTrace();
            return false;
        }
        System.out.println("Replace this data with: ");
        String changedData = Input.getInput();

        return libraryDaoImpl.updateBook(numberOfParameter, id, changedData);
    }

    public boolean execute3(){
        System.out.println("Give the ID of the book to be deleted");
        int id;
        try {
            id = Integer.parseInt(Input.getInput());
        }catch(NumberFormatException e){
            System.out.println("Invalid input format!");
            e.printStackTrace();
            return false;
        }
        return libraryDaoImpl.deleteBook(id);
    }

    public List<Library> execute4(){
        return libraryDaoImpl.getLibrary();
    }
}

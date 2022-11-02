package Options;

import Start.Input;

public class Option1 {

    public static String execute(){

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
            return "Invalid input format!";
        }

        return DatabaseOperations.create(title, author, releaseDate, numberOfPages, price);

    }
}

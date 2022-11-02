import java.util.Scanner;

public class Option1 {

    public static String execute(Scanner scanner){

        System.out.println("Give the title: ");
        String title = scanner.nextLine();
        System.out.println("Give the author: ");
        String author = scanner.nextLine();
        System.out.println("Give the releaseDate (YYYY-MM-DD): ");
        String releaseDate = scanner.nextLine();
        System.out.println("Give the number of pages: ");
        int numberOfPages = 0;
        int price = 0;
        try {
            numberOfPages = Integer.parseInt(scanner.nextLine());
            System.out.println("Give the price: ");
            price = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            return "Invalid input format!";
        }

        return DatabaseOperations.create(title, author, releaseDate, numberOfPages, price);

    }
}

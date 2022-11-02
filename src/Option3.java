import java.util.Scanner;

public class Option3 {
    public static String execute(Scanner scanner){
        System.out.println("Give the ID of the book to be deleted");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Invalid input format!");
        }
        return DatabaseOperations.deleteById(id);
    }
}

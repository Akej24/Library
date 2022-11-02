import java.util.Scanner;

public class Option2 {
    public static String execute(Scanner scanner){
        int id = 0;
        int numberOfParameter = 0;
        try {
            System.out.println("Give the ID of the book to be edited: ");
            id = Integer.parseInt(scanner.nextLine());
            System.out.println("""
                    Give the number of the element to be edited:
                    [1] Title
                    [2] Author
                    [3] ReleaseDate
                    [4] NumberOfPages
                    [5] Price
                    [6] Status""");
            numberOfParameter = Integer.parseInt(scanner.next());
        }catch(NumberFormatException e){
            System.out.println("Invalid input format!");
        }
        System.out.println("Replace this data with: ");
        String changedData = scanner.nextLine();

        return DatabaseOperations.editById(numberOfParameter, id, changedData);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isProgramWorking = true;
        while(isProgramWorking){
            System.out.println("""
                -------------------------------------
                Welcome to Library, select an action:
                [1] Add a book
                [2] Edit a book
                [3] Delete a book
                [4] Show books database
                [5] Exit the program
                -------------------------------------""");
            String choice = scanner.nextLine();
            switch(choice){
                case "1" -> System.out.println(Option1.execute(scanner));
                case "2" -> System.out.println(Option2.execute(scanner));
                case "3" -> System.out.println(Option3.execute(scanner));
                case "4" -> System.out.println(Option4.execute());
                case "5" -> isProgramWorking = false;
                default -> System.out.println("Invalid input, try again");
            }
        }
    }
}
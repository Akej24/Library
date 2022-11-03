package Start;

import Options.Options;

public class MainProgram {
    public static void main(String[] args) {
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
            String choice = Input.getInput();
            Options options = new Options();
            switch(choice){
                case "1" -> printMessage(options.execute1());
                case "2" -> printMessage(options.execute2());
                case "3" -> printMessage(options.execute3());
                case "4" -> System.out.println(options.execute4());
                case "5" -> isProgramWorking = false;
                default -> System.out.println("Invalid input, try again");
            }
        }
    }
    public static void printMessage(boolean status){
        if (status) {
            System.out.println("Successfully");
        } else {
            System.out.println("Not successfully");
        }
    }
}
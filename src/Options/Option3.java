package Options;

import Start.Input;

public class Option3 {
    public static String execute(){
        System.out.println("Give the ID of the book to be deleted");
        int id = 0;
        try {
            id = Integer.parseInt(Input.getInput());
        }catch(NumberFormatException e){
            System.out.println("Invalid input format!");
        }
        return DatabaseOperations.deleteById(id);
    }
}

package Options;

import Start.Input;

public class Option2 {
    public static String execute(){
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
            return "Invalid input format!";
        }
        System.out.println("Replace this data with: ");
        String changedData = Input.getInput();

        return DatabaseOperations.editById(numberOfParameter, id, changedData);
    }
}

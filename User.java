package RockPaperScissors;

import java.util.Scanner;

public class User {
    /**
     * Asks the user to select an object, and repeats until the user has entered a valid option:
     * "r", "s", "p".
     * @return a String that represents which object the user chose ("r" for rock, "s" for scissors,
     * "p" for paper)
     */
    public static String takeTurn() {
        Scanner input = new Scanner(System.in);

        //get input
        System.out.println("Enter your object (rock: 'r', paper: 'p', scissors: 's') after...");
        System.out.print("ROCK...PAPER...SCISSORS...SHOOT...    ");
        String object = input.nextLine();
        //convert to lower case
        object = object.toLowerCase();

        //check if input is valid
        if(object.equals("r") || object.equals("s") || object.equals("p")) {
            return object; //if it is valid return it
        }else { //if it is not valid run takeTurn() until it is
            System.out.println("\nThat input is not valid. Please enter 's', 'r', or 'p'.\n");
            return takeTurn();
        }
    }
}

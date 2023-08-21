package RockPaperScissors;

import java.util.Scanner;

public class MethodsForMain {
    static Scanner input = new Scanner(System.in);

    /**
     * Asks the user for an int (1, 3, 5, 7, 9) that represents how many matches the user(s) want
     * to play. Checks whether the input is an int and if it is one of those ints specifically.
     * @return an int that represents how many matches the user(s) want to play
     */
    public static int howManyMatches() {
        int matches = 0;
        try {
            System.out.print("# of Matches (1, 3, 5, 7, 9): ");
            matches = input.nextInt();

        } catch (Exception e) {
            return howManyMatches();
        }

        switch (matches) {
            case 1 : return 1;
            case 3 : return 3;
            case 5 : return 5;
            case 7 : return 7;
            case 9 : return 9;
            default : {
                System.out.println("That is not an option. Please enter another number.");
                return howManyMatches();
            }
        }
    }

    /**
     * Asks the user(s) for a mode: either solo ("s"), two player ("t"), or to end the game ("stop").
     * @return a String (either "s" or "t" or "stop")
     */
    public static String askForMode() {
        String mode;

        System.out.print("\nMode ('S' or 'T' or 'STOP'): ");
        mode = input.next();

        //is the player done?
        if(mode.equalsIgnoreCase("STOP")) {
            return "STOP";
        }

        //is the mode an option?
        if(!mode.equalsIgnoreCase("S") && !mode.equalsIgnoreCase("T")) {
            System.out.println("\nThis is not an option. Please enter: 'S' or 'T' or 'STOP'.");
            return askForMode();
        }

        return mode;
    }
}

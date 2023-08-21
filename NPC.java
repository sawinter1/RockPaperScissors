package RockPaperScissors.Solo;

import java.lang.Math.*;

public class NPC {
    /**
     * Generates a random number between 1 and 9 and then selects an object for the npc to play.
     * 1-3: rock, 4-6: paper, 7-9: scissors
     * @return a String that represents the object the npc chose: "r" for rock, "p" for paper,
     * "s" for scissors
     */
    public static String takeTurn() {
        //generate a random number 1-9
        int number = (int) (Math.random() * 9) + 1;

        switch (number) {
            case 1 : ;
            case 2 : ;
            case 3 : return "r";

            case 4 : ;
            case 5 : ;
            case 6 : return "p";

            case 7 : ;
            case 8 : ;
            case 9 : return "s";
        }

        //the method will not get to this return statement
        return "";
    }
}

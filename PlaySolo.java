package RockPaperScissors.Solo;

import RockPaperScissors.User;
import static RockPaperScissors.HierarchyChecker.*;
public class PlaySolo {
    /**
     * Runs one game in solo mode. Runs the number of matches between a user and a npc that the
     * user picked (or until one player has the majority).
     * @param numOfMatches the number of matches desired (1, 3, 5, 7, 9) or play until one player
     *                     cannot win because the other has the majority
     * @return a boolean that represents whether the user won or lost (true if user won, false if
     * npc won)
     */
    public static boolean go(int numOfMatches) {
        int userScore = 0;
        int NPCScore = 0;

        /* Format (in switch):
         * -for the number of matches: run match, if the user wins add a point to their score if
         * the npc wins add a point to their score.
         * -display scores
         * -check if one of the scores is a majority/must win (if it is break)
         */

        switch (numOfMatches) {
            case 1:
                if (match()) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                for (int i = 0; i < 3; i++) {
                    if (match()) {
                        userScore++;
                    } else {
                        NPCScore++;
                    }
                    System.out.println("\nYour Score: " + userScore + "\nComputer Score: " + NPCScore + "\n");
                    if (userScore >= 2 || NPCScore >= 2) break;
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    if (match()) {
                        userScore++;
                    } else {
                        NPCScore++;
                    }
                    System.out.println("\nYour Score: " + userScore + "\nComputer Score: " + NPCScore + "\n");
                    if (userScore >= 3 || NPCScore >= 3) break;
                }
                break;
            case 7:
                for (int i = 0; i < 7; i++) {
                    if (match()) {
                        userScore++;
                    } else {
                        NPCScore++;
                    }
                    System.out.println("\nYour Score: " + userScore + "\nComputer Score: " + NPCScore + "\n");
                    if (userScore >= 4 || NPCScore >= 4) break;
                }
                break;
            case 9:
                for (int i = 0; i < 9; i++) {
                    if (match()) {
                        userScore++;
                    } else {
                        NPCScore++;
                    }
                    System.out.println("\nYour Score: " + userScore + "\nComputer Score: " + NPCScore + "\n");
                    if (userScore >= 5 || NPCScore >= 5) break;
                }
        }

        //return winner: true = user won, false = npc won
        return userScore > NPCScore;
    }

    /**
     * Runs one match in solo mode. Asks user for an object and generates an object for the
     * npc, then decides who won the match and returns a boolean.
     * @return a boolean that represents whether the user won or lost (true if user won, false
     * if npc won)
     */
    public static boolean match() {
        String userObject = "";
        String nPCObject = "";
        String nPCFullName = "";

        //have user and npc take turns until they do not have the same object
        while (true) {
            userObject = User.takeTurn();
            nPCObject = NPC.takeTurn();

            //decide name of npc's object
            switch (nPCObject) {
                case "r": {
                    nPCFullName = "rock";
                    break; }
                case "p": {
                    nPCFullName = "paper";
                    break;
                }
                case "s": {
                    nPCFullName = "scissors";
                    break;
                }
            }

            //display the npc's object
            System.out.println("The computer chose " + nPCFullName + ".");

            //if they are not the same: break
            if (!userObject.equals(nPCObject)) {
                break;
            }

            //if they are the same (did not break, print a message explaining and then loop)
            System.out.println("The computer chose the same object as you. Please redo.\n");
        }

        //check who won the match
        return whoWon(userObject, nPCObject);
    }
}

package RockPaperScissors.TwoPlayers;

import RockPaperScissors.User;
import static RockPaperScissors.ClearConsole.*;
import static RockPaperScissors.HierarchyChecker.whoWon;

public class PlayTwoPlayers {
    /**
     * Runs one game in two player mode. Runs the number of matches between two users that the
     * users picked (or until one player has the majority).
     * @param numOfMatches the number of matches desired (1, 3, 5, 7, 9) or play until one player
     *                     cannot win because the other has the majority
     * @return a boolean that represents whether the user won or lost (true if userOne won, false if
     * userTwo won)
     */
    public static boolean go(int numOfMatches) {
        int user1Score = 0;
        int user2Score = 0;

        //instructions to players
        System.out.println("Player 1 please look at the screen.");
        System.out.println("Player 2 please look away.\n");

        /* Format (in switch):
         * -for the number of matches: run match, if user1 wins add a point to their score if
         * user2 wins add a point to their score.
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
                        user1Score++;
                    } else {
                        user2Score++;
                    }
                    System.out.println("\nPlayer 1 Score: " + user1Score + "\nPlayer 2 Score: " + user2Score + "\n");
                    if (user1Score >= 2 || user2Score >= 2) break;
                }
                break;
            case 5:
                for (int i = 0; i < 5; i++) {
                    if (match()) {
                        user1Score++;
                    } else {
                        user2Score++;
                    }
                    System.out.println("\nPlayer 1 Score: " + user1Score + "\nPlayer 2 Score: " + user2Score + "\n");
                    if (user1Score >= 3 || user2Score >= 3) break;
                }
                break;
            case 7:
                for (int i = 0; i < 7; i++) {
                    if (match()) {
                        user1Score++;
                    } else {
                        user2Score++;
                    }
                    System.out.println("\nPlayer 1 Score: " + user1Score + "\nPlayer 2 Score: " + user2Score + "\n");
                    if (user1Score >= 4 || user2Score >= 4) break;
                }
                break;
            case 9:
                for (int i = 0; i < 9; i++) {
                    if (match()) {
                        user1Score++;
                    } else {
                        user2Score++;
                    }
                    System.out.println("\nPlayer 1 Score: " + user1Score + "\nPlayer 2 Score: " + user2Score + "\n");
                    if (user1Score >= 5 || user2Score >= 5) break;
                }
        }

        //return winner: true = user won, false = npc won
        return user1Score > user2Score;
    }

    /**
     * Runs one match in two player mode. Asks user1 for an object and asks user2 for an object,
     * then decides who won the match and returns a boolean.
     * @return a boolean that represents whether user1 won or lost (true if user1 won, false
     * if user2 won)
     */
    public static boolean match() {
        String user1Object = "";
        String user2Object = "";
        String user1FullName = "";
        String user2FullName = "";

        //have user and npc take turns until they do not have the same object
        while (true) {
            //get the objects
            user1Object = User.takeTurn();
            System.out.println("Thank you Player 1.");
            //blank screen so that user 2 can't see user 1's
            clearConsole();

            //inform user2 to play
            System.out.println("Player 2: please look at the screen, Player 1 look away.");
            user2Object = User.takeTurn();
            //blank screen again
            clearConsole();

            //decide name of user one's object
            user1FullName = nameObject(user1Object);

            //decide name of user two's object
            user2FullName = nameObject(user2Object);

            //display the user's objects
            System.out.println("ROCK... PAPER... SCISSORS... SHOOT!");
            System.out.println("User 1's " + user1FullName + " vs. User 2's " + user2FullName + ".");

            //if they are not the same: break
            if (!user1Object.equals(user2Object)) {
                break;
            }

            //if they are the same (did not break, print a message explaining and then loop)
            System.out.println("Both players chose the same object. Please redo.\n");
        }

        //check who won the match
        return whoWon(user1Object, user2Object);
    }

    /**
     * Returns the name of the object a user selected when the first letter was entered:
     * ("r" --> "rock", "p" --> "paper", "s" --> "scissors").
     * @param object a String that represents which object the user selected ("r", "p", "s")
     * @return a String that is the name of the object the user selected
     */
    public static String nameObject(String object) {
        switch (object) {
            case "r": return "rock";
            case "p": return "paper";
            case "s": return "scissors";
        }

        //this return statement will not be reached
        return "";
    }
}
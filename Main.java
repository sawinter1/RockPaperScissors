package RockPaperScissors;

import static RockPaperScissors.MethodsForMain.*;
import RockPaperScissors.Solo.PlaySolo;
import RockPaperScissors.TwoPlayers.PlayTwoPlayers;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //opening
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("To play:" +
                "\n- Enter 'S' for solo mode (single player) or 'T' for two player mode." +
                "\n- Enter:" +
                "\n     1 --> 1 of 1 matches wins" +
                "\n     3 --> 2 of 3 matches wins" +
                "\n     5 --> 3 of 5 matches wins" +
                "\n     7 --> 4 of 7 matches wins" +
                "\n     9 --> 5 of 9 matches wins" +
                "\n- In each match:" +
                "\n     1) Enter either 'R' (rock), 'P' (paper), or 'S' (scissors);" +
                "\n     2) Whichever players object is higher in the hierarchy wins." +
                "\n     Rock > Scissors" +
                "\n     Scissors > Paper" +
                "\n     Paper > Rock" +
                "\n- Once one player has won you can either play with the same number of players" +
                " and matches or you can restart the settings." +
                "\n- To exit the game: enter 'STOP' when asked the mode you would like.");

        //continue until the user inputs "STOP"
        while(true) {
            boolean stop = go();
            if(stop) {
                break;
            }
        }

        //closing
        System.out.println("Thank you for playing.");
    }

    /**
     * One (Solo) or two (TwoPlayers) Rock, Paper, Scissors.
     * <p>If solo is selected:
     * <p>The user plays against a randomly generated rock, paper, or scissors for as many times
     * as they had selected when starting.
     * <p>Once the user has either won or lost, they can choose to play again with the same settings:
     * Solo, number of matches, etc., or they can choose to return to the start and be able to select
     * Solo or Two Players, and then number of games again.
     *<p><p>If two player mode is selected:
     * <p> The second player is instructed to look away from the screen as player 1 selects their
     * object. The program will then print blank lines until the input is not visible and then instruct
     * the second player to enter their object. The program will then inform the players of the winner
     * of that match, and repeat the steps until all matches have been played.
     * <p>Once one player has either won or lost, they can choose to play again with the same settings:
     * or they can choose to return to the start and be able to select Solo or Two Players, and then
     * the number of matches again.
     *
     * @return isDone a boolean: if false the game will end
     */
    public static boolean go() {
        Scanner input = new Scanner(System.in);
        int numOfMatches;
        String mode;

        //get mode/check if player is done/ is the mode an option?
        mode = askForMode();
        //if the mode = "STOP" end game
        if(mode.equals("STOP")) {
            return true;
        }

        //get number of matches desired
        numOfMatches = howManyMatches();

        //send to the mode until the user wants different settings
        do{
            if(mode.equalsIgnoreCase("S")) { //if solo mode
                boolean userWon = PlaySolo.go(numOfMatches);

                //congratulate/commiserate
                if(userWon) {
                    System.out.println("\nCongratulations! You won!\n");
                }else {
                    System.out.println("\nUnfortunately you did not win. Good try, and better luck next time.\n");
                }

            }else if(mode.equalsIgnoreCase("T")) { //if 2 player mode
                boolean player1Won = PlayTwoPlayers.go(numOfMatches);

                //congratulate/commiserate
                if(player1Won) {
                    System.out.println("\nCongratulations player 1! You won!");
                    System.out.println("Our apologies to player 2. Better luck next time!\n");
                }else {
                    System.out.println("\nCongratulations player 2! You won!");
                    System.out.println("Our apologies to player 1. Better luck next time!\n");
                }
            }

            //check if the user still wants the same settings
            System.out.println("\nWould you like to play with the same settings? (if not enter 'n', otherwise enter any letter):");
            if(input.next().equalsIgnoreCase("n")) {
                break;
            }
            System.out.println(); //add a line
        }while(true);

        //if the player(s) have gone all the way through they did not say stop but they want to change the settings
        return false;
    }
}
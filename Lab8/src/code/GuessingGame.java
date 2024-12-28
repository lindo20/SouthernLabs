import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The GuessingGame class that the computer will randomly pick a number from 1 to 10, then ask the user to guess it.
 * The user will input a number and your program will say either “Correct” or “Incorrect; guess again”.
 * The user will guess again and the computer will keep track of the number of attempts.
 * Example:
 * The computer picked 6.
 * The user guesses 5. The computer says “Incorrect; guess again”. If the user guesses 5 again,
 * the computer will NOT count that guess and instead will say “You already guessed 5; guess again”.
 * Eventually, when the user guesses correctly, the computer will show the score such as “It took you 3 guesses. Play again?”
 * The user can say yes or no. If the user says no, the computer gives their overall score such as
 * “It took you 3 guesses to guess 1 number. Bye.” If the user says yes,
 * the computer randomly picks a new number and things repeat.
 * The computer will keep track each round to NOT COUNT when the user guesses the same number
 * (e.g. if the user guessed 1, then 7, then 7, then 8, then 7, then 1…that’s just 3 guesses: 1, 7, 8).
 * When the user quits the game, their OVERALL score must be printed from all rounds; e.g.
 * “It took you 46 guesses to guess 6 numbers. Bye.”
 * If the user guesses a number out of bounds (e.g. less than 1; more than 10), it is NOT counted as a guess.
 *
 * @author Cebisile Masombuka
 * @author Rethabile Sitole
 * @author Lindokuhle Dubazane
 * @version 1.0
 */
class GuessingGame
{
    /**
     * The minimum valid guess number (inclusive) in the game.
     */
    private static final int MIN_GUESS = 2;

    /**
     * The maximum valid guess number (inclusive) in the game.
     */
    private static final int MAX_GUESS = 10;

    /**
     * The main method that handles the game logic. It interacts with the user, generates random numbers,
     * and keeps track of the guesses and the rounds.
     * The user can continue guessing until they guess correctly or choose to quit.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(final String[] args)
    {
        final Scanner s;
        final Random r;

        final List<Integer> previousGuesses;
        previousGuesses = new ArrayList<>(); // Keeps track of previous guesses to avoid duplicates

        String input; // User input for the game
        int guessedNumber; // User's guessed number
        int targetNumber; // The randomly generated number that the user has to guess
        int guessCount; // Number of guesses taken in the current round
        int overallGuessCount = 0; // Total guesses taken across all rounds
        int correctRounds = 0; // Total rounds in which the user guessed correctly

        s = new Scanner(System.in); // Scanner to read user input
        r = new Random(); // Random object to generate the target number

        // Main game loop
        while(true)
        {
            guessCount = 0; // Reset guess count for each round
            targetNumber = r.nextInt(MIN_GUESS, MAX_GUESS + 1); // Generate a random target number between MIN_GUESS and MAX_GUESS

            System.out.println("Type a number between 1 and 10 OR Q to quit: "); // Prompt the user for a guess

            // Loop for user input and guesses
            while(true)
            {
                if(s.hasNext()) // Check if the user has entered any input
                {
                    // If the user enters an integer, process the guess
                    if(s.hasNextInt())
                    {
                        guessedNumber = s.nextInt(); // Get the guessed number
                        s.nextLine(); // Consume the newline character

                        // Validate if the guessed number is within the valid range
                        if(guessedNumber < MIN_GUESS || guessedNumber > MAX_GUESS)
                        {
                            System.out.printf("Please guess a number between %d and %d\n", MIN_GUESS, MAX_GUESS);
                            continue; // If out of range, ask the user to guess again
                        }

                        guessCount++; // Increment guess count

                        // If the guessed number was already guessed, ask the user to try again
                        if(previousGuesses.contains(guessedNumber))
                        {
                            System.out.printf("You already guessed %d, guess again.\n", guessedNumber);
                        }
                        else
                        {
                            // Add the new valid guess to the list of previous guesses
                            previousGuesses.add(guessedNumber);

                            // Check if the guess is correct
                            if(guessedNumber == targetNumber)
                            {
                                // If correct, display a success message and the result of the round
                                System.out.printf("Correct! You picked %d and the computer picked %d.\n",
                                        guessedNumber, targetNumber);

                                System.out.printf("It took you %d guesses to guess %d number.\n",
                                        guessCount, previousGuesses.size());

                                // Update the overall guess count and correct rounds
                                overallGuessCount += guessCount;
                                correctRounds++;

                                // Ask if the user wants to play again
                                System.out.print("Play again? (Yes/No): ");
                                input = s.nextLine();

                                // If the user chooses to play again, break out of the inner loop
                                if(input.equalsIgnoreCase("Yes"))
                                {
                                    break;
                                }
                                else
                                {
                                    // If the user chooses to quit, display their overall score and exit the game
                                    System.out.printf("It took you %d guesses to guess %d numbers. Bye\n",
                                            overallGuessCount, correctRounds);
                                    return; // Exit the game
                                }
                            }
                            else
                            {
                                // If the guess was incorrect, prompt the user to guess again
                                System.out.println("Incorrect; guess again");
                            }
                        }
                    }
                    else
                    {
                        // If the user entered something that is not an integer, check if it's 'Q' to quit
                        input = s.nextLine();

                        if(input.equalsIgnoreCase("Q"))
                        {
                            // If the user typed 'Q', display the overall score and quit the game
                            System.out.printf("It took you %d guesses to guess %d numbers. Bye.\n",
                                    overallGuessCount, correctRounds);
                            break; // Exit the game loop
                        }
                        else
                        {
                            // If the input is not a valid number or 'Q', prompt the user to enter numbers only
                            System.out.println("Error!!!, Enter Numbers only " + input);
                        }
                    }
                }
            }
        }
    }
}

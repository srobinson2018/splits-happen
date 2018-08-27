package com.scott.robinson.varen;

import java.util.Arrays;

/**
 * This class is Scott Robinson's solution to Varen Technologies'
 *
 * @see <a href="https://github.com/VarenTech/splits-happen">splits-happens</a>
 *
 * <p>This application accepts any number of formatted {@link String} which represent the individual rolls scores for a
 * bowling match and returns the scores for each frame as well as the final match score. If no input is provided, the
 * application will default to using test cases.
 */
public final class Main {

    /**
     * The entry point of the application. This method will accept an array of formatted {@link String} and print to
     * stdout the frame and total score of the bowling match.
     *
     * @param args array of formatted {@link String} representing a full bowling match of roll scored
     */
    public static void main(String[] args) {
        // Get the match scores
        final String[] matchScores;
        if (args == null || args.length == 0) {
            // Notify that invalid data was provided and return
            System.out.println("Invalid match data provided.");
            return;
        } else {
            // Use the provided input
            matchScores = args;
        }

        // Calculate the score of each provided String of rolls
        Arrays.stream(matchScores).forEach(matchScore -> {
            // Calculate the final score
            final int finalScore = BowlingScorer.scoreBowlingMatch(matchScore);

            // Print the final score
            System.out.println("Match [" + matchScore + "] earned final score: " + finalScore);
            System.out.println(); // This is here for prettier printing and would not exist in production code
        });
    }
}

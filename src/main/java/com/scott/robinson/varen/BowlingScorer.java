package com.scott.robinson.varen;

/**
 * Contains the logic necessary to score a bowling match. Used by {@link Main} to print out bowling scores.
 */
final class BowlingScorer {

    /**
     * This method accepts a {@link String} representing the individual roll scores of a bowling match and outputs the
     * total score.
     *
     * @param match {@link String} representing the individual roll scores of a bowling match
     * @return the total match score
     */
    static int scoreBowlingMatch(final String match) {

        // Convert the String of scores into a char array
        final char[] rolls = match.toCharArray();

        /*
         * Validate that the char array is of a possible length. A valid char array contains at least 11 characters and
         * no more than 21 characters.
         *
         * <p>NOTE: Validation of number of rolls is "out-of-scope" according to the project description.
         */
        if (rolls.length < 11 || rolls.length > 21) {
            throw new IllegalArgumentException("Invalid number of rolls provided! A bowling match can only have" +
                    "between 12 and 21 rolls.");
        }

        // Track the total score as the game progresses
        int totalScore = 0;

        // Track the frame
        int frame = 1;

        // Keep track of the roll count within each frame
        Roll roll = Roll.FIRST;

        // Calculate the final score by iterating through each roll
        for (int i = 0; i < rolls.length && frame <= 10; i++) {

            // Calculate the score value of a specific roll
            final int rollScore;
            switch (rolls[i]) {
                case STRIKE:
                    final int firstRollAfterStrike = rollScoreToInt(rolls[i + 1], rolls[i]);
                    final int secondRollAfterStrike = rollScoreToInt(rolls[i + 2], rolls[i + 1]);
                    rollScore = 10 + firstRollAfterStrike + secondRollAfterStrike;
                    break;
                case SPARE:
                    final int pinsEarnedThisRoll = 10 - Character.getNumericValue(rolls[i - 1]);
                    final int firstRollAfterSpare = rollScoreToInt(rolls[i + 1], rolls[i]);
                    rollScore = pinsEarnedThisRoll + firstRollAfterSpare;
                    break;
                case MISS:
                    rollScore = 0;
                    break;
                default:
                    rollScore = Character.getNumericValue(rolls[i]);
                    break;
            }

            // Add the roll score to the total score
            totalScore += rollScore;

            // Track frames
            if (roll == Roll.FIRST && rolls[i] != STRIKE) {
                // The roll processed was the first roll, so the next roll will be the second roll
                roll = Roll.SECOND;
            } else {
                /*
                 * The roll processed was either the second roll or a strike. So the frame is over and we want to
                 * continue in a new frame. To do so, we increment the frame count and reset 'firstRole' to true.
                 *
                 * <p>NOTE: Printing out intermediate frames is "out-of-scope" according to the project description
                 * but with my solution it was readily available so I print it out here.
                 */
                System.out.println("[" + frame + "] Frame score: " + totalScore);
                frame++;
                roll = Roll.FIRST;
            }
        }

        // Return the total score now that all frames have been processed
        return totalScore;
    }

    /**
     * Method used to convert a roll score char to an int.
     *
     * <p>{@link #STRIKE} is defined as 10
     * <p>{@link #SPARE} is defined as the difference between 10 and the previous roll score
     * <p>{@link #MISS} is defined as 0
     * <p>All other chars are converted to an int via the {@link Character#getNumericValue(char)} method
     *
     * @param current  the current roll score
     * @param previous the previous roll score
     * @return An int representing the provided roll score char
     */
    private static int rollScoreToInt(final char current, final char previous) {
        switch (current) {
            case STRIKE:
                return 10;
            case SPARE:
                return 10 - Character.getNumericValue(previous);
            case MISS:
                return 0;
            default:
                return Character.getNumericValue(current);
        }
    }

    private static final char STRIKE = 'X';
    private static final char SPARE = '/';
    private static final char MISS = '-';
}

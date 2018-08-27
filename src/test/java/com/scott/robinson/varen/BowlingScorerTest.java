package com.scott.robinson.varen;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests to ensure the functionality of the {@link BowlingScorer}
 */
final class BowlingScorerTest {

    /**
     * A {@link Collection} of {@link Tuple} defining the payload and expected resulting score.
     */
    private static final Collection<Tuple<String, Integer>> gameScores = Arrays.asList(
            new Tuple<>("XXXXXXXXXXXX", 300),
            new Tuple<>("9-9-9-9-9-9-9-9-9-9-", 90),
            new Tuple<>("5/5/5/5/5/5/5/5/5/5/5", 150),
            new Tuple<>("X7/9-X-88/-6XXX81", 167),
            new Tuple<>("--------------------", 0),
            new Tuple<>("------------------X--", 10)
    );

    /**
     * Test validating {@link #gameScores} with {@link BowlingScorer#scoreBowlingMatch(String)}
     */
    @Test
    void scoreBowlingMatch_validScores() {
        gameScores.forEach(gameScore ->
                assertEquals(BowlingScorer.scoreBowlingMatch(gameScore.getFirst()), gameScore.getSecond().intValue()));
    }
}
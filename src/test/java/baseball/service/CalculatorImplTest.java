package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.domain.Scores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.domain.Score.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CalculatorImpl 테스트")
class CalculatorImplTest {

    Balls computerBalls;
    Balls playerBalls;
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorImpl();
        computerBalls = Balls.valueOf(new ArrayList(Arrays.asList(5, 3, 9)));
    }

    @Test
    public void nothing() {
        // given
        playerBalls = Balls.valueOf(new ArrayList(Arrays.asList(1, 8, 4)));

        // when
        Scores scores = calculator.getScores(computerBalls, playerBalls);

        // then
        assertThat(scores.getStrike()).isEqualTo(0);
        assertThat(scores.getBall()).isEqualTo(0);
    }

    @Test
    public void oneBall() {
        // given
        playerBalls = Balls.valueOf(new ArrayList(Arrays.asList(1, 5, 8)));

        // when
        Scores scores = calculator.getScores(computerBalls, playerBalls);

        // then
        assertThat(scores.getBall()).isEqualTo(1);
    }

    @Test
    public void oneStrike() {
        // given
        playerBalls = Balls.valueOf(new ArrayList(Arrays.asList(5, 4, 7)));

        // when
        Scores scores = calculator.getScores(computerBalls, playerBalls);

        // then
        assertThat(scores.getStrike()).isEqualTo(1);
    }

    @Test
    public void mixed() {
        // given
        playerBalls = Balls.valueOf(new ArrayList(Arrays.asList(9, 3, 5)));

        // when
        Scores scores = calculator.getScores(computerBalls, playerBalls);

        // then
        assertThat(scores.getStrike()).isEqualTo(1);
        assertThat(scores.getBall()).isEqualTo(2);
    }
}
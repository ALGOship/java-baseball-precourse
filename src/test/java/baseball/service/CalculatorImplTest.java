package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Score;
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
        List<Score> scores = calculator.getScores(computerBalls, playerBalls);

        // then
        long strike = scores.stream().filter(score -> score == STRIKE).count();
        long ball = scores.stream().filter(score -> score == BALL).count();
        long nothing = scores.stream().filter(score -> score == NOTHING).count();
        assertThat(strike).isEqualTo(0);
        assertThat(ball).isEqualTo(0);
        assertThat(nothing).isEqualTo(3);
    }

    @Test
    public void oneBall() {
        // given
        playerBalls = Balls.valueOf(new ArrayList(Arrays.asList(1, 5, 8)));

        // when
        List<Score> scores = calculator.getScores(computerBalls, playerBalls);

        // then
        long ball = scores.stream().filter(score -> score == BALL).count();
        assertThat(ball).isEqualTo(1);
    }

    @Test
    public void oneStrike() {
        // given
        playerBalls = Balls.valueOf(new ArrayList(Arrays.asList(5, 4, 7)));

        // when
        List<Score> scores = calculator.getScores(computerBalls, playerBalls);

        // then
        long strike = scores.stream().filter(score -> score == STRIKE).count();
        assertThat(strike).isEqualTo(1);
    }

    @Test
    public void mixed() {
        // given
        playerBalls = Balls.valueOf(new ArrayList(Arrays.asList(9, 3, 5)));

        // when
        List<Score> scores = calculator.getScores(computerBalls, playerBalls);

        // then
        long strike = scores.stream().filter(score -> score == STRIKE).count();
        long ball = scores.stream().filter(score -> score == BALL).count();
        long nothing = scores.stream().filter(score -> score == NOTHING).count();
        assertThat(strike).isEqualTo(1);
        assertThat(ball).isEqualTo(2);
        assertThat(nothing).isEqualTo(0);
    }
}
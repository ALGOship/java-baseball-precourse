package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.domain.Scores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static baseball.constant.GameRule.MAX_BALL_POS;
import static baseball.constant.GameRule.MIN_BALL_POS;
import static baseball.domain.Score.*;

public class CalculatorImpl implements Calculator {

    @Override
    public Scores getScores(Balls computerBalls, Balls playerBalls) {
        List<Score> scores = new ArrayList<>();

        for (int i = MIN_BALL_POS; i <= MAX_BALL_POS; i++) {
            Ball playerBall = playerBalls.get(i);
            Score score = getScore(computerBalls, playerBall);
            scores.add(score);
        }

        return Scores.of(scores);
    }

    private Score getScore(Balls computerBalls, Ball playerBall) {
        Score score = NOTHING;

        for (int i = MIN_BALL_POS; i <= MAX_BALL_POS; i++) {
            Ball computerBall = computerBalls.get(i);
            Score currentScore = getScore(computerBall, playerBall);
            score = score.compare(currentScore);
        }

        return score;
    }

    private Score getScore(Ball computerBall, Ball playerBall) {

        if (computerBall.getNo() != playerBall.getNo()) {
            return NOTHING;
        }

        if (computerBall.getPosition() == playerBall.getPosition()) {
            return STRIKE;
        }

        return BALL;
    }
}

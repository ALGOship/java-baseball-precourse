package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static baseball.constant.GameRule.MAX_BALL_POS;
import static baseball.constant.GameRule.MIN_BALL_POS;
import static baseball.domain.Score.*;

public class CalculatorImpl implements Calculator {

    @Override
    public List<Score> getScores(Balls computerBalls, Balls playerBalls) {
        List<Score> scores = new ArrayList<>();

        for (int i = MIN_BALL_POS; i <= MAX_BALL_POS; i++) {
            Optional<Ball> playerBall = playerBalls.get(i);
            if (!playerBall.isPresent()) continue;
            Score score = getScore(computerBalls, playerBall.get());
            scores.add(score);
        }

        validateCompare(scores);
        return scores;
    }

    private void validateCompare(List<Score> scores) {
        if (scores.size() != MAX_BALL_POS) {
            throw new IllegalStateException("비교중 누락된 Ball 발생");
        }
    }

    private Score getScore(Balls computerBalls, Ball playerBall) {
        Score score = NOTHING;

        for (int i = MIN_BALL_POS; i <= MAX_BALL_POS; i++) {
            Optional<Ball> computerBall = computerBalls.get(i);
            if (!computerBall.isPresent()) continue;
            Score currentScore = getScore(computerBall.get(), playerBall);
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

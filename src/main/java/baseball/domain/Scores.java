package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameRule.MAX_BALL_POS;
import static baseball.domain.Score.BALL;
import static baseball.domain.Score.STRIKE;

public class Scores {

    private List<Score> scores = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;

    private Scores(List<Score> scores) {
        this.scores = scores;
        setStrike();
        setBall();
    }

    public static Scores of(List<Score> scores) {
        return new Scores(scores);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isAllStrike() {
        return strike == MAX_BALL_POS;
    }

    private void setStrike() {
        this.strike = (int) scores.stream().filter(score -> score == STRIKE).count();
    }

    private void setBall() {
        this.ball = (int) scores.stream().filter(score -> score == BALL).count();
    }
}

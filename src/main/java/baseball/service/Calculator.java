package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Score;

import java.util.List;

public interface Calculator {

    List<Score> getScores(Balls ComputerBalls, Balls playerBalls);

}

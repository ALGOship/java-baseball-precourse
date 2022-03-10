package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Scores;

public interface Calculator {

    Scores getScores(Balls ComputerBalls, Balls playerBalls);

}

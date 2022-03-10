package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Score;
import baseball.service.Calculator;
import baseball.util.Reviser;
import nextstep.utils.Console;

import java.util.List;

public class BaseBallGame {

    public static void start(Calculator calculator) {
        Balls computerBalls = Computer.generateBalls();
        // TODO while 정답일때 까지
        Balls playerBalls = getPlayerBalls();

        List<Score> scores = calculator.getScores(computerBalls, playerBalls);
        printScore(scores);
    }

    private static void printScore(List<Score> scores) {
    }

    private static Balls getPlayerBalls() {
        String input = Console.readLine();
        return Balls.valueOf(Reviser.mapToIntList(input));
    }

}

package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.util.Reviser;
import nextstep.utils.Console;

public class BaseBallGame {

    public static void start() {
        Balls ComputerBalls = Computer.generateBalls();
        // TODO while 정답일때 까지
        Balls playerBalls = getPlayerBalls();
    }

    public static Balls getPlayerBalls() {
        String input = Console.readLine();
        return Balls.valueOf(Reviser.mapToIntList(input));
    }


}

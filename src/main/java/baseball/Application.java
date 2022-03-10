package baseball;

import baseball.controller.BaseBallGame;
import baseball.service.Computer;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start(Computer.generateBalls());
    }
}

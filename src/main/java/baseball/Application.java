package baseball;

import baseball.controller.BaseBallGame;
import baseball.service.CalculatorImpl;

public class Application {
    public static void main(String[] args) {
        BaseBallGame.start(new CalculatorImpl());
    }
}

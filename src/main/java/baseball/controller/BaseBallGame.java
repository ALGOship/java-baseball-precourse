package baseball.controller;

import baseball.domain.*;
import baseball.service.Calculator;
import baseball.service.CalculatorImpl;
import baseball.service.Computer;
import baseball.util.Reviser;
import nextstep.utils.Console;

import java.util.Arrays;

import static baseball.domain.Status.PLAY;
import static baseball.domain.Status.STOP;

public class BaseBallGame {

    private Calculator calculator;
    private Balls playerBalls;

    public BaseBallGame() {
        calculator = new CalculatorImpl();
    }

    public void start(Balls computerBalls) {
        // 답
        //computerBalls.toList().forEach(b -> System.out.print(b.getNo()));
        //System.out.println();

        while (true) {
            askPlayerBalls();
            Scores scores = calculator.getScores(computerBalls, playerBalls);
            printScore(scores);
            if (scores.isAllStrike()) {
                askReplay();
                break;
            }
        }
    }

    private void askReplay() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            Status status = Arrays.stream(Status.values()).filter(s -> s.getCode() == Reviser.mapToInt(input)).findFirst().get();
            if (status == PLAY) {
                start(Computer.generateBalls());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            askReplay();
        }
    }

    private void askPlayerBalls() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            playerBalls = Balls.valueOf(Reviser.mapToIntList(input));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            askPlayerBalls();
        }
    }

    private void printScore(Scores scores) {
        StringBuilder sb = new StringBuilder();
        if (scores.getStrike() > 0) {
            sb.append(scores.getStrike() + "스트라이크 ");
        }
        if (scores.getBall() > 0) {
            sb.append(scores.getBall() + "볼");
        }
        if (scores.getStrike() == 0 && scores.getBall() == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb);

        if (scores.isAllStrike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return;
        }
    }

}

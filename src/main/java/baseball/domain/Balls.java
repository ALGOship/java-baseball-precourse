package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameRule.MAX_BALL_POS;

public class Balls {

    private List<Ball> balls = new ArrayList<>();

    private Balls(List<Integer> ints) {
        setBalls(ints);
    }

    public static Balls valueOf(List<Integer> ints) {
        validateBalls(ints);
        return new Balls(ints);
    }

    private static void validateBalls(List<Integer> ints) {
        if (ints.isEmpty()) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        if (ints.size() != MAX_BALL_POS) {
            throw new IllegalArgumentException(MAX_BALL_POS + "개의 숫자를 입력해주세요");
        }
    }

    private void setBalls(List<Integer> ints) {
        for (int i = 0; i < ints.size(); i++) {
            balls.add(new Ball(ints.get(i), i + 1));
        }
    }

    public List<Ball> toList() {
        return balls;
    }

    public Ball get(int position) {
        try {
            return balls.stream().filter(ball -> ball.getPosition() == position).findFirst().get();
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new NullPointerException("position 확인 ," + position);

        }
    }

}

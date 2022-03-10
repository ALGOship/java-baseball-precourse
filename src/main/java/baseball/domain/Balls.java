package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    }

    private void setBalls(List<Integer> ints) {
        for (int i = 0; i < ints.size(); i++) {
            balls.add(new Ball(ints.get(i), i + 1));
        }
    }

    public List<Ball> toList() {
        return balls;
    }

    public Optional<Ball> get(int position) {
        return balls.stream().filter(ball -> ball.getPosition() == position).findFirst();
    }

}

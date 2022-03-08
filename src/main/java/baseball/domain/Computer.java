package baseball.domain;

import baseball.constant.GameRule;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

    private Computer() {
    }

    public static Balls generateBalls() {
        Set<Integer> ints = new LinkedHashSet<>();
        while (ints.size() < GameRule.MAX_BALL_POS) {
            ints.add(Randoms.pickNumberInRange(GameRule.MIN_BALL_NO, GameRule.MAX_BALL_NO));
        }
        return Balls.valueOf(new ArrayList<>(ints));
    }

}

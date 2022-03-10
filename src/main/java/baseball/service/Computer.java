package baseball.service;

import baseball.constant.GameRule;
import baseball.domain.Balls;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.domain.Status.PLAY;
import static baseball.domain.Status.STOP;

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

package baseball.domain;

import baseball.constant.GameRule;
import baseball.service.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Computer 테스트")
class ComputerTest {

    Balls balls;

    @BeforeEach
    void setUp() {
        balls = Computer.generateBalls();
    }

    @RepeatedTest(5)
    public void 세자리수_생성() throws Exception {
        assertThat(balls.toList().size()).isEqualTo(GameRule.MAX_BALL_POS);
    }

    @RepeatedTest(5)
    public void 각자리의_포지션_정보_확인() throws Exception {
        List<Integer> positions = balls.toList().stream().map(ball -> ball.getPosition()).collect(Collectors.toList());
        List<Integer> expected = getExpectedPositions();

        // then
        assertThat(positions).isEqualTo(expected);
    }

    @RepeatedTest(5)
    public void 각자리수_범위_확인() throws Exception {
        balls.toList().forEach(ball ->
                assertThat(ball.getNo())
                        .isGreaterThanOrEqualTo(GameRule.MIN_BALL_NO)
                        .isLessThanOrEqualTo(GameRule.MAX_BALL_NO)
        );
    }

    private List<Integer> getExpectedPositions() {
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < GameRule.MAX_BALL_POS; i++) {
            expected.add(i + 1);
        }
        return expected;
    }

}
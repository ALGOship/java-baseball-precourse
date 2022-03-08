package nextstep.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Randoms 테스트")
class RandomsTest {

    @RepeatedTest(5)
    void 범위내_랜덤_숫자_생성() {
        int min = 3;
        int max = 20;
        int number = Randoms.pickNumberInRange(min, max);
        assertThat(number).isGreaterThanOrEqualTo(min).isLessThanOrEqualTo(max);
    }

    @Test
    void 임계값_포함_여부_확인() {
        int min = 1;
        int max = 1;
        int number = Randoms.pickNumberInRange(min, max);
        assertThat(number).isGreaterThanOrEqualTo(min).isLessThanOrEqualTo(max);
    }

}
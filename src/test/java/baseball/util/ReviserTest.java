package baseball.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Reviser 테스트")
class ReviserTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "", "1234"})
    public void 정상입력(String input) throws Exception {
        List<Integer> integers = Reviser.mapToIntList(input);

        // then
        assertThat(integers.size()).isEqualTo(input.length());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a3", "7 4", "z", "  "})
    public void 문자나_빈공간을_포함하여_입력(String input) throws Exception {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Reviser.mapToIntList(input);
        });
    }

}
package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class Reviser {

    public static List<Integer> mapToIntList(String input) {
        List<Integer> ints = input.chars()
                .filter(c -> 48 <= c && c <= 57)
                .boxed().collect(Collectors.toList());

        if (ints.size() != input.length()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return ints;
    }
}

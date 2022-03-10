package baseball.util;

import baseball.domain.Ball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Reviser {

    public static List<Integer> mapToIntList(String input) {
        List<Integer> ints = input.chars()
                .filter(c -> 48 <= c && c <= 57)
                .map(c -> c -= '0')
                .boxed().collect(Collectors.toList());

        if (ints.size() != input.length()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        Set<Integer> set = new LinkedHashSet<>(ints);
        if (ints.size() != set.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력 불가능 합니다.");
        }

        return new ArrayList<>(ints);
    }

    public static int mapToInt(String input) {
        try {
            int result = Integer.parseInt(input);
            if (result == 1 |  result == 2) {
                return result;
            }
        } catch (Exception e) {
        }
        throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
    }
}

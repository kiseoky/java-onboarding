package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return IntStream.rangeClosed(1, number)
                .reduce(0, (acc, i) ->
                    acc + count369(splitNumber(i)
                ));
    }

    private static int count369(List<Integer> integers) {
        return (int) integers.stream()
                .filter(n -> n % 3 == 0 && n != 0)
                .count();
    }

    private static List<Integer> splitNumber(int num) {
        ArrayList<Integer> arrNum = new ArrayList<>();
        while(num > 0) {
            arrNum.add(num %10);
            num /= 10;
        }
        return arrNum;
    }
}

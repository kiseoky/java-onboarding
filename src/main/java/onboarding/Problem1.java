package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isInvalid(pobi) || isInvalid(crong)){
            return -1;
        }

        int pobiNum = getMaxResult(pobi);
        int crongNum = getMaxResult(crong);

        return getWinner(pobiNum, crongNum);
    }

    private static int getWinner(int pobiNum, int crongNum) {
        if (pobiNum > crongNum) {
            return 1;
        } else if(pobiNum < crongNum){
            return 2;
        }
        return 0;
    }

    private static boolean isInvalid(List<Integer> pages){
        return pages.size() != 2 || pages.get(1) - pages.get(0) != 1;
    }

    private static int getMaxResult(List<Integer> pages) {
        int maxResult = 0;
        for (int page : pages) {
            List<Integer> dividedNumber = divideNumber(page);
            maxResult = Math.max(maxResult, sum(dividedNumber));
            maxResult = Math.max(maxResult, multiply(dividedNumber));
        }
        return maxResult;
    }
    private static List<Integer> divideNumber(int num) {
        ArrayList<Integer> arrNum = new ArrayList<>();
        while(num > 0) {
            arrNum.add(num %10);
            num /= 10;
        }
        return arrNum;
    }
    private static int sum(List<Integer> arrNum) {
        int result = 0;
        for (int num : arrNum) {
            result += num;
        }
        return result;
    }
    private static int multiply(List<Integer> arrNum) {
        int result = 1;
        for (int num : arrNum) {
            result *= num;
        }
        return result;
    }
}
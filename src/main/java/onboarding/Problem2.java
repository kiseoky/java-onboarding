package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if(isNotDuplicated(cryptogram)){
            return cryptogram;
        }
        return solution(getDuplicateRemoved(cryptogram));
    }
    private static boolean isNotDuplicated(String crypto) {
        for (int i = 1; i < crypto.length(); i++) {
            if(crypto.charAt(i-1) ==crypto.charAt(i))
                return false;
        }
        return true;
    }
    private static String getDuplicateRemoved(String crypto) {
        StringBuilder duplicatedRemoved = new StringBuilder("");

        for (int i = 0; i < crypto.length(); i++) {
            int skip = getSkip(crypto, i);
            if (skip == 0)
                duplicatedRemoved.append(crypto.charAt(i));
            i += skip;
        }
        return duplicatedRemoved.toString();
    }

    private static int getSkip(String crypto, int i) {
        int skip = 0;
        for (int j = i + 1; j < crypto.length(); j++) {
            if(crypto.charAt(i) != crypto.charAt(j))
                break;
            skip++;
        }
        return skip;
    }
}


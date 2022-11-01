package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return translate(word);
    }

    private static String translate(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        word.chars().forEach(chr->
            stringBuilder.append(translate((char)chr))
        );

        return stringBuilder.toString();
    }

    public static char translate(char chr) {
        if(!Character.isAlphabetic(chr))
            return chr;

        int zNum = (int)'Z';
        int aNum = (int)'A';

        if (Character.isLowerCase(chr)) {
            zNum = (int)'z';
            aNum = (int)'a';
        }

        int diff = zNum - chr;
        return (char) (aNum+diff);
    }
}

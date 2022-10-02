package baseball.model.score;

public class IsStrike {
    public static Boolean check(String target, Character guessCharacter, int currentIndex) {
        return target.indexOf(guessCharacter) == currentIndex;
    }
}

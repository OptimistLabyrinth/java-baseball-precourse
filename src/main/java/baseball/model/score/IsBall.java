package baseball.model.score;

public class IsBall {
    public static Boolean check(String target, Character guessCharacter) {
        return target.indexOf(guessCharacter) != -1;
    }
}

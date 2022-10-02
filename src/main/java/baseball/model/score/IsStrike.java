package baseball.model.score;

public class IsStrike {
    private final String target;
    private final Character guessCharacter;
    private final Integer currentIndex;

    public IsStrike(String target, Character guessCharacter, Integer currentIndex) {
        this.target = target;
        this.guessCharacter = guessCharacter;
        this.currentIndex = currentIndex;
    }

    public Boolean check() {
        return target.indexOf(guessCharacter) == currentIndex;
    }
}

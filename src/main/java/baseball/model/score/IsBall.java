package baseball.model.score;

public class IsBall {
    private final String target;
    private final Character guessCharacter;

    public IsBall(String target, Character guessCharacter) {
        this.target = target;
        this.guessCharacter = guessCharacter;
    }

    public Boolean check() {
        return target.indexOf(guessCharacter) != -1;
    }
}

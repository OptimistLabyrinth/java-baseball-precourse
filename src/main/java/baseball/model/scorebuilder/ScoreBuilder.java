package baseball.model.scorebuilder;

public class ScoreBuilder {
    private final Score score;

    public ScoreBuilder() {
        this.score = new Score();
    }

    public Score build(String target, String guess) {
        for (int i = 0; i < 3; ++i) {
            Boolean sameCharacter = isSameCharacter(target.charAt(i), guess.charAt(i));
            Boolean samePosition = isSamePosition(target, guess.charAt(i));
            addScoreForCurrentDigit(sameCharacter, samePosition);
        }
        return score;
    }

    private Boolean isSameCharacter(Character targetCharacter, Character guessCharacter) {
        return targetCharacter.equals(guessCharacter);
    }

    private Boolean isSamePosition(String target, Character guessCharacter) {
        return target.indexOf(guessCharacter) != -1;
    }

    private void addScoreForCurrentDigit(Boolean sameCharacter, Boolean samePosition) {
        if (sameCharacter && samePosition) {
            score.setStrike(score.getStrike() + 1);
            return;
        }
        if (samePosition) {
            score.setBall(score.getBall() + 1);
        }
    }
}

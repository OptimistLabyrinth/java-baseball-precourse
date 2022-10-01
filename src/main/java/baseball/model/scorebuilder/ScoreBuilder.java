package baseball.model.scorebuilder;

import baseball.constant.NumberBaseballConstant;

public class ScoreBuilder {
    private final Score score;

    public ScoreBuilder() {
        this.score = new Score();
    }

    public Score build(String target, String guess) {
        for (int i = 0; i < NumberBaseballConstant.LENGTH_OF_TARGET_NUMBER; ++i) {
            incrementStrikeOrBall(target, i, guess.charAt(i));
        }
        return score;
    }

    private void incrementStrikeOrBall(String target, int i, Character guessCharacter) {
        if (((Character) target.charAt(i)).equals(guessCharacter)) {
            score.incrementStrike();
            return;
        }
        if (target.indexOf(guessCharacter) != -1) {
            score.incrementBall();
        }
    }
}

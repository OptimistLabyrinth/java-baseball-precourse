package baseball.model.scorebuilder;

import baseball.constant.NumberBaseballGameConstant;

public class ScoreBuilder {
    private final String target;
    private final String guess;

    public ScoreBuilder(String target, String guess) {
        this.target = target;
        this.guess = guess;
    }

    public Score build() {
        Score score = new Score();
        for (int i = 0; i < NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER; ++i) {
            incrementStrikeOrBall(i, score);
        }
        return score;
    }

    private void incrementStrikeOrBall(int i, Score score) {
        if (((Character) target.charAt(i)).equals(guess.charAt(i))) {
            score.incrementStrike();
            return;
        }
        if (target.indexOf(guess.charAt(i)) != -1) {
            score.incrementBall();
        }
    }
}

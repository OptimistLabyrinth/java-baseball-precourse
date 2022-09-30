package baseball.model.scorebuilder;

public class ScoreBuilder {
    public Score build(String target, String guess) {
        Score score = new Score();
        for (int i = 0; i < 3; ++i) {
            if (target.charAt(i) == guess.charAt(i)) {
                score.setStrike(score.getStrike() + 1);
                continue;
            }
            if (target.indexOf(guess.charAt(i)) != -1) {
                score.setBall(score.getBall() + 1);
            }
        }
        return score;
    }
}

package baseball.view;

import baseball.model.scorebuilder.Score;

public class GuessResultMessageBuilder {
    public String build(Score score) {
        StringBuilder scoreStringBuilder = new StringBuilder();
        if (score.getStrike() == 0 && score.getBall() == 0) {
            return "낫싱";
        }
        appendStringBallIfBallValuePositive(score, scoreStringBuilder);
        appendStringStrikeIfStrikeValuePositive(score, scoreStringBuilder);
        return scoreStringBuilder.toString();
    }

    private void appendStringBallIfBallValuePositive(Score score, StringBuilder scoreStringBuilder) {
        if (0 < score.getBall()) {
            scoreStringBuilder.append(score.getBall()).append("볼 ");
        }
    }

    private void appendStringStrikeIfStrikeValuePositive(Score score, StringBuilder scoreStringBuilder) {
        if (0 < score.getStrike()) {
            scoreStringBuilder.append(score.getStrike()).append("스트라이크");
        }
    }
}

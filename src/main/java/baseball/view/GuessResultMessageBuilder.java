package baseball.view;

import baseball.model.scorebuilder.Score;

public class GuessResultMessageBuilder {
    Score score;

    public GuessResultMessageBuilder(Score score) {
        this.score = score;
    }

    public String build() {
        StringBuilder scoreStringBuilder = new StringBuilder();
        if (score.getStrike() == 0 && score.getBall() == 0) {
            return "낫싱";
        }
        appendStringBallIfBallValuePositive(scoreStringBuilder);
        appendStringStrikeIfStrikeValuePositive(scoreStringBuilder);
        return scoreStringBuilder.toString();
    }

    private void appendStringBallIfBallValuePositive(StringBuilder scoreStringBuilder) {
        if (0 < score.getBall()) {
            scoreStringBuilder.append(score.getBall()).append("볼 ");
        }
    }

    private void appendStringStrikeIfStrikeValuePositive(StringBuilder scoreStringBuilder) {
        if (0 < score.getStrike()) {
            scoreStringBuilder.append(score.getStrike()).append("스트라이크");
        }
    }
}

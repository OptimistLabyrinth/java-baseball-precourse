package baseball.view.messagebuilder;

import baseball.model.scorebuilder.Score;

public class GuessResultMessageBuilder implements MessageBuilder {
    @Override
    public String build(Score score) {
        StringBuilder scoreStringBuilder = new StringBuilder();
        if (score.getStrike() == 0 && score.getBall() == 0) {
            return "낫싱";
        }
        if (0 < score.getBall()) {
            scoreStringBuilder.append(score.getBall()).append("볼 ");
        }
        if (0 < score.getStrike()) {
            scoreStringBuilder.append(score.getStrike()).append("스트라이크");
        }
        return scoreStringBuilder.toString();
    }
}

package baseball.view.messagebuilder;

import baseball.model.scorebuilder.Score;

public interface MessageBuilder {
    public String build(Score score);
}

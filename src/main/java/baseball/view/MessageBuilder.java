package baseball.view;

import baseball.model.scorebuilder.Score;

public interface MessageBuilder {
    public String build(Score score);
}

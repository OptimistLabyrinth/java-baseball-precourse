package baseball.view.messagebuilder;

import baseball.model.scorebuilder.Score;

public class GuessInputMessageBuilder implements MessageBuilder {
    @Override
    public String build(Score score) {
        return "숫자를 입력해주세요 : ";
    }
}

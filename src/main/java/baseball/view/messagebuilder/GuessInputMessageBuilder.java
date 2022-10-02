package baseball.view.messagebuilder;

public class GuessInputMessageBuilder implements MessageBuilder {
    @Override
    public String build() {
        return "숫자를 입력해주세요 : ";
    }
}

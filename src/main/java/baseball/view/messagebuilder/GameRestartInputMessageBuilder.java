package baseball.view.messagebuilder;

public class GameRestartInputMessageBuilder implements MessageBuilder {
    @Override
    public String build() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    }
}

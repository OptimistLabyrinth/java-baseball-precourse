package baseball.view.messagebuilder;

public class GameFinishedMessageBuilder implements MessageBuilder {
    @Override
    public String build() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }
}

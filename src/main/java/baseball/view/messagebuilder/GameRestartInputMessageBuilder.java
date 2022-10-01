package baseball.view.messagebuilder;

import baseball.constant.NumberBaseballConstant;

public class GameRestartInputMessageBuilder implements MessageBuilder {
    @Override
    public String build() {
        return "게임을 새로 시작하려면 " + NumberBaseballConstant.GAME_RESTART +
                ", 종료하려면 " + NumberBaseballConstant.PROGRAM_EXIT + " 를 입력하세요";
    }
}

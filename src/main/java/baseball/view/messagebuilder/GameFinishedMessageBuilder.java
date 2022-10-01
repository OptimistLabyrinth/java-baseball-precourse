package baseball.view.messagebuilder;

import baseball.constant.NumberBaseballGameConstant;

public class GameFinishedMessageBuilder implements MessageBuilder {
    @Override
    public String build() {
        return NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER + " 개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }
}

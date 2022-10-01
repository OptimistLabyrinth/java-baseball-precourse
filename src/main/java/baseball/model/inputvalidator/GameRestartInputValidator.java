package baseball.model.inputvalidator;

import baseball.constant.NumberBaseballConstant;

public class GameRestartInputValidator implements InputValidator {
    @Override
    public Boolean validate(String input) {
        return input != null && (
                input.equals(NumberBaseballConstant.GAME_RESTART.toString()) ||
                        input.equals(NumberBaseballConstant.PROGRAM_EXIT.toString()));
    }
}

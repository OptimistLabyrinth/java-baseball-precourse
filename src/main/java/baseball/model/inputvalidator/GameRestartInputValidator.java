package baseball.model.inputvalidator;

import baseball.constant.NumberBaseballProgramConstant;

public class GameRestartInputValidator implements InputValidator {
    @Override
    public Boolean validate(String input) {
        return input != null && (
                input.equals(NumberBaseballProgramConstant.GAME_RESTART.toString()) ||
                        input.equals(NumberBaseballProgramConstant.PROGRAM_EXIT.toString()));
    }
}

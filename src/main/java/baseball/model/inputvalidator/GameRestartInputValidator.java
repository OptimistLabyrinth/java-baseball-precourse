package baseball.model.inputvalidator;

import baseball.constant.NumberBaseballProgramConstant;

public class GameRestartInputValidator implements InputValidator {
    private final String input;

    public GameRestartInputValidator(String input) {
        this.input = input;
    }

    @Override
    public Boolean validate() {
        return input != null && (
                input.equals(NumberBaseballProgramConstant.GAME_RESTART.toString()) ||
                        input.equals(NumberBaseballProgramConstant.PROGRAM_EXIT.toString()));
    }
}

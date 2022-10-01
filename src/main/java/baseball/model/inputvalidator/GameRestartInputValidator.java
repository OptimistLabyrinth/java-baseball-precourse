package baseball.model.inputvalidator;

import java.util.logging.Logger;

public class GameRestartInputValidator implements InputValidator {
    @Override
    public Boolean validate(String input) {
        return input != null && (input.equals("1") || input.equals("2"));
    }
}

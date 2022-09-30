package baseball.model.inputvalidator;

import java.util.Objects;

public class GameRestartInputValidator implements InputValidator {
    @Override
    public Boolean validate(String input) {
        return input != null && (Objects.equals(input, "1") || Objects.equals(input, "2"));
    }
}

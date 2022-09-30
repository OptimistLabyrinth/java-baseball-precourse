package baseball.model.inputvalidator;

public class GuessInputValidator implements InputValidator {
    @Override
    public Boolean validate(String guess) {
        if (guess == null || guess.length() != 3) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            if (guess.charAt(i) < '1' || '9' < guess.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

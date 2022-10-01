package baseball.controller;

import baseball.constant.NumberBaseballProgramConstant;
import baseball.controller.inputacceptor.GameRestartInputAcceptor;
import baseball.model.RandomNumberGenerator;
import baseball.model.inputvalidator.GameRestartInputValidator;

import java.util.function.Function;

public class NumberBaseballProgramController {
    private Boolean programRunning;
    private Boolean gamePlaying;
    Function<Void, Void> setGameStopped;

    public NumberBaseballProgramController() {
        this.programRunning = true;
        this.gamePlaying = true;
        this.setGameStopped = (unused) -> {
            NumberBaseballProgramController.this.gamePlaying = false;
            return null;
        };
    }

    public void run() throws IllegalArgumentException {
        while (programRunning) {
            whileProgramRunning();
        }
    }

    private void whileProgramRunning() throws IllegalArgumentException {
        String randomNumberString = generateRandomNumber();
        gamePlaying = true;
        while (gamePlaying) {
            NumberBaseballGameController numberBaseballGameController =
                    new NumberBaseballGameController(randomNumberString, setGameStopped);
            numberBaseballGameController.whileGamePlaying();
        }
        String restartOrExit = readUserRestartOrExit();
        validateRestartOrExitInput(restartOrExit);
        programRunning = shouldRestartNewGame(restartOrExit);
    }

    private String generateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.generate();
    }

    private String readUserRestartOrExit() {
        GameRestartInputAcceptor gameRestartInputAcceptor = new GameRestartInputAcceptor();
        return gameRestartInputAcceptor.readLine();
    }

    private void validateRestartOrExitInput(String input) throws IllegalArgumentException {
        GameRestartInputValidator gameRestartInputValidator = new GameRestartInputValidator();
        if (!gameRestartInputValidator.validate(input)) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean shouldRestartNewGame(String restartOrExit) {
        return restartOrExit.equals(NumberBaseballProgramConstant.GAME_RESTART.toString());
    }
}

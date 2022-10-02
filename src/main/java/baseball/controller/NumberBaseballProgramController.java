package baseball.controller;

import baseball.constant.NumberBaseballProgramConstant;
import baseball.controller.inputacceptor.GameRestartInputAcceptor;
import baseball.model.RandomNumberGenerator;
import baseball.model.inputvalidator.GameRestartInputValidator;

public class NumberBaseballProgramController {
    private Boolean programRunning;
    private Boolean gamePlaying;
    private final Runnable setGameStopped;

    public NumberBaseballProgramController() {
        this.programRunning = true;
        this.gamePlaying = true;
        this.setGameStopped = () -> NumberBaseballProgramController.this.gamePlaying = false;
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
        GameRestartInputValidator gameRestartInputValidator = new GameRestartInputValidator(input);
        if (!gameRestartInputValidator.validate()) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean shouldRestartNewGame(String restartOrExit) {
        return restartOrExit.equals(NumberBaseballProgramConstant.GAME_RESTART.toString());
    }
}

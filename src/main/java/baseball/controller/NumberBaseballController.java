package baseball.controller;

import baseball.constant.NumberBaseballConstant;
import baseball.controller.displayingmessage.DisplayingMessage;
import baseball.controller.inputacceptor.GameRestartInputAcceptor;
import baseball.controller.inputacceptor.GuessInputAcceptor;
import baseball.model.RandomNumberGenerator;
import baseball.model.inputvalidator.GameRestartInputValidator;
import baseball.model.inputvalidator.GuessInputValidator;
import baseball.model.scorebuilder.Score;
import baseball.model.scorebuilder.ScoreBuilder;
import baseball.view.GuessResultMessageBuilder;

public class NumberBaseballController {
    private Boolean programRunning;
    private Boolean gamePlaying;

    public NumberBaseballController() {
        this.programRunning = true;
        this.gamePlaying = true;
    }

    public void run() throws IllegalArgumentException {
        while (programRunning) {
            whileProgramRunning();
        }
    }

    private void whileProgramRunning() {
        String randomNumberString = generateRandomNumber();
        gamePlaying = true;
        while (gamePlaying) {
            whileGamePlaying(randomNumberString);
        }
        String restartOrExit = readUserRestartOrExit();
        validateRestartOrExitInput(restartOrExit);
        programRunning = getProgramRunningState(restartOrExit);
    }

    public String generateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.generate();
    }

    private void whileGamePlaying(String randomNumberString) {
        String userGuess = readUserGuess();
        validateGuessInput(userGuess);
        Score guessScore = calculateScore(randomNumberString, userGuess);
        String scoreString = showScore(guessScore);
        DisplayingMessage.println(scoreString);
        gamePlaying = getGamePlayingState(guessScore);
    }

    public String readUserGuess() {
        GuessInputAcceptor guessInputAcceptor = new GuessInputAcceptor();
        return guessInputAcceptor.readLine();
    }

    public void validateGuessInput(String guess) throws IllegalArgumentException {
        GuessInputValidator guessInputValidator = new GuessInputValidator();
        if (!guessInputValidator.validate(guess)) {
            throw new IllegalArgumentException();
        }
    }

    public Score calculateScore(String target, String guess) {
        ScoreBuilder scoreBuilder = new ScoreBuilder();
        return scoreBuilder.build(target, guess);
    }

    public String showScore(Score score) {
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder();
        return guessResultMessageBuilder.build(score);
    }

    public Boolean getGamePlayingState(Score guessScore) {
        return !guessScore.getStrike().equals(NumberBaseballConstant.LENGTH_OF_TARGET_NUMBER);
    }

    public String readUserRestartOrExit() {
        GameRestartInputAcceptor gameRestartInputAcceptor = new GameRestartInputAcceptor();
        return gameRestartInputAcceptor.readLine();
    }

    public void validateRestartOrExitInput(String input) throws IllegalArgumentException {
        GameRestartInputValidator gameRestartInputValidator = new GameRestartInputValidator();
        if (!gameRestartInputValidator.validate(input)) {
            throw new IllegalArgumentException();
        }
    }

    public Boolean getProgramRunningState(String restartOrExit) {
        return restartOrExit.equals(NumberBaseballConstant.GAME_RESTART.toString());
    }
}

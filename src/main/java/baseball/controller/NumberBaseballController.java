package baseball.controller;

import baseball.controller.displayingmessage.DisplayingMessage;
import baseball.controller.inputacceptor.GameRestartInputAcceptor;
import baseball.controller.inputacceptor.GuessInputAcceptor;
import baseball.model.RandomNumberGenerator;
import baseball.model.inputvalidator.GameRestartInputValidator;
import baseball.model.inputvalidator.GuessInputValidator;
import baseball.model.scorebuilder.Score;
import baseball.model.scorebuilder.ScoreBuilder;
import baseball.view.messagebuilder.GuessResultMessageBuilder;

import java.util.Objects;

public class NumberBaseballController {
    public void run() throws IllegalArgumentException {
        Boolean programRunning = true;
        while (programRunning) {
            String randomNumberString = generateRandomNumber();
            Boolean gamePlaying = true;
            while (gamePlaying) {
                String userGuess = readUserGuess();
                validateGuessInput(userGuess);
                Score guessScore = calculateScore(randomNumberString, userGuess);
                String scoreString = showScore(guessScore);
                DisplayingMessage.println(scoreString);
                gamePlaying = getGamePlayingState(guessScore);
            }
            String restartOrExit = readUserRestartOrExit();
            validateRestartOrExitInput(restartOrExit);
            programRunning = getProgramRunningState(restartOrExit);
        }
    }

    public String generateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.generate();
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
        return guessScore.getStrike() != 3;
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
        return Objects.equals(restartOrExit, "1");
    }
}

package baseball.controller;

import baseball.constant.NumberBaseballGameConstant;
import baseball.controller.inputacceptor.GuessInputAcceptor;
import baseball.controller.messageprinter.MessagePrinter;
import baseball.model.inputvalidator.GuessInputValidator;
import baseball.model.scorebuilder.Score;
import baseball.model.scorebuilder.ScoreBuilder;
import baseball.view.GuessResultMessageBuilder;

import java.util.function.Function;

public class NumberBaseballGameController {
    private final String randomNumberString;
    private final Function<Void, Void> setGameStopped;

    public NumberBaseballGameController(String randomNumberString, Function<Void, Void> setGameStopped) {
        this.randomNumberString = randomNumberString;
        this.setGameStopped = setGameStopped;
    }

    public void whileGamePlaying() throws IllegalArgumentException {
        String userGuess = readUserGuess();
        validateGuessInput(userGuess);
        Score guessScore = calculateScore(randomNumberString, userGuess);
        String scoreString = scoreAsMessage(guessScore);
        MessagePrinter.println(scoreString);
        if (shouldStopGame(guessScore)) {
            setGameStopped.apply(null);
        }
    }

    private String readUserGuess() {
        GuessInputAcceptor guessInputAcceptor = new GuessInputAcceptor();
        return guessInputAcceptor.readLine();
    }

    private void validateGuessInput(String guess) throws IllegalArgumentException {
        GuessInputValidator guessInputValidator = new GuessInputValidator();
        if (!guessInputValidator.validate(guess)) {
            throw new IllegalArgumentException();
        }
    }

    private Score calculateScore(String target, String guess) {
        ScoreBuilder scoreBuilder = new ScoreBuilder();
        return scoreBuilder.build(target, guess);
    }

    private String scoreAsMessage(Score score) {
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder();
        return guessResultMessageBuilder.build(score);
    }

    private Boolean shouldStopGame(Score guessScore) {
        return guessScore.getStrike().equals(NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER);
    }
}

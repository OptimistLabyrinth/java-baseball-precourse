package baseball.controller;

import baseball.constant.NumberBaseballGameConstant;
import baseball.controller.inputacceptor.GuessInputAcceptor;
import baseball.controller.messageprinter.MessagePrinter;
import baseball.model.inputvalidator.GuessInputValidator;
import baseball.model.score.Score;
import baseball.view.GuessResultMessageBuilder;

public class NumberBaseballGameController {
    private final String randomNumberString;
    private final Runnable setGameStopped;

    public NumberBaseballGameController(String randomNumberString, Runnable setGameStopped) {
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
            setGameStopped.run();
        }
    }

    private String readUserGuess() {
        GuessInputAcceptor guessInputAcceptor = new GuessInputAcceptor();
        return guessInputAcceptor.readLine();
    }

    private void validateGuessInput(String guess) throws IllegalArgumentException {
        GuessInputValidator guessInputValidator = new GuessInputValidator(guess);
        if (!guessInputValidator.validate()) {
            throw new IllegalArgumentException();
        }
    }

    private Score calculateScore(String target, String guess) {
        return new Score(target, guess);
    }

    private String scoreAsMessage(Score score) {
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder(score);
        return guessResultMessageBuilder.build();
    }

    private Boolean shouldStopGame(Score guessScore) {
        return guessScore.getStrike().equals(NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER);
    }
}

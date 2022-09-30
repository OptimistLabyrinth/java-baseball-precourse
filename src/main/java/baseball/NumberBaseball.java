package baseball;

import baseball.controller.inputacceptor.GuessInputAcceptor;
import baseball.model.RandomNumberGenerator;
import baseball.model.inputvalidator.GuessInputValidator;
import baseball.model.scorebuilder.Score;
import baseball.model.scorebuilder.ScoreBuilder;
import baseball.view.messagebuilder.GameFinishedMessageBuilder;
import baseball.view.messagebuilder.GuessResultMessageBuilder;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class NumberBaseball {
    public void play() throws IllegalArgumentException {
        Boolean programRunning = true;
        while (programRunning) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            String randomNumberString = randomNumberGenerator.generate();
            Boolean gamePlaying = true;
            while (gamePlaying) {
                String userGuess = readUserGuess();
                validateGuessInput(userGuess);
                Score guessScore = calculateScore(randomNumberString, userGuess);
                String scoreString = showScore(guessScore);
                System.out.println(scoreString);
                gamePlaying = guessScore.getStrike() != 3;
            }
            String restartOrExit = readUserRestartOrExit();
            validateRestartOrExitInput(restartOrExit);
            programRunning = Objects.equals(restartOrExit, "1");
        }
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

    public String readUserRestartOrExit() {
        GameFinishedMessageBuilder gameFinishedMessageBuilder = new GameFinishedMessageBuilder();
        System.out.println(gameFinishedMessageBuilder.build());
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return Console.readLine();
    }

    public void validateRestartOrExitInput(String input) throws IllegalArgumentException {
        if (!Objects.equals(input, "1") && !Objects.equals(input, "2")) {
            throw new IllegalArgumentException();
        }
    }
}

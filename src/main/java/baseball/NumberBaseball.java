package baseball;

import baseball.controller.inputacceptor.GuessInputAcceptor;
import baseball.model.RandomNumberGenerator;
import baseball.model.inputvalidator.GuessInputValidator;
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
                gamePlaying = guessScore.strike != 3;
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

    class Score {
        Integer strike;
        Integer ball;

        public Score() {
            this.strike = 0;
            this.ball = 0;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "strike=" + strike +
                    ", ball=" + ball +
                    '}';
        }
    }

    public Score calculateScore(String target, String guess) {
        Score score = new Score();
        for (int i = 0; i < 3; ++i) {
            if (target.charAt(i) == guess.charAt(i)) {
                score.strike++;
                continue;
            }
            if (target.indexOf(guess.charAt(i)) != -1) {
                score.ball++;
            }
        }
        return score;
    }

    public String showScore(Score score) {
        StringBuilder scoreStringBuilder = new StringBuilder();
        if (score.strike == 0 && score.ball == 0) {
            return "낫싱";
        }
        if (0 < score.ball) {
            scoreStringBuilder.append(score.ball).append("볼 ");
        }
        if (0 < score.strike) {
            scoreStringBuilder.append(score.strike).append("스트라이크");
        }
        return scoreStringBuilder.toString();
    }

    public String readUserRestartOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return Console.readLine();
    }

    public void validateRestartOrExitInput(String input) throws IllegalArgumentException {
        if (!Objects.equals(input, "1") && !Objects.equals(input, "2")) {
            throw new IllegalArgumentException();
        }
    }
}

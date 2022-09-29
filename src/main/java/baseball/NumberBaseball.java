package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class NumberBaseball {
    public void play() throws IllegalArgumentException {
        Boolean programRunning = true;
        while (programRunning) {
            String randomNumberString = generateRandomNumberString();
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

    public String generateRandomNumberString() {
        Set<Integer> numbers = new HashSet<Integer>();
        StringBuilder randomNumberStringBuilder = new StringBuilder();
        while (randomNumberStringBuilder.length() < 3) {
            Integer randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                randomNumberStringBuilder.append(randomNumber);
                numbers.add(randomNumber);
            }
        }
        return randomNumberStringBuilder.toString();
    }

    public String readUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void validateGuessInput(String guess) throws IllegalArgumentException {
        if (guess.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; ++i) {
            Character currentCharacter = guess.charAt(i);
            if (currentCharacter.compareTo('1') < 0 || 0 < currentCharacter.compareTo('9')) {
                throw new IllegalArgumentException();
            }
        }
        List<String> guessSplit = Arrays.asList(guess.split(""));
        Set<String> guessSet = new HashSet<>(guessSplit);
        if (guessSet.size() != 3) {
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

package baseball.model.score;

import baseball.constant.NumberBaseballGameConstant;

public class Score {
    private Integer strike;
    private Integer ball;

    public Score(String target, String guess) {
        this.strike = 0;
        this.ball = 0;
        calculateGuessScore(target, guess);
    }

    public Score(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    private void calculateGuessScore(String target, String guess) {
        for (int i = 0; i < NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER; ++i) {
            incrementScore(target, guess, i);
        }
    }

    private void incrementScore(String target, String guess, int i) {
        if (IsStrike.check(target, guess.charAt(i), i)) {
            incrementStrike();
            return;
        }
        if (IsBall.check(target, guess.charAt(i))) {
            incrementBall();
        }
    }

    public Integer getStrike() {
        return strike;
    }

    private void incrementStrike() {
        this.strike = this.strike + 1;
    }

    public Integer getBall() {
        return ball;
    }

    private void incrementBall() {
        this.ball = this.ball + 1;
    }
}

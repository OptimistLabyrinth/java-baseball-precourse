package baseball.model.scorebuilder;

public class Score {
    private Integer strike;
    private Integer ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public Score(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public void incrementStrike() {
        this.strike = this.strike + 1;
    }

    public Integer getBall() {
        return ball;
    }

    public void incrementBall() {
        this.ball = this.ball + 1;
    }

    @Override
    public String toString() {
        return "Score{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}

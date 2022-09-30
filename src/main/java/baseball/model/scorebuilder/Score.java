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

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Score{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}

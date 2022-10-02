package baseball.view;

import baseball.model.score.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GuessResultMessageBuilderTest {
    @ParameterizedTest(name = "점수가 ball: 0 이면 메시지에 스트라이크 값 {0} 을 포함하고 있어야 한다.")
    @DisplayName("점수가 ball: 0 이면 메시지에 스트라이크 값을 포함하고 있어야 한다.")
    @ValueSource(ints = {1, 2, 3})
    public void shouldContainStrikeValueOnlyWhenBallIsZero(Integer strike) {
        Integer ball = 0;
        Score score = new Score(strike, ball);
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder(score);
        String message = guessResultMessageBuilder.build();
        assertThat(message).contains(strike.toString());
    }

    @ParameterizedTest
    @DisplayName("점수가 ball: 0 이면 메시지에 '볼' 이라는 문자열을 포함하지 않아야 한다.")
    @ValueSource(ints = {1, 2, 3})
    public void shouldNotContainStringBall(Integer strike) {
        Integer ball = 0;
        Score score = new Score(strike, ball);
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder(score);
        String message = guessResultMessageBuilder.build();
        assertThat(message).doesNotContain("볼");
    }

    @ParameterizedTest(name = "점수가 strike: 0 이면 메시지에 볼 값 {0} 을 포함하고 있어야 한다.")
    @DisplayName("점수가 strike: 0 이면 메시지에 볼 값을 포함하고 있어야 한다.")
    @ValueSource(ints = {1, 2, 3})
    public void shouldContainBallValueWhenStrikeIsZero(Integer ball) {
        Integer strike = 0;
        Score score = new Score(strike, ball);
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder(score);
        String message = guessResultMessageBuilder.build();
        assertThat(message).contains(ball.toString());
    }

    @ParameterizedTest
    @DisplayName("점수가 strike: 0 이면 메시지에 '스트라이크' 라는 문자열을 포함하지 않아야 한다.")
    @ValueSource(ints = {1, 2, 3})
    public void shouldNotContainStringStrike(Integer ball) {
        Integer strike = 0;
        Score score = new Score(strike, ball);
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder(score);
        String message = guessResultMessageBuilder.build();
        assertThat(message).doesNotContain("스트라이크");
    }

    @ParameterizedTest(name = "점수가 strike != 0, ball != 0 이면 스트라이크 값 {0}, 볼 값 {1} 을 모두 포함하고 있어야 한다.")
    @DisplayName("점수가 strike != 0, ball != 0 이면 스트라이크 값, 볼 값을 모두 포함하고 있어야 한다.")
    @CsvSource(value = {"1:1", "1:2", "2:1"}, delimiter = ':')
    public void shouldContainBothStrikeValueAndBallValue(Integer strike, Integer ball) {
        Score score = new Score(strike, ball);
        GuessResultMessageBuilder guessResultMessageBuilder = new GuessResultMessageBuilder(score);
        String message = guessResultMessageBuilder.build();
        assertThat(message).contains(strike.toString(), ball.toString());
    }
}

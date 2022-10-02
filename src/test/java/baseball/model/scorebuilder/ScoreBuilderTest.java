package baseball.model.scorebuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreBuilderTest {
    @ParameterizedTest(name = "{0}, {1}, 점수는 {2}-{3}")
    @DisplayName("세 자리 숫자 입력에 대해서 올바른 strike, ball 을 반환해야 한다")
    @CsvSource(value = {"123:123:3:0", "123:124:2:0", "123:135:1:1", "123:891:0:1", "123:312:0:3"}, delimiter = ':')
    public void shouldGetCorrectStrikeAdnBall(
            String target,
            String guess,
            Integer expectedStrike,
            Integer expectedBall
    ) {
        ScoreBuilder scoreBuilder = new ScoreBuilder(target, guess);
        Score score = scoreBuilder.build();
        assertThat(score.getStrike()).isEqualTo(expectedStrike);
        assertThat(score.getBall()).isEqualTo(expectedBall);
    }
}

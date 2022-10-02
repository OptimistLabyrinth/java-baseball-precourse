package baseball.model.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @ParameterizedTest(name = "{0}, {1}, 점수는 {2}-{3}")
    @DisplayName("세 자리 숫자 입력에 대해서 올바른 strike, ball 을 반환해야 한다")
    @CsvSource(value = {
            "123:123:3:0",
            "123:124:2:0",
            "123:143:2:0",
            "123:423:2:0",
            "123:921:1:1",
            "123:913:1:1",
            "123:192:1:1",
            "123:293:1:1",
            "123:139:1:1",
            "123:329:1:1",
            "123:671:0:1",
            "123:672:0:1",
            "123:617:0:1",
            "123:637:0:1",
            "123:671:0:1",
            "123:672:0:1",
            "123:912:0:2",
            "123:931:0:2",
            "123:392:0:2",
            "123:291:0:2",
            "123:239:0:2",
            "123:319:0:2",
            "123:312:0:3",
            "123:231:0:3"
    },
            delimiter = ':'
    )
    public void shouldGetCorrectStrikeAdnBall(
            String target,
            String guess,
            Integer expectedStrike,
            Integer expectedBall
    ) {
        Score score = new Score(target, guess);
        assertThat(score.getStrike()).isEqualTo(expectedStrike);
        assertThat(score.getBall()).isEqualTo(expectedBall);
    }
}

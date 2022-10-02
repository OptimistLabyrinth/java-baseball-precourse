package baseball.model.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class IsStrikeTest {
    @ParameterizedTest
    @DisplayName("특정한 숫자가 맞춰야 하는 숫자의 특정 인덱스에 있을 때만 '스트라이크' 이다")
    @CsvSource(value = {
            "123:1:0:true",
            "123:1:1:false",
            "123:1:2:false",
            "123:2:0:false",
            "123:2:1:true",
            "123:2:2:false",
            "123:3:0:false",
            "123:3:1:false",
            "123:3:2:true",
            "123:9:0:false",
            "123:9:1:false",
            "123:9:2:false"
    },
            delimiter = ':'
    )
    public void shouldBeStrike(
            String target,
            Character guessCharacter,
            int index,
            Boolean expectedResult
    ) {
        IsStrike isStrike = new IsStrike(target, guessCharacter, index);
        assertThat(isStrike.check()).isEqualTo(expectedResult);
    }
}

package baseball.model;

import baseball.constant.NumberBaseballGameConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {
    private final Set<Integer> numbers;
    private final StringBuilder randomNumberStringBuilder;

    public RandomNumberGenerator() {
        this.numbers = new HashSet<>();
        this.randomNumberStringBuilder = new StringBuilder();
    }

    public String generate() {
        while (randomNumberStringBuilder.length() < NumberBaseballGameConstant.LENGTH_OF_TARGET_NUMBER) {
            generateOneDigit();
        }
        return randomNumberStringBuilder.toString();
    }

    private void generateOneDigit() {
        Integer randomNumber = Randoms.pickNumberInRange(
                NumberBaseballGameConstant.MINIMUM_OF_EACH_DIGIT,
                NumberBaseballGameConstant.MAXIMUM_OF_EACH_DIGIT
        );
        if (!numbers.contains(randomNumber)) {
            randomNumberStringBuilder.append(randomNumber);
            numbers.add(randomNumber);
        }
    }
}

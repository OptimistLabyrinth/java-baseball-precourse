package baseball.model;

import baseball.constant.NumberBaseballConstant;
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
        while (randomNumberStringBuilder.length() < NumberBaseballConstant.LENGTH_OF_TARGET_NUMBER) {
            whileLoop();
        }
        return randomNumberStringBuilder.toString();
    }

    private void whileLoop() {
        Integer randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!numbers.contains(randomNumber)) {
            randomNumberStringBuilder.append(randomNumber);
            numbers.add(randomNumber);
        }
    }
}

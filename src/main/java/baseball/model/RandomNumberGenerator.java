package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {
    private final Set<Integer> numbers;
    private final StringBuilder randomNumberStringBuilder;

    public RandomNumberGenerator() {
        this.numbers = new HashSet<Integer>();
        this.randomNumberStringBuilder = new StringBuilder();
    }

    public String generate() {
        while (randomNumberStringBuilder.length() < 3) {
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

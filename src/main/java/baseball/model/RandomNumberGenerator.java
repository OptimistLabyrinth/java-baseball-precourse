package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator {
    public String generate() {
        Set<Integer> numbers = new HashSet<Integer>();
        StringBuilder randomNumberStringBuilder = new StringBuilder();
        while (randomNumberStringBuilder.length() < 3) {
            Integer randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                randomNumberStringBuilder.append(randomNumber);
                numbers.add(randomNumber);
            }
        }
        return randomNumberStringBuilder.toString();
    }
}

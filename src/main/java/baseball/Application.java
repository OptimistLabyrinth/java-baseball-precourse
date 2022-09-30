package baseball;

import baseball.controller.NumberBaseballController;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        NumberBaseballController numberBaseballController = new NumberBaseballController();
        numberBaseballController.run();
    }
}

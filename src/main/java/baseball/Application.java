package baseball;

import baseball.controller.NumberBaseballProgramController;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        NumberBaseballProgramController numberBaseballProgramController = new NumberBaseballProgramController();
        numberBaseballProgramController.run();
    }
}

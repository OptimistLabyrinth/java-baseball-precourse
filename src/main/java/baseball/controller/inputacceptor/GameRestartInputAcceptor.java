package baseball.controller.inputacceptor;

import camp.nextstep.edu.missionutils.Console;

public class GameRestartInputAcceptor implements InputAcceptor {
    @Override
    public String readLine() {
        return Console.readLine();
    }
}

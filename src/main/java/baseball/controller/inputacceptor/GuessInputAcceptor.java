package baseball.controller.inputacceptor;

import camp.nextstep.edu.missionutils.Console;

public class GuessInputAcceptor implements InputAcceptor {
    @Override
    public String readLine() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}

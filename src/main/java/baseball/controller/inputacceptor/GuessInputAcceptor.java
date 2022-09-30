package baseball.controller.inputacceptor;

import baseball.view.messagebuilder.GuessInputMessageBuilder;
import camp.nextstep.edu.missionutils.Console;

public class GuessInputAcceptor implements InputAcceptor {
    @Override
    public String readLine() {
        GuessInputMessageBuilder guessInputMessageBuilder = new GuessInputMessageBuilder();
        System.out.print(guessInputMessageBuilder.build(null));
        return Console.readLine();
    }
}

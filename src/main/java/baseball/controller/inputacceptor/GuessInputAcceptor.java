package baseball.controller.inputacceptor;

import baseball.controller.messageprinter.MessagePrinter;
import baseball.view.messagebuilder.GuessInputMessageBuilder;
import camp.nextstep.edu.missionutils.Console;

public class GuessInputAcceptor implements InputAcceptor {
    @Override
    public String readLine() {
        GuessInputMessageBuilder guessInputMessageBuilder = new GuessInputMessageBuilder();
        MessagePrinter.print(guessInputMessageBuilder.build());
        return Console.readLine();
    }
}

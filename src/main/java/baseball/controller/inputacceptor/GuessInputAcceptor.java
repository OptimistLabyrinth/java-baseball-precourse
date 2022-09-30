package baseball.controller.inputacceptor;

import baseball.controller.displayingmessage.DisplayingMessage;
import baseball.view.messagebuilder.GuessInputMessageBuilder;
import camp.nextstep.edu.missionutils.Console;

public class GuessInputAcceptor implements InputAcceptor {
    @Override
    public String readLine() {
        GuessInputMessageBuilder guessInputMessageBuilder = new GuessInputMessageBuilder();
        DisplayingMessage.print(guessInputMessageBuilder.build());
        return Console.readLine();
    }
}

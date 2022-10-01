package baseball.controller.inputacceptor;

import baseball.controller.messageprinter.MessagePrinter;
import baseball.view.messagebuilder.GameFinishedMessageBuilder;
import baseball.view.messagebuilder.GameRestartInputMessageBuilder;
import camp.nextstep.edu.missionutils.Console;

public class GameRestartInputAcceptor implements InputAcceptor {
    @Override
    public String readLine() {
        GameFinishedMessageBuilder gameFinishedMessageBuilder = new GameFinishedMessageBuilder();
        MessagePrinter.println(gameFinishedMessageBuilder.build());
        GameRestartInputMessageBuilder gameRestartInputMessageBuilder = new GameRestartInputMessageBuilder();
        MessagePrinter.println(gameRestartInputMessageBuilder.build());
        return Console.readLine();
    }
}

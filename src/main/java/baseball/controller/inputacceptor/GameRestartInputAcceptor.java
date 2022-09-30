package baseball.controller.inputacceptor;

import baseball.view.messagebuilder.GameFinishedMessageBuilder;
import baseball.view.messagebuilder.GameRestartInputMessageBuilder;
import camp.nextstep.edu.missionutils.Console;

public class GameRestartInputAcceptor implements InputAcceptor {
    @Override
    public String readLine() {
        GameFinishedMessageBuilder gameFinishedMessageBuilder = new GameFinishedMessageBuilder();
        System.out.println(gameFinishedMessageBuilder.build());
        GameRestartInputMessageBuilder gameRestartInputMessageBuilder = new GameRestartInputMessageBuilder();
        System.out.println(gameRestartInputMessageBuilder.build());
        return Console.readLine();
    }
}

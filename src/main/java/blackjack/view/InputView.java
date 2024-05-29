package blackjack.view;

import blackjack.utils.CommaStringSplitter;
import blackjack.utils.Console;

import java.util.List;

public class InputView {
    private static final String INPUT_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)";
    private static final String ANSWER_YES = "y";
    private static final String ANSWER_NO = "n";
    private static final String NOT_YES_OR_NO = "y 또는 n 중 하나를 입력해주세요.";

    public List<String> inputPlayerNames() {
        System.out.println(INPUT_PLAYER_NAME);
        final List<String> names = CommaStringSplitter.split(Console.readLine());
        System.out.println();
        return names;
    }

    public boolean inputMoreCard(final String name) {
        System.out.printf("%s는 카드를 더 받겠습니까? (예는 y, 아니오는 n)%n", name);
        final String answer = Console.readLine();
        if (!isYesOrNo(answer)) {
            throw new IllegalArgumentException(NOT_YES_OR_NO);
        }
        return ANSWER_YES.equalsIgnoreCase(answer);
    }

    private boolean isYesOrNo(final String answer) {
        return ANSWER_YES.equalsIgnoreCase(answer) || ANSWER_NO.equalsIgnoreCase(answer);
    }
}
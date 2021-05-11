package seonjae.plugin.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import seonjae.library.mc.message.SimpleMessage;

@AllArgsConstructor
public enum ExampleMessage implements SimpleMessage {

    JOIN_CONSOLE1("{0}님이 접속했습니다."),
    JOIN_CONSOLE2("접속 이벤트 발생!"),
    JOIN_BROADCAST1("{0} 님이 입장하셨습니다!"),
    JOIN_BROADCAST2("누군가 접속했습니다!"),
    JOIN_USER1("{0}님! 어서오세요!"),
    JOIN_USER2("어서오세요!");

    @Getter
    private String text;
}

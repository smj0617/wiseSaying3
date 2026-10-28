package com.back;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AppTestRunner {

    // 입력을 넣어 앱을 실행하고, 콘솔에 출력된 내용을 문자열로 돌려준다.
    public static String run(String input) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            AppContext.renew(new Scanner(input.stripIndent().trim() + "\n종료\n"));
            new App().run();
        } finally {
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8);
    }
}

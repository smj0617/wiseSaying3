package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final List<WiseSaying> wiseSayings = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private int lastId = 0;

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "종료" -> {
                    return;
                }
                case "등록" -> actionWrite();
                case "목록" -> actionList();
                case "삭제" -> actionDelete(rq);
                case "수정" -> actionModify(rq);
                default -> System.out.println("알 수 없는 명령입니다.");
            }
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String sentence = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = write(sentence, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        findForList().forEach(e ->
                System.out.printf("%d / %s / %s\n", e.getId(), e.getAuthor(), e.getSentence()));
    }

    private void actionDelete(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            System.out.println("id를 숫자로 입력해주세요.");
            return;
        }

        if (!delete(id)) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    private void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            System.out.println("id를 숫자로 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);
        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getSentence());
        System.out.print("명언 : ");
        String sentence = sc.nextLine().trim();
        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        modify(wiseSaying, sentence, author);
    }

    private WiseSaying write(String sentence, String author) {
        WiseSaying wiseSaying = new WiseSaying(++lastId, sentence, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    private List<WiseSaying> findForList() {
        return wiseSayings.reversed();
    }

    private WiseSaying findById(int id) {
        return wiseSayings
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private boolean delete(int id) {
        return wiseSayings.removeIf(e -> e.getId() == id);
    }

    private void modify(WiseSaying wiseSaying, String sentence, String author) {
        wiseSaying.setSentence(sentence);
        wiseSaying.setAuthor(author);
    }
}

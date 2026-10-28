package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RqTest {
    @Test
    @DisplayName("\"삭제?id=1\" : getActionName()")
    void t1() {
        assertThat(new Rq("삭제?id=1").getActionName()).isEqualTo("삭제");
    }

    @Test
    @DisplayName("\"삭제?id=1\" : getParamAsInt(\"id\", -1)")
    void t2() {
        assertThat(new Rq("삭제?id=1").getParamAsInt("id", -1)).isEqualTo(1);
    }

    @Test
    @DisplayName("파라미터 없음 -> 기본값")
    void t3() {
        assertThat(new Rq("삭제").getParamAsInt("id", -1)).isEqualTo(-1);
    }

    @Test
    @DisplayName("값 없음 -> 기본값")
    void t4() {
        assertThat(new Rq("삭제?id=").getParamAsInt("id", -1)).isEqualTo(-1);
    }

    @Test
    @DisplayName("숫자 아님 -> 기본값")
    void t5() {
        assertThat(new Rq("삭제?id=일번").getParamAsInt("id", -1)).isEqualTo(-1);
    }

    @Test
    @DisplayName("\"목록?searchKeyword=영광\" : getParam")
    void t6() {
        assertThat(new Rq("목록?searchKeyword=영광").getParam("searchKeyword", "")).isEqualTo("영광");
    }

    @Test
    @DisplayName("\"목록\" : getParam -> 기본값")
    void t7() {
        assertThat(new Rq("목록").getParam("searchKeyword", "")).isEqualTo("");
    }

    @Test
    @DisplayName("파라미터 여러 개")
    void t8() {
        assertThat(new Rq("목록?page=5&searchKeyword=영광").getParamAsInt("page", -1)).isEqualTo(5);
    }

    @Test
    @DisplayName("파라미터 순서가 바뀌어도 동작")
    void t9() {
        assertThat(new Rq("목록?searchKeyword=영광&page=5").getParamAsInt("page", -1)).isEqualTo(5);
    }
}

package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.utility.IllegalArgumentMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("이벤트 혜택 테스트")
class EventTest {
    @Test
    void 디데이_할인_테스트() {
        assertTrue(new Event(20).isDDayEvent());
        assertFalse(new Event(26).isDDayEvent());
    }

    @Test
    void 평일_할인_테스트() {
        assertTrue(new Event(25).isWeekDayEvent());
        assertTrue(new Event(31).isWeekDayEvent());
        assertFalse(new Event(15).isWeekDayEvent());
        assertFalse(new Event(16).isWeekDayEvent());
    }

    @Test
    void 주말_할인_테스트() {
        assertFalse(new Event(25).isWeekEndEvent());
        assertFalse(new Event(31).isWeekEndEvent());
        assertTrue(new Event(15).isWeekEndEvent());
        assertTrue(new Event(16).isWeekEndEvent());
    }

    @Test
    void 특별_할인_테스트() {
        assertTrue(new Event(25).isSpecialEvent());
        assertTrue(new Event(31).isSpecialEvent());
        assertFalse(new Event(15).isSpecialEvent());
        assertFalse(new Event(16).isSpecialEvent());
    }

    @Test
    void 증정_이벤트_테스트() {
        assertTrue(new Event(31).isGiftEvent(120000));
        assertFalse(new Event(31).isGiftEvent(119999));
    }

    @ParameterizedTest
    @CsvSource({"32", "0", "-1"})
    void 이벤트_날짜_범위_외_테스트(int day) {
        assertThatThrownBy(() -> new Event(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentMessage.INVALID_DATE);
    }
}
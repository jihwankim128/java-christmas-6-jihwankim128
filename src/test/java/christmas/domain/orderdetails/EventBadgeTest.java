package christmas.domain.orderdetails;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이벤트 배지 테스트")
class EventBadgeTest {
    @Test
    void 산타_배지_테스트() {
        assertEquals("산타", EventBadge.getBadge(Integer.MAX_VALUE).toString());
        assertEquals("산타", EventBadge.getBadge(20000).toString());
    }

    @Test
    void 트리_배지_테스트() {
        assertEquals("트리", EventBadge.getBadge(19999).toString());
        assertEquals("트리", EventBadge.getBadge(10000).toString());
    }


    @Test
    void 별_배지_테스트() {
        assertEquals("별", EventBadge.getBadge(9999).toString());
        assertEquals("별", EventBadge.getBadge(5000).toString());
    }


    @Test
    void 배지가_없을_때_테스트() {
        assertEquals("없음", EventBadge.getBadge(4999).toString());
        assertEquals("없음", EventBadge.getBadge(0).toString());
    }
}
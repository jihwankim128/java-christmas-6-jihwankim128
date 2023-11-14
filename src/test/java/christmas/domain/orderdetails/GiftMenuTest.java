package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("증정 메뉴 테스트")
class GiftMenuTest {
    @Test
    void 증정_메뉴_대상() {
        assertThat(new GiftMenu(120000, new Event(1)).toString()).contains("샴페인 1개");
    }
    
    @Test
    void 증정_메뉴_비대상() {
        assertThat(new GiftMenu(119999, new Event(1)).toString()).contains("없음");
    }
}
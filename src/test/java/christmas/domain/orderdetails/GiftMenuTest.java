package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("증정 메뉴 테스트")
class GiftMenuTest {
    @Test
    void 증정_메뉴_대상() {
        GiftMenu giftMenu = new GiftMenu();
        giftMenu.provide();
        assertThat(giftMenu.toString()).contains("샴페인 1개");
        assertEquals(25000, giftMenu.price());
    }
    
    @Test
    void 증정_메뉴_비대상() {
        GiftMenu giftMenu = new GiftMenu();
        assertThat(giftMenu.toString()).contains("없음");
        assertEquals(0, giftMenu.price());
    }
}
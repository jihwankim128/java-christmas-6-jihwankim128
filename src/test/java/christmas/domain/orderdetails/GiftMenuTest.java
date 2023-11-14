package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        List<Order> orders = Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        );
        assertThat(new GiftMenu(new TotalPrice(orders), new Event(1)).toString()).contains("샴페인 1개");
    }
    
    @Test
    void 증정_메뉴_비대상() {
        List<Order> orders = Arrays.asList(new Order("타파스", 1), new Order("제로콜라",1));
        assertThat(new GiftMenu(new TotalPrice(orders), new Event(1)).toString()).contains("없음");
    }
}
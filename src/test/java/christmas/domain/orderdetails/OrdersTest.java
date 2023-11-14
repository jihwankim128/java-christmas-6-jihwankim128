package christmas.domain.orderdetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Order;
import christmas.utility.IllegalArgumentMessage;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문 메뉴를 제대로 관리하는지 테스트")
class OrdersTest {
    @Test
    void 주문_메뉴_출력() {
        Orders orders = new Orders(Arrays.asList(
                new Order("제로콜라", 3),
                new Order("양송이수프", 5),
                new Order("타파스", 2)
        ));
        assertThat(orders.toString()).contains(
                "제로콜라 3개",
                "양송이수프 5개",
                "타파스 2개"
        );
    }

    @Test
    void 주문_수량_에러() {
        assertThatThrownBy(() -> new Orders(Arrays.asList(
                new Order("제로콜라", 10),
                new Order("양송이수프", 9),
                new Order("타파스", 2)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentMessage.INVALID_ORDER);
    }

    @Test
    void 오직_음료_주문_에러() {
        assertThatThrownBy(() -> new Orders(Arrays.asList(
                new Order("제로콜라", 1),
                new Order("레드와인", 1),
                new Order("샴페인", 1)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentMessage.INVALID_ORDER);
    }

    @Test
    void 중복_주문_에러() {
        assertThatThrownBy(() -> new Orders(Arrays.asList(
                new Order("제로콜라", 1),
                new Order("제로콜라", 1),
                new Order("양송이수프", 1)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentMessage.INVALID_ORDER);
    }
}
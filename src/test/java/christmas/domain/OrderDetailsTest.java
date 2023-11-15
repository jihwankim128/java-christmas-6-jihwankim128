package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문 상세 정보 테스트")
class OrderDetailsTest {
    List<Order> firstExampleOrders = Arrays.asList(
            new Order("티본스테이크", 1),
            new Order("바비큐립", 1),
            new Order("초코케이크", 2),
            new Order("제로콜라", 1)
    );

    List<Order> secondExampleOrders = Arrays.asList(new Order("타파스", 1), new Order("제로콜라",1));

    @Test
    void 예시_주문1_혜택_적용() {
        OrderDetails orderDetails = new OrderDetails(new Orders(firstExampleOrders));
        orderDetails.provideGift(new Event(3));
        orderDetails.applyBenefit(new Event(3));
        예시_주문_목록(orderDetails);
        예시_총_가격(orderDetails);
        예시_증정_상품(orderDetails);
        예시_혜택_적용(orderDetails);
        예시_최종_할인(orderDetails);
        예시_최종_결제(orderDetails);
        예시_배지_부여(orderDetails);
    }

    @Test
    void 예시_주문2() {
        OrderDetails orderDetails = new OrderDetails(new Orders(secondExampleOrders));
        assertThat(orderDetails.getOrders().toString()).contains("타파스 1개", "제로콜라 1개");
        assertThat(orderDetails.getTotalPriceBeforeBenefit().toString()).contains("8,500원");
        assertThat(orderDetails.getGiftMenu().toString()).contains("없음");
        assertThat(orderDetails.getBenefit().toString()).contains("없음");
        assertThat(orderDetails.getTotalDiscountAmount().toString()).contains("0원");
        assertThat(orderDetails.getTotalPriceAfterBenefit().toString()).contains("8,500원");
        assertThat(orderDetails.getBadge().toString()).contains("없음");
    }

    void 예시_주문_목록(OrderDetails orderDetails) {
        assertThat(orderDetails.getOrders().toString()).contains(
                "티본스테이크 1개",
                "바비큐립 1개",
                "초코케이크 2개",
                "제로콜라 1개"
        );
    }

    void 예시_총_가격(OrderDetails orderDetails) {
        assertThat(orderDetails.getTotalPriceBeforeBenefit().toString()).contains("142,000원");
    }

    void 예시_증정_상품(OrderDetails orderDetails) {
        assertThat(orderDetails.getGiftMenu().toString()).contains("샴페인 1개");
    }

    void 예시_혜택_적용(OrderDetails orderDetails) {
        assertThat(orderDetails.getBenefit().toString()).contains(
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원"
        );
    }

    void 예시_최종_할인(OrderDetails orderDetails) {
        assertThat(orderDetails.getTotalDiscountAmount().toString()).contains("-31,246원");
    }

    void 예시_최종_결제(OrderDetails orderDetails) {
        assertThat(orderDetails.getTotalPriceAfterBenefit().toString()).contains("135,754원");
    }

    void 예시_배지_부여(OrderDetails orderDetails) {
        assertThat(orderDetails.getBadge().toString()).contains("산타");
    }
}
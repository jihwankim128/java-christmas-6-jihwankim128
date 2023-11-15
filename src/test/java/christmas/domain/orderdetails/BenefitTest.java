package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("혜택 테스트")
class BenefitTest {
    Benefit benefit;

    @BeforeEach
    void init() {
        benefit = new Benefit();
    }

    @Test
    void 혜택_테스트() {
        List<Order> orders = Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        );
        benefit.applyBenefit(orders, 142000, new Event(3));
        assertThat(benefit.toString()).contains(
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원"
        );
        assertEquals(31246, benefit.totalDiscountAmount());
    }

    @Test
    void 무혜택_테스트() {
        List<Order> orders = Arrays.asList(new Order("타파스", 1), new Order("제로콜라",1));
        benefit.applyBenefit(orders, 8500, new Event(26));
        assertThat(benefit.toString()).contains("없음");
        assertEquals(0, benefit.totalDiscountAmount());
    }
}
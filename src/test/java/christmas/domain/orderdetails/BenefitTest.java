package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("혜택 테스트")
class BenefitTest {
    Benefit benefit;

    @Test
    void 혜택_테스트() {
        List<Order> orders = Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        );
        benefit = new Benefit(orders, new TotalPrice(orders).getTotalPrice(), new Event(3));
        assertEqualsResult(1200, 4046, 0, 1000, 25000);
        assertThatResult();
    }

    @Test
    void 무혜택_테스트() {
        List<Order> orders = Arrays.asList(new Order("타파스", 1), new Order("제로콜라",1));
        benefit = new Benefit(orders, new TotalPrice(orders).getTotalPrice(), new Event(26));
        assertEqualsResult(0, 0, 0, 0, 0);
        assertThat(benefit.toString()).contains("없음");
    }

    void assertEqualsResult(int dDay, int weekDay, int weekEnd, int special, int gift) {
        assertEquals(dDay, benefit.getdDayBenefit());
        assertEquals(weekDay, benefit.getWeekDayBenefit());
        assertEquals(weekEnd, benefit.getWeekEndBenefit());
        assertEquals(special, benefit.getSpecialBenefit());
        assertEquals(gift, benefit.getGiftBenefit());
    }

    void assertThatResult() {
        assertThat(benefit.toString()).contains(
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원"
        );
    }
}
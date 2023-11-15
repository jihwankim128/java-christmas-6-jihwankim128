package christmas.domain.orderdetails.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주말 혜택 테스트")
class WeekEndBenefitTest {
    List<Order> orders = Arrays.asList(
            new Order("티본스테이크", 1),
            new Order("바비큐립", 1),
            new Order("초코케이크", 2),
            new Order("제로콜라", 1)
    );

    @Test
    void 주말_혜택_테스트() {
        WeekEndBenefit weekEndBenefit = new WeekEndBenefit();
        weekEndBenefit.applyWeekEndBenefit(orders);
        assertEquals(4046, weekEndBenefit.getDiscountAmount());
        assertThat(weekEndBenefit.toString()).contains("주말 할인: -4,046원");
    }

    @Test
    void 평일_혜택_아닐때() {
        WeekEndBenefit weekEndBenefit = new WeekEndBenefit();
        assertEquals(0, weekEndBenefit.getDiscountAmount());
    }

}
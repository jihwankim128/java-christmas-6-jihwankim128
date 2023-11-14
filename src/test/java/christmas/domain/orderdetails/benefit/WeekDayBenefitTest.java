package christmas.domain.orderdetails.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

@DisplayName("평일 혜택 테스트")
class WeekDayBenefitTest {
    List<Order> orders = Arrays.asList(
            new Order("티본스테이크", 1),
            new Order("바비큐립", 1),
            new Order("초코케이크", 2),
            new Order("제로콜라", 1)
    );
    @Test
    void 평일_혜택_테스트() {
        WeekDayBenefit weekDayBenefit = new WeekDayBenefit();
        weekDayBenefit.applyWeekDayBenefit(orders, new Event(3));
        assertEquals(4046, weekDayBenefit.getWeekDayBenefit());
        assertThat(weekDayBenefit.toString()).contains("평일 할인: -4,046원");
    }

    @Test
    void 평일_혜택_아닐때() {
        WeekDayBenefit weekDayBenefit = new WeekDayBenefit();
        weekDayBenefit.applyWeekDayBenefit(orders, new Event(2));
        assertEquals(0, weekDayBenefit.getWeekDayBenefit());
    }
}
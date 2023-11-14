package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("총혜택 금액 테스트")
class FinalDiscountPriceTest {
    @Test
    void 혜택이_있을_경우_테스트() {
        List<Order> orders = Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        );
        Benefit benefit = new Benefit(orders, new TotalPrice(orders), new Event(3));
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(benefit);
        assertEquals(31246, totalDiscountAmount.getDiscountPrice());
        assertThat(totalDiscountAmount.toString()).contains("-31,246원");
    }

    @Test
    void 혜택이_없을_경우_테스트() {
        List<Order> orders = Arrays.asList(new Order("타파스", 1), new Order("제로콜라",1));
        Benefit benefit = new Benefit(orders, new TotalPrice(orders), new Event(26));
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount(benefit);
        assertEquals(0, totalDiscountAmount.getDiscountPrice());
        assertThat(totalDiscountAmount.toString()).contains("0원");
    }
}
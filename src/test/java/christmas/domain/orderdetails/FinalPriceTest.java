package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("할인 후 예상 결제 금액")
class FinalPriceTest {
    @Test
    void 할인이_있는_경우() {
        List<Order> orders = Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        );
        TotalPrice totalPrice = new TotalPrice(orders);
        Benefit benefit = new Benefit(orders, new TotalPrice(orders), new Event(3));
        FinalDiscountPrice finalDiscountPrice = new FinalDiscountPrice(benefit);
        FinalPrice finalPrice = new FinalPrice(totalPrice, finalDiscountPrice, new Event(3));
        assertThat(finalPrice.toString()).contains("135,754원");
    }
    @Test
    void 할인이_없는_경우() {
        List<Order> orders = Arrays.asList(new Order("타파스", 1), new Order("제로콜라",1));
        TotalPrice totalPrice = new TotalPrice(orders);
        Benefit benefit = new Benefit(orders, new TotalPrice(orders), new Event(26));
        FinalDiscountPrice finalDiscountPrice = new FinalDiscountPrice(benefit);
        FinalPrice finalPrice = new FinalPrice(totalPrice, finalDiscountPrice, new Event(26));
        assertThat(finalPrice.toString()).isEqualTo(totalPrice.toString());
    }
}
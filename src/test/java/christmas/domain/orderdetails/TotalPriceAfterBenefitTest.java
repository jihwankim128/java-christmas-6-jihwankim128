package christmas.domain.orderdetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.Event;
import christmas.domain.Order;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("할인 후 예상 결제 금액")
class TotalPriceAfterBenefitTest {
    @Test
    void 할인이_있는_경우() {
        assertThat(processor(Arrays.asList(
                        new Order("티본스테이크", 1),
                        new Order("바비큐립", 1),
                        new Order("초코케이크", 2),
                        new Order("제로콜라", 1)
                ), new Event(3)
        ).toString()).contains("135,754원");
    }

    @Test
    void 할인이_없는_경우() {
        assertThat(processor(Arrays.asList(
                        new Order("타파스", 1),
                        new Order("제로콜라", 1)
                ), new Event(26)
        ).toString()).contains("0원");
    }

    TotalPriceAfterBenefit processor(List<Order> orders, Event event) {
        TotalPriceBeforeBenefit totalPriceBeforeBenefit = new TotalPriceBeforeBenefit(orders);
        TotalPriceAfterBenefit totalPriceAfterBenefit
                = new TotalPriceAfterBenefit(totalPriceBeforeBenefit.getTotalPrice());
        GiftMenu giftMenu = new GiftMenu();
        if (event.isGiftEvent(totalPriceBeforeBenefit.getTotalPrice())) {
            giftMenu.provide();
        }
        Benefit benefit = new Benefit();
        benefit.applyBenefit(orders, totalPriceBeforeBenefit.getTotalPrice(), event);
        TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount();
        totalDiscountAmount.setDiscountAmount(benefit.totalDiscountAmount());
        totalPriceAfterBenefit.applyDiscountAmount(totalDiscountAmount.getDiscountAmount(), giftMenu.price());
        return totalPriceAfterBenefit;
    }
}
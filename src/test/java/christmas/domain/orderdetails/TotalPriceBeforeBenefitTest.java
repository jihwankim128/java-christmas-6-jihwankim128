package christmas.domain.orderdetails;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.Order;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("총주문 금액 테스트")
class TotalPriceBeforeBenefitTest {
    @Test
    void 총_주문_금액() {
        TotalPriceBeforeBenefit totalPriceBeforeBenefit = new TotalPriceBeforeBenefit(Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        ));
        assertThat(totalPriceBeforeBenefit.getTotalPrice()).isEqualTo(142000);
    }

    @Test
    void 총_주문_금액_출력() {
        TotalPriceBeforeBenefit totalPriceBeforeBenefit = new TotalPriceBeforeBenefit(Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        ));
        assertThat(totalPriceBeforeBenefit.toString()).contains("142,000원");
    }
}
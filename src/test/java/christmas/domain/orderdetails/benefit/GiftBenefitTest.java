package christmas.domain.orderdetails.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("증정 혜택 테스트")
class GiftBenefitTest {
    GiftBenefit giftBenefit = new GiftBenefit();

    @Test
    void 증정_상품_없음() {
        giftBenefit.applyGiftBenefit(new Event(1), 119999);
        assertEquals(0, giftBenefit.getGiftBenefit());
    }

    @Test
    void 증정_상품_있음() {
        giftBenefit.applyGiftBenefit(new Event(1), 120000);
        assertEquals(25000, giftBenefit.getGiftBenefit());
        assertThat(giftBenefit.toString()).contains("증정 이벤트: -25,000원");
    }
}
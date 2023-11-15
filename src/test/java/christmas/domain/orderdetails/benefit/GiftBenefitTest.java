package christmas.domain.orderdetails.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("증정 혜택 테스트")
class GiftBenefitTest {

    @Test
    void 증정_상품_없음() {
        GiftBenefit giftBenefit = new GiftBenefit();
        assertEquals(0, giftBenefit.getDiscountAmount());
    }

    @Test
    void 증정_상품_있음() {
        GiftBenefit giftBenefit = new GiftBenefit();
        giftBenefit.applyGiftBenefit();
        assertEquals(25000, giftBenefit.getDiscountAmount());
        assertThat(giftBenefit.toString()).contains("증정 이벤트: -25,000원");
    }
}
package christmas.domain.orderdetails.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("디데이 혜택 테스트")
class DDayBenefitTest {
    DDayBenefit dDayBenefit;

    @BeforeEach
    void init() {
        dDayBenefit = new DDayBenefit();
    }

    @Test
    void 디_데이_시작_혜택() {
        dDayBenefit.applyDDayBenefit(1);
        assertEquals(1000, dDayBenefit.getDiscountAmount());
        assertThat(dDayBenefit.toString()).contains("크리스마스 디데이 할인: -1,000원");
    }

    @Test
    void 디_데이_마지막_혜택() {
        dDayBenefit.applyDDayBenefit(25);
        assertEquals(3400, dDayBenefit.getDiscountAmount());
        assertThat(dDayBenefit.toString()).contains("크리스마스 디데이 할인: -3,400원");
    }

    @Disabled("Benefit 클래스에서 검증 후에 해당 도메인을 사용하므로 테스트 할 필요가 없음")
    void 디_데이_종료() {
        dDayBenefit.applyDDayBenefit(26);
        assertEquals(0, dDayBenefit.getDiscountAmount());
    }
}
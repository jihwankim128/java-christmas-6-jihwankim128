package christmas.domain.orderdetails.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("특별 혜택 테스트")
class SpecialBenefitTest {
    @ParameterizedTest
    @CsvSource({"3", "25"})
    void 특별_혜택_테스트(int day) {
        SpecialBenefit specialBenefit = new SpecialBenefit();
        specialBenefit.applySpecialBenefit(new Event(day));
        assertEquals(1000, specialBenefit.getSpecialBenefit());
        assertThat(specialBenefit.toString()).contains("특별 할인: -1,000원");
    }

    @Test
    void 특별_혜택_아닐때() {
        SpecialBenefit specialBenefit = new SpecialBenefit();
        specialBenefit.applySpecialBenefit(new Event(1));
        assertEquals(0, specialBenefit.getSpecialBenefit());
    }
}
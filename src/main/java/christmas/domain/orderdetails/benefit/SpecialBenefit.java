package christmas.domain.orderdetails.benefit;

import christmas.domain.Event;
import christmas.domain.Menu;
import java.text.NumberFormat;
import java.util.Locale;

public class SpecialBenefit {
    public static final int SPECIAL_BENEFIT_PRICE = 1000;
    private int specialBenefit;

    public SpecialBenefit() {
        this.specialBenefit = 0;
    }

    public void applySpecialBenefit(Event event) {
        if (event.isSpecialEvent()) {
            this.specialBenefit = SPECIAL_BENEFIT_PRICE;
        }
    }

    public int getSpecialBenefit() {
        return specialBenefit;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "특별 할인: "
                + formatter.format(-specialBenefit)
                + "원\n";
    }
}

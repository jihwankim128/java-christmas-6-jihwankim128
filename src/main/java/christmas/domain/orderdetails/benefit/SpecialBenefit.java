package christmas.domain.orderdetails.benefit;

import java.text.NumberFormat;
import java.util.Locale;

public class SpecialBenefit {
    public static final int SPECIAL_BENEFIT_PRICE = 1000;
    private int discountAmount = 0;

    public void applySpecialBenefit() {
        this.discountAmount = SPECIAL_BENEFIT_PRICE;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "특별 할인: "
                + formatter.format(-discountAmount)
                + "원\n";
    }
}

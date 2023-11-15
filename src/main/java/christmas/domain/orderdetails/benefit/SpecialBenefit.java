package christmas.domain.orderdetails.benefit;

import christmas.utility.Utility;
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
        return "특별 할인: "
                + Utility.numberFormatter(-discountAmount)
                + "원\n";
    }
}

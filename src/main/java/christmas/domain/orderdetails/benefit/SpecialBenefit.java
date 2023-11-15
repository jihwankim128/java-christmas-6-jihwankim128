package christmas.domain.orderdetails.benefit;

import christmas.utility.EventConstant;
import christmas.utility.OrderConstant;
import christmas.utility.Utility;
import java.text.NumberFormat;
import java.util.Locale;

public class SpecialBenefit {
    private int discountAmount = 0;

    public void applySpecialBenefit() {
        this.discountAmount = OrderConstant.SPECIAL_BENEFIT_PRICE;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        return String.format("특별 할인: %s원\n", Utility.numberFormatter(-discountAmount));
    }
}

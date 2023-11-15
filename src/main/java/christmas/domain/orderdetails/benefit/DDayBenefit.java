package christmas.domain.orderdetails.benefit;

import christmas.utility.Utility;
import java.text.NumberFormat;
import java.util.Locale;

public class DDayBenefit {
    public static final int D_DAY_BASE_BENEFIT = 1000;
    public static final int INCREASE_BASE_PER_DAY = 100;

    private int discountAmount = 0;

    public void applyDDayBenefit(int reservationDate) {
        this.discountAmount = D_DAY_BASE_BENEFIT + (reservationDate - 1) * INCREASE_BASE_PER_DAY;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        return String.format("크리스마스 디데이 할인: %s원\n", Utility.numberFormatter(-discountAmount));
    }
}

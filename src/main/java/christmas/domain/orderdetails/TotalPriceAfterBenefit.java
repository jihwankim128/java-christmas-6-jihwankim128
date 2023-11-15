package christmas.domain.orderdetails;

import christmas.utility.Utility;
import java.text.NumberFormat;
import java.util.Locale;

public class TotalPriceAfterBenefit {
    private int totalPrice;

    public TotalPriceAfterBenefit(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void applyDiscountAmount(int totalDiscountAmount, int giftMenuPrice) {
        this.totalPrice = totalPrice - totalDiscountAmount + giftMenuPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return String.format("%s 원\n", Utility.numberFormatter(totalPrice));
    }
}

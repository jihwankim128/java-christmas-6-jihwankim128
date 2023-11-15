package christmas.domain.orderdetails.benefit;

import christmas.domain.Menu;
import christmas.utility.Utility;
import java.text.NumberFormat;
import java.util.Locale;

public class GiftBenefit {
    private int discountAmount = 0;

    public void applyGiftBenefit() {
        this.discountAmount = Menu.CHAMPAGNE.getPrice();
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        return "증정 이벤트: "
                + Utility.numberFormatter(-discountAmount)
                + "원\n";
    }
}

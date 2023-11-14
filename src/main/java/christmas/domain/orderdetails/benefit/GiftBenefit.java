package christmas.domain.orderdetails.benefit;

import christmas.domain.Menu;
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
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "증정 이벤트: "
                + formatter.format(-discountAmount)
                + "원\n";
    }
}

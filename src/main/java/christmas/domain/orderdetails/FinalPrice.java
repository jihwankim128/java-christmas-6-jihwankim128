package christmas.domain.orderdetails;

import java.text.NumberFormat;
import java.util.Locale;

public class FinalPrice {
    private int totalPrice;

    public FinalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void applyDiscountAmount(int totalDiscountAmount, int giftMenuPrice) {
        this.totalPrice -= totalDiscountAmount + giftMenuPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(totalPrice) + "원\n";
    }
}

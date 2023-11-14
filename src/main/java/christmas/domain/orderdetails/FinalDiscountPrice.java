package christmas.domain.orderdetails;

import java.text.NumberFormat;
import java.util.Locale;

public class FinalDiscountPrice {
    private int discountPrice = 0;

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(-discountPrice) + "원\n";
    }
}

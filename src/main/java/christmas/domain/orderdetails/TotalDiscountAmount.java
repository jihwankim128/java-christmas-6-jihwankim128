package christmas.domain.orderdetails;

import java.text.NumberFormat;
import java.util.Locale;

public class TotalDiscountAmount {
    private int discountAmount = 0;

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(-discountAmount) + "원\n";
    }
}

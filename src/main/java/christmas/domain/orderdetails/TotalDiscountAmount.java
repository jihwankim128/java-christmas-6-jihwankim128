package christmas.domain.orderdetails;

import java.text.NumberFormat;
import java.util.Locale;

public class TotalDiscountAmount {
    private int totalDiscountAmount = 0;

    public void setTotalDiscountAmount(int totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(-totalDiscountAmount) + "원\n";
    }
}

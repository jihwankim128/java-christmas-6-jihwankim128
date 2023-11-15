package christmas.domain.orderdetails;

import christmas.utility.Utility;
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
        return Utility.numberFormatter(-discountAmount) + "원\n";
    }
}

package christmas.domain.orderdetails;

import java.text.NumberFormat;
import java.util.Locale;

public class FinalPrice {
    private int finalPrice;

    public FinalPrice(TotalPrice totalPrice, FinalDiscountPrice finalDiscountPrice) {
        this.finalPrice = totalPrice.getTotalPrice() - finalDiscountPrice.getDiscountPrice();
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(finalPrice) + "원\n";
    }
}

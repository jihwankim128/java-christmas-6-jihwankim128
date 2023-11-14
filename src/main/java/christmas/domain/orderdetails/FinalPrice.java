package christmas.domain.orderdetails;

import christmas.domain.Event;
import christmas.domain.Menu;
import java.text.NumberFormat;
import java.util.Locale;

public class FinalPrice {
    private int finalPrice;

    public FinalPrice(TotalPrice totalPrice, TotalDiscountAmount totalDiscountAmount, Event event) {
        this.finalPrice = totalPrice.getTotalPrice() - totalDiscountAmount.getDiscountPrice();
        if(event.isGiftEvent(totalPrice.getTotalPrice())) {
            this.finalPrice += Menu.CHAMPAGNE.getPrice();
        }
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

package christmas.domain.orderdetails.benefit;

import christmas.domain.Event;
import christmas.domain.Menu;
import java.text.NumberFormat;
import java.util.Locale;

public class GiftBenefit {
    private int giftBenefit;

    public GiftBenefit() {
        this.giftBenefit = 0;
    }

    public void applyGiftBenefit(Event event, int totalPrice) {
        if (event.isGiftEvent(totalPrice)) {
            this.giftBenefit = Menu.CHAMPAGNE.getPrice();
        }
    }

    public int getGiftBenefit() {
        return giftBenefit;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "증정 이벤트: "
                + formatter.format(-giftBenefit)
                + "원\n";
    }
}

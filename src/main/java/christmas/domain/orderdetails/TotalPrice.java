package christmas.domain.orderdetails;

import christmas.domain.Order;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TotalPrice {
    public static final int MINIMUM_EVENT_DISCOUNT_AMOUNT = 10000;
    private int totalPrice;

    public TotalPrice(List<Order> orders) {
        this.totalPrice = 0;
        for(Order order : orders) {
            this.totalPrice += order.getMenuPrice() * order.getQuantity();
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(totalPrice) + "원";
    }
}

package christmas.domain.orderdetails;

import christmas.domain.Order;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TotalPriceBeforeBenefit {
    private int totalPrice = 0;

    public TotalPriceBeforeBenefit(List<Order> orders) {
        for (Order order : orders) {
            this.totalPrice += order.getMenuPrice() * order.getQuantity();
        }
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

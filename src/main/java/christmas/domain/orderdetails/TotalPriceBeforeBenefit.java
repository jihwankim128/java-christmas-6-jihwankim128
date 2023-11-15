package christmas.domain.orderdetails;

import christmas.domain.Order;
import christmas.utility.Utility;
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
        return String.format("%s원\n", Utility.numberFormatter(totalPrice));
    }
}

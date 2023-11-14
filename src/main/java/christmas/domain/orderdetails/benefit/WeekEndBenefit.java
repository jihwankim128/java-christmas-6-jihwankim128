package christmas.domain.orderdetails.benefit;

import christmas.domain.Order;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class WeekEndBenefit {
    public static final int DISCOUNT_PRICE = 2023;
    private int discountAmount = 0;

    public void applyWeekEndBenefit(List<Order> orders) {
        this.discountAmount = orders.stream()
                .filter(order -> order.getMenuType().equals("메인"))
                .mapToInt(Order::getQuantity)
                .sum() * DISCOUNT_PRICE;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "주말 할인: "
                + formatter.format(-discountAmount)
                + "원\n";
    }
}

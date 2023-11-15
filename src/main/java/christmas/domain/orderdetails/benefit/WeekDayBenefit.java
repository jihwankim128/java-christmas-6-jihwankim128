package christmas.domain.orderdetails.benefit;

import christmas.domain.Order;
import christmas.utility.Utility;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class WeekDayBenefit {
    public static final int DISCOUNT_PRICE = 2023;
    private int discountAmount = 0;

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void applyWeekDayBenefit(List<Order> orders) {
        this.discountAmount = orders.stream()
                .filter(order -> order.getMenuType().equals("디저트"))
                .mapToInt(Order::getQuantity)
                .sum() * DISCOUNT_PRICE;
    }

    @Override
    public String toString() {
        return String.format("평일 할인: %s원\n", Utility.numberFormatter(-discountAmount));
    }
}

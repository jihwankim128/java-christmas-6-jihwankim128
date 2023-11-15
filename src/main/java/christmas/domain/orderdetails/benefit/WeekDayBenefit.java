package christmas.domain.orderdetails.benefit;

import christmas.domain.Order;
import christmas.utility.OrderConstant;
import christmas.utility.Utility;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class WeekDayBenefit {
    private int discountAmount = 0;

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void applyWeekDayBenefit(List<Order> orders) {
        this.discountAmount = orders.stream()
                .filter(order -> order.getMenuType().equals(OrderConstant.DESSERT))
                .mapToInt(Order::getQuantity)
                .sum() * OrderConstant.DISCOUNT_PRICE;
    }

    @Override
    public String toString() {
        return String.format("평일 할인: %s원\n", Utility.numberFormatter(-discountAmount));
    }
}

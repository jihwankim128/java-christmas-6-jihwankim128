package christmas.domain.orderdetails.benefit;

import christmas.domain.Order;
import christmas.utility.OrderConstant;
import christmas.utility.Utility;
import java.util.List;

public class WeekEndBenefit {
    private int discountAmount = 0;

    public void applyWeekEndBenefit(List<Order> orders) {
        this.discountAmount = orders.stream()
                .filter(order -> order.getMenuType().equals(OrderConstant.MAIN))
                .mapToInt(Order::getQuantity)
                .sum() * OrderConstant.DISCOUNT_PRICE;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        return String.format("주말 할인: %s원\n", Utility.numberFormatter(-discountAmount));
    }
}

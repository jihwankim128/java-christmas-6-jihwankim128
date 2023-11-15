package christmas.domain;

import christmas.domain.orderdetails.Benefit;
import christmas.domain.orderdetails.EventBadge;
import christmas.domain.orderdetails.TotalDiscountAmount;
import christmas.domain.orderdetails.TotalPriceAfterBenefit;
import christmas.domain.orderdetails.GiftMenu;
import christmas.domain.orderdetails.Orders;
import christmas.domain.orderdetails.TotalPriceBeforeBenefit;
import java.util.List;

public class OrderDetails {
    private final Orders orders;
    private final TotalPriceBeforeBenefit totalPriceBeforeBenefit;
    private final TotalPriceAfterBenefit totalPriceAfterBenefit;
    private final GiftMenu giftMenu = new GiftMenu();
    private final Benefit benefit = new Benefit();
    private final TotalDiscountAmount totalDiscountAmount = new TotalDiscountAmount();

    public OrderDetails(List<Order> orders) {
        this.orders = new Orders(orders);
        this.totalPriceBeforeBenefit = new TotalPriceBeforeBenefit(orders);
        this.totalPriceAfterBenefit = new TotalPriceAfterBenefit(totalPriceBeforeBenefit.getTotalPrice());
    }

    public void provideGift(Event event) {
        if(event.isGiftEvent(totalPriceBeforeBenefit.getTotalPrice())) {
            this.giftMenu.provide();
        }
    }

    public void applyBenefit(Event event) {
        this.benefit.applyBenefit(orders.getOrders(), totalPriceBeforeBenefit.getTotalPrice(), event);
        this.totalDiscountAmount.setDiscountAmount(benefit.totalDiscountAmount());
        this.totalPriceAfterBenefit.applyDiscountAmount(totalDiscountAmount.getDiscountAmount(), giftMenu.price());
    }

    public Orders getOrders() {
        return orders;
    }

    public TotalPriceBeforeBenefit getTotalPriceBeforeBenefit() {
        return totalPriceBeforeBenefit;
    }

    public TotalPriceAfterBenefit getTotalPriceAfterBenefit() {
        return totalPriceAfterBenefit;
    }

    public GiftMenu getGiftMenu() {
        return giftMenu;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public TotalDiscountAmount getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public EventBadge getBadge() {
        return EventBadge.getBadge(totalDiscountAmount.getDiscountAmount());
    }
}

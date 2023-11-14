package christmas.domain;

import christmas.domain.orderdetails.Benefit;
import christmas.domain.orderdetails.EventBadge;
import christmas.domain.orderdetails.FinalDiscountPrice;
import christmas.domain.orderdetails.FinalPrice;
import christmas.domain.orderdetails.GiftMenu;
import christmas.domain.orderdetails.Orders;
import christmas.domain.orderdetails.TotalPrice;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class OrderDetails {
    private Orders orders;
    private TotalPrice totalPrice;
    private GiftMenu giftMenu;
    private Benefit benefit;
    private FinalDiscountPrice finalDiscountPrice;
    private FinalPrice finalPrice;
    private EventBadge badge;

    OrderDetails(List<Order> orders, Event event) {
        initOrderDetails(orders, event);
    }

    private void initOrderDetails(List<Order> orders, Event event) {
        this.orders = new Orders(orders);
        this.totalPrice = new TotalPrice(orders);
        this.giftMenu = new GiftMenu(totalPrice, event);
        this.benefit = new Benefit(orders, totalPrice, event);
        this.finalDiscountPrice = new FinalDiscountPrice(benefit);
        this.finalPrice = new FinalPrice(totalPrice, finalDiscountPrice, event);
        this.badge = EventBadge.getBadge(finalDiscountPrice.getDiscountPrice());
    }

    public Orders getOrders() {
        return orders;
    }

    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    public GiftMenu getGiftMenu() {
        return giftMenu;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public FinalDiscountPrice getFinalDiscountPrice() {
        return finalDiscountPrice;
    }

    public FinalPrice getFinalPrice() {
        return finalPrice;
    }

    public EventBadge getBadge() {
        return badge;
    }
}

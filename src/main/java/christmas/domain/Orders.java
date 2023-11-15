package christmas.domain;

import christmas.utility.IllegalArgumentMessage;
import christmas.utility.OrderConstant;
import java.util.Collections;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateMaxOrderQuantity(orders);
        validateIsOnlyDrink(orders);
        validateDuplication(orders);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    private void validateMaxOrderQuantity(List<Order> orders) {
        if (orders.stream().mapToInt(Order::getQuantity).sum() > OrderConstant.MAX_ORDER_QUANTITY) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    private void validateDuplication(List<Order> orders) {
        if (orders.stream().map(Order::getMenu).distinct().count() != orders.size()) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    private void validateIsOnlyDrink(List<Order> orders) {
        if (isOnlyDrink(orders)) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    private boolean isOnlyDrink(List<Order> orders) {
        return orders.stream()
                .allMatch(order -> order.getMenuType().equals(OrderConstant.DRINK));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orders) {
            stringBuilder.append(order.toString());
        }
        return stringBuilder.toString();
    }
}

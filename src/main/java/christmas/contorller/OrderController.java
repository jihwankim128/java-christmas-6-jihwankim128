package christmas.contorller;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.utility.IllegalArgumentMessage;
import christmas.utility.InputDataException;
import christmas.utility.Utility;
import christmas.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private final InputView inputView;
    private Orders orders;

    public OrderController(InputView inputView) {
        this.inputView = inputView;
    }

    public void ordersRegister() {
        while(this.orders == null) {
            try {
                List<String> orderMenus = Utility.splitUtility(inputView.orderMenusInput(), ",");
                this.orders = parseOrders(orderMenus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Orders parseOrders(List<String> orderMenus) {
        List<Order> ordersTemp = new ArrayList<>();
        for (String orderMenu: orderMenus) {
            List<String> menuNameAndQuantity = Utility.splitUtility(orderMenu, "-");
            InputDataException.validateInputSize(menuNameAndQuantity.size());
            InputDataException.validateInteger(menuNameAndQuantity.get(1), IllegalArgumentMessage.INVALID_ORDER);
            ordersTemp.add(parseOrder(menuNameAndQuantity));
        }
        return new Orders(ordersTemp);
    }

    private Order parseOrder(List<String> menuNameAndQuantity) {
        String menuName = menuNameAndQuantity.get(0);
        int menuQuantity = Integer.valueOf(menuNameAndQuantity.get(1));

        return new Order(menuName, menuQuantity);
    }

    public Orders getOrders() {
        return orders;
    }
}

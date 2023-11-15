package christmas;

import christmas.contorller.EventController;
import christmas.contorller.OrderController;
import christmas.contorller.OrderDetailsController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final EventController eventController = new EventController(inputView);
    private static final OrderController orderController = new OrderController(inputView);

    public static void main(String[] args) {
        outputView.eventGreetingPrint();
        eventController.eventRegister();

        orderController.ordersRegister();
        outputView.eventNoticePrint(eventController.getReservationDate());

        OrderDetailsController orderDetailsController
                = new OrderDetailsController(outputView, eventController, orderController);

        orderDetailsController.orderDetailsRegister();
        orderDetailsController.orderDetailsPrint();
    }
}

package christmas;

import christmas.contorller.EventController;
import christmas.contorller.OrderController;
import christmas.contorller.OrderDetailsController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        EventController eventController = new EventController(inputView);
        OrderController orderController = new OrderController(inputView);

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

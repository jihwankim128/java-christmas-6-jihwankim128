package christmas;

import christmas.contorller.EventController;
import christmas.contorller.OrderController;
import christmas.contorller.OrderDetailsController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final EventController eventController = new EventController(inputView);
        final OrderController orderController = new OrderController(inputView);
        reservationRegister(inputView, outputView, eventController, orderController);

        final OrderDetailsController orderDetailsController
                = new OrderDetailsController(outputView, eventController, orderController);
        orderDetailsController.orderDetailsRegister();
        orderDetailsController.orderDetailsPrint();
    }

    private static void reservationRegister(
            InputView inputView,
            OutputView outputView,
            EventController eventController,
            OrderController orderController
    ) {
        outputView.eventGreetingPrint();
        eventController.eventRegister();

        orderController.ordersRegister();
        outputView.eventNoticePrint(eventController.getReservationDate());
    }
}

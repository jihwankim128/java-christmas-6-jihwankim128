package christmas.contorller;

import christmas.domain.OrderDetails;
import christmas.view.OutputView;

public class OrderDetailsController {
    private final OutputView outputView;
    private final EventController eventController;
    private final OrderController orderController;
    private final OrderDetails orderDetails;

    public OrderDetailsController(
            OutputView outputView,
            EventController eventController,
            OrderController orderController
    ) {
        this.outputView = outputView;
        this.eventController = eventController;
        this.orderController = orderController;
        this.orderDetails = new OrderDetails(this.orderController.getOrders());
    }

    public void orderDetailsRegister() {
        orderDetails.provideGift(eventController.getEvent());
        orderDetails.applyBenefit(eventController.getEvent());
    }

    public void orderDetailsPrint() {
        outputView.orderMenusPrint(orderDetails.getOrders().toString());
        outputView.totalPriceBeforeBenefitPrint(orderDetails.getTotalPriceBeforeBenefit().toString());
        outputView.giftMenuPrint(orderDetails.getGiftMenu().toString());
        outputView.benefitPrint(orderDetails.getBenefit().toString());
        outputView.totalDiscountAmountPrint(orderDetails.getTotalDiscountAmount().toString());
        outputView.totalPriceAfterBenefitPrint(orderDetails.getTotalPriceAfterBenefit().toString());
        outputView.eventBadgePrint(orderDetails.getBadge().toString());
    }
}

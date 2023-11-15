package christmas.view;

public class OutputView {
    public void eventGreetingPrint() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void eventNoticePrint(int reservationDate) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n", reservationDate);
    }

    public void orderMenusPrint(String orderMenus) {
        System.out.println("<주문 메뉴>");
        System.out.println(orderMenus);
    }

    public void totalPriceBeforeBenefitPrint(String totalPriceBeforeBenefit) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPriceBeforeBenefit);
    }

    public void giftMenuPrint(String giftMenu) {
        System.out.println("<증정 메뉴>");
        System.out.println(giftMenu);
    }

    public void benefitPrint(String benefit) {
        System.out.println("<혜택 내역>");
        System.out.println(benefit);
    }

    public void totalDiscountAmountPrint(String totalDiscountAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println(totalDiscountAmount);
    }

    public void totalPriceAfterBenefitPrint(String totalPriceAfterBenefit) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(totalPriceAfterBenefit);
    }

    public void eventBadgePrint(String eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }
}

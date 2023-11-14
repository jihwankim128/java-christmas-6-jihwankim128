package christmas.domain.orderdetails;

import christmas.domain.Event;
import christmas.domain.Order;
import christmas.domain.orderdetails.benefit.DDayBenefit;
import christmas.domain.orderdetails.benefit.GiftBenefit;
import christmas.domain.orderdetails.benefit.SpecialBenefit;
import christmas.domain.orderdetails.benefit.WeekDayBenefit;
import christmas.domain.orderdetails.benefit.WeekEndBenefit;
import java.util.ArrayList;
import java.util.List;

public class Benefit {
    public static final int MINIMUM_EVENT_DISCOUNT_AMOUNT = 10000;

    private final List<String> appliedBenefits = new ArrayList<>();
    private final DDayBenefit dDayBenefit = new DDayBenefit();
    private final WeekDayBenefit weekDayBenefit = new WeekDayBenefit();
    private final WeekEndBenefit weekEndBenefit = new WeekEndBenefit();
    private final SpecialBenefit specialBenefit = new SpecialBenefit();
    private final GiftBenefit giftBenefit = new GiftBenefit();

    public void applyBenefit(List<Order> orders, TotalPrice totalPrice, Event event) {
        if(totalPrice.getTotalPrice() >= MINIMUM_EVENT_DISCOUNT_AMOUNT) {
            applyDDayBenefit(event);
            applyWeekDayBenefit(orders, event);
            applyWeekEndBenefit(orders, event);
            applySpecialBenefit(event);
            applyGiftBenefit(totalPrice.getTotalPrice(), event);
        }
    }

    private void applyDDayBenefit(Event event) {
        if(event.isDDayEvent()) {
            dDayBenefit.applyDDayBenefit(event.getReservationDate());
            this.appliedBenefits.add(dDayBenefit.toString());
        }
    }

    private void applyWeekDayBenefit(List<Order> orders, Event event) {
        if(event.isWeekDayEvent()) {
            weekDayBenefit.applyWeekDayBenefit(orders);
            this.appliedBenefits.add(weekDayBenefit.toString());
        }
    }

    private void applyWeekEndBenefit(List<Order> orders, Event event) {
        if(event.isWeekEndEvent()) {
            weekEndBenefit.applyWeekEndBenefit(orders);
            this.appliedBenefits.add(weekEndBenefit.toString());
        }
    }

    private void applySpecialBenefit(Event event) {
        if(event.isSpecialEvent()) {
            specialBenefit.applySpecialBenefit();
            this.appliedBenefits.add(specialBenefit.toString());
        }
    }

    private void applyGiftBenefit(int totalPrice, Event event) {
        if(event.isGiftEvent(totalPrice)) {
            giftBenefit.applyGiftBenefit();
            this.appliedBenefits.add(giftBenefit.toString());
        }
    }

    public int getDDayBenefit() {
        return dDayBenefit.getDDayBenefit();
    }

    public int getWeekDayBenefit() {
        return weekDayBenefit.getWeekDayBenefit();
    }

    public int getWeekEndBenefit() {
        return weekEndBenefit.getWeekEndBenefit();
    }

    public int getSpecialBenefit() {
        return specialBenefit.getSpecialBenefit();
    }

    public int getGiftBenefit() {
        return giftBenefit.getGiftBenefit();
    }

    @Override
    public String toString() {
        if(appliedBenefits.isEmpty()) {
            return "없음\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(String benefit: appliedBenefits) {
            stringBuilder.append(benefit);
        }
        return stringBuilder.toString();
    }
}
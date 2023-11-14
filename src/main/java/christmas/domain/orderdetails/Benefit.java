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

    private final List<Order> orders;
    private final int totalPrice;
    private final Event event;

    private List<String> appliedBenefits;
    private DDayBenefit dDayBenefit = new DDayBenefit();
    private WeekDayBenefit weekDayBenefit = new WeekDayBenefit();
    private WeekEndBenefit weekEndBenefit = new WeekEndBenefit();
    private SpecialBenefit specialBenefit = new SpecialBenefit();
    private GiftBenefit giftBenefit = new GiftBenefit();

    public Benefit(List<Order> orders, TotalPrice totalPrice, Event event) {
        this.orders = orders;
        this.totalPrice = totalPrice.getTotalPrice();
        this.event = event;
        this.appliedBenefits = new ArrayList<>();
        applyBenefit();
    }

    private void applyBenefit() {
        if(totalPrice >= MINIMUM_EVENT_DISCOUNT_AMOUNT) {
            dDayBenefit.applyDDayBenefit(event);
            weekDayBenefit.applyWeekDayBenefit(orders, event);
            weekEndBenefit.applyWeekEndBenefit(orders, event);
            specialBenefit.applySpecialBenefit(event);
            giftBenefit.applyGiftBenefit(event, totalPrice);
            getAppliedBenefits();
        }
    }

    private void getAppliedBenefits() {
        addAppliedDDayBenefit();
        addAppliedWeekDayBenefit();
        addAppliedWeekEndBenefit();
        addAppliedSpecialBenefit();
        addAppliedGiftBenefit();
    }

    private void addAppliedDDayBenefit() {
        if(event.isDDayEvent()) {
            this.appliedBenefits.add(dDayBenefit.toString());
        }
    }

    private void addAppliedWeekDayBenefit() {
        if(event.isWeekDayEvent()) {
            this.appliedBenefits.add(weekDayBenefit.toString());
        }
    }

    private void addAppliedWeekEndBenefit() {
        if(event.isWeekEndEvent()) {
            this.appliedBenefits.add(weekEndBenefit.toString());
        }
    }

    private void addAppliedSpecialBenefit() {
        if(event.isSpecialEvent()) {
            this.appliedBenefits.add(specialBenefit.toString());
        }
    }

    private void addAppliedGiftBenefit() {
        if(event.isGiftEvent(totalPrice)) {
            this.appliedBenefits.add(giftBenefit.toString());
        }
    }

    public int getdDayBenefit() {
        return dDayBenefit.getdDayBenefit();
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

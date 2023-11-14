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

    public Benefit(List<Order> orders, int totalPrice, Event event) {
        this.orders = orders;
        this.totalPrice = totalPrice;
        this.event = event;
        this.appliedBenefits = new ArrayList<>();
        applyBenefit();
        getAppliedBenefits();
    }

    private void applyBenefit() {
        if(totalPrice >= MINIMUM_EVENT_DISCOUNT_AMOUNT) {
            dDayBenefit.applyDDayBenefit(event);
            weekDayBenefit.applyWeekDayBenefit(orders, event);
            weekEndBenefit.applyWeekEndBenefit(orders, event);
            specialBenefit.applySpecialBenefit(event);
            giftBenefit.applyGiftBenefit(event, totalPrice);
        }
    }

    private void getAppliedBenefits() {
        addAppliedDDayBenefit();
        addAppliedWeekDayBenefit();
        addWeekEndBenefit();
        addSpecialBenefit();
        addGiftBenefit();
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

    private void addWeekEndBenefit() {
        if(event.isWeekEndEvent()) {
            this.appliedBenefits.add(weekEndBenefit.toString());
        }
    }

    private void addSpecialBenefit() {
        if(event.isSpecialEvent()) {
            this.appliedBenefits.add(specialBenefit.toString());
        }
    }

    private void addGiftBenefit() {
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
        StringBuilder stringBuilder = new StringBuilder();
        for(String benefit: appliedBenefits) {
            stringBuilder.append(benefit);
        }
        return stringBuilder.toString();
    }
}

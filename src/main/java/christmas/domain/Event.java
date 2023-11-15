package christmas.domain;

import christmas.utility.EventConstant;
import christmas.utility.IllegalArgumentMessage;

public class Event {
    private final int reservationDate;
    private final int dayOfWeek;

    public Event(int reservationDate) {
        validate(reservationDate);
        this.reservationDate = reservationDate;
        this.dayOfWeek = reservationDate % EventConstant.DAYS_IN_WEEK;
    }

    private void validate(int reservationDate) {
        if (reservationDate < EventConstant.EVENT_START_DATE || reservationDate > EventConstant.EVENT_END_DATE) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_DATE);
        }
    }

    public boolean isDDayEvent() {
        return reservationDate <= EventConstant.CHRISTMAS_DATE;
    }

    public boolean isWeekDayEvent() {
        return (dayOfWeek != EventConstant.FRIDAY) && (dayOfWeek != EventConstant.SATURDAY);
    }

    public boolean isWeekEndEvent() {
        return (dayOfWeek == EventConstant.FRIDAY) || (dayOfWeek == EventConstant.SATURDAY);
    }

    public boolean isSpecialEvent() {
        return (dayOfWeek == EventConstant.SUNDAY) || (reservationDate == EventConstant.CHRISTMAS_DATE);
    }

    public boolean isGiftEvent(int totalPrice) {
        return totalPrice >= EventConstant.GIFT_EVENT_MINIMUM_PAYMENT;
    }

    public int getReservationDate() {
        return reservationDate;
    }
}

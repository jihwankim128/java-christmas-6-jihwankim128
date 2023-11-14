package christmas.domain;

import christmas.utility.IllegalArgumentMessage;

public class Event {
    public static final int GIFT_EVENT_MINIMUM_PAYMENT = 120000;
    public static final int EVENT_START_DATE = 1;
    public static final int EVENT_END_DATE = 31;
    public static final int CHRISTMAS_DATE = 25;
    public static final int DAYS_IN_WEEK = 7;
    public static final int FRIDAY = 1;
    public static final int SATURDAY = 2;
    public static final int SUNDAY = 3;
    private final int reservationDate;
    private final int dayOfWeek;

    public Event(int reservationDate) {
        validate(reservationDate);
        this.reservationDate = reservationDate;
        this.dayOfWeek = reservationDate % DAYS_IN_WEEK;
    }

    private void validate(int reservationDate) {
        if(reservationDate < EVENT_START_DATE || reservationDate > EVENT_END_DATE) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_DATE);
        }
    }

    public boolean isDDayEvent() {
        return reservationDate <= CHRISTMAS_DATE;
    }

    public boolean isWeekDayEvent() {
        return (dayOfWeek != FRIDAY) && (dayOfWeek != SATURDAY);
    }

    public boolean isWeekEndEvent() {
        return (dayOfWeek == FRIDAY) || (dayOfWeek == SATURDAY);
    }

    public boolean isSpecialEvent() {
        return (dayOfWeek == SUNDAY) || (reservationDate == CHRISTMAS_DATE);
    }

    public boolean isGiftEvent(int totalPrice) {
        return totalPrice >= GIFT_EVENT_MINIMUM_PAYMENT;
    }

    public int getReservationDate() {
        return reservationDate;
    }
}

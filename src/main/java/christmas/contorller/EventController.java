package christmas.contorller;

import christmas.domain.Event;
import christmas.utility.IllegalArgumentMessage;
import christmas.utility.InputDataException;
import christmas.view.InputView;

public class EventController {
    private Event event = null;
    private final InputView inputView;

    public EventController(InputView inputView) {
        this.inputView = inputView;
    }

    public void eventRegister() {
        while (this.event == null) {
            try {
                this.event = new Event(parseReservationDate(inputView.reservastionDateInput()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseReservationDate(String reservationDate) {
        InputDataException.validateInteger(reservationDate, IllegalArgumentMessage.INVALID_DATE);
        return Integer.valueOf(reservationDate);
    }

    public Event getEvent() {
        return event;
    }

    public int getReservationDate() {
        return event.getReservationDate();
    }
}

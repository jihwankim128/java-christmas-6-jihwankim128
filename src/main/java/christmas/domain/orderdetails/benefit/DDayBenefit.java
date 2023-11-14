package christmas.domain.orderdetails.benefit;

import christmas.domain.Event;
import java.text.NumberFormat;
import java.util.Locale;

public class DDayBenefit {
    public static final int D_DAY_BASE_BENEFIT = 1000;
    public static final int INCREASE_BASE_PER_DAY = 100;

    private int dDayBenefit;

    public DDayBenefit() {
        this.dDayBenefit = 0;
    }

    public void applyDDayBenefit(Event event) {
        if (event.isDDayEvent()) {
            this.dDayBenefit = D_DAY_BASE_BENEFIT + (event.getReservationDate() - 1) * INCREASE_BASE_PER_DAY;
        }
    }

    public int getdDayBenefit() {
        return dDayBenefit;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return "크리스마스 디데이 할인: "
                + formatter.format(-dDayBenefit)
                + "원\n";
    }
}

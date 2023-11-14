package christmas.domain.orderdetails.benefit;

import java.text.NumberFormat;
import java.util.Locale;

public class DDayBenefit {
    public static final int D_DAY_BASE_BENEFIT = 1000;
    public static final int INCREASE_BASE_PER_DAY = 100;

    private int dDayBenefit = 0;

    public void applyDDayBenefit(int reservationDate) {
        this.dDayBenefit = D_DAY_BASE_BENEFIT + (reservationDate - 1) * INCREASE_BASE_PER_DAY;
    }

    public int getDDayBenefit() {
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

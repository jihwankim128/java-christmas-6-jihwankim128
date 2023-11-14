package christmas.domain.orderdetails;

import java.text.NumberFormat;
import java.util.Locale;

public class FinalDiscountPrice {
    private int discountPrice;

    public FinalDiscountPrice(Benefit benefit) {
        this.discountPrice = 0;
        calculateAppliedBenefits(benefit);
    }

    private void calculateAppliedBenefits(Benefit benefit) {
        this.discountPrice += benefit.getdDayBenefit();
        this.discountPrice += benefit.getWeekDayBenefit();
        this.discountPrice += benefit.getWeekEndBenefit();
        this.discountPrice += benefit.getSpecialBenefit();
        this.discountPrice += benefit.getGiftBenefit();
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(-discountPrice) + "원\n";
    }
}

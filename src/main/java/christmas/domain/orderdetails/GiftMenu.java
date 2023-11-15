package christmas.domain.orderdetails;

import christmas.domain.Event;
import christmas.domain.Menu;

public class GiftMenu {
    private Menu giftMenu = Menu.ETC;

    public void provide() {
        this.giftMenu = Menu.CHAMPAGNE;
    }

    public int price() {
        return giftMenu.getPrice();
    }

    @Override
    public String toString() {
        if (giftMenu.equals(Menu.ETC)) {
            return giftMenu.getName() + "\n";
        }
        return giftMenu.getName() + " 1개\n";
    }
}

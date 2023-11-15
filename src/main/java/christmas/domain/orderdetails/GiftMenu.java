package christmas.domain.orderdetails;

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
            return String.format("%s\n", giftMenu.getName());
        }
        return String.format("%s 1개\n", giftMenu.getName());
    }
}

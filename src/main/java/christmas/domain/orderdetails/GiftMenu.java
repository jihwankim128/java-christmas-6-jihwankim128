package christmas.domain.orderdetails;

import christmas.domain.Event;
import christmas.domain.Menu;

public class GiftMenu {
    private Menu giftMenu;

    public GiftMenu(int totalPrice, Event event) {
        this.giftMenu =  Menu.ETC;
        if(event.isGiftEvent(totalPrice)) {
            this.giftMenu = Menu.CHAMPAGNE;
        }
    }

    @Override
    public String toString() {
        if(giftMenu.equals(Menu.ETC)) {
            return giftMenu.getName() + "\n";
        }
        return giftMenu.getName() + " 1개\n";
    }
}

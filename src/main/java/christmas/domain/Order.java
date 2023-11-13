package christmas.domain;

import christmas.utility.IllegalArgumentMessage;

public class Order {
    private final Menu menu;
    private final int quantity;
    private final int reservationDate;
    public Order(String menuName, int quantity, int reservationDate) {
        this.menu = Menu.getMenu(menuName);
        validate(quantity);
        this.quantity = quantity;
        this.reservationDate = reservationDate;
    }

    private void validate(int quantity) {
        final int minimumQuantity = 1;
        if(menu.equals(Menu.ETC)) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
        if(quantity < minimumQuantity) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public String getFoodName() {
        return menu.getName();
    }

    public String getFoodType() {
        return menu.getType();
    }

    public int getFoodPrice() {
        return menu.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReservationDate() {
        return reservationDate;
    }
}

package christmas.domain;

import christmas.utility.IllegalArgumentMessage;

public class Order {
    public static final int MINIMUM_QUANTITY = 1;
    private final Menu menu;
    private final int quantity;

    public Order(String menuName, int quantity) {
        validateHasMenu(menuName);
        validateQuantity(quantity);
        this.menu = Menu.getMenu(menuName);
        this.quantity = quantity;
    }

    private void validateHasMenu(String menuName) {
        if (Menu.getMenu(menuName).equals(Menu.ETC)) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public String getMenuType() {
        return menu.getType();
    }

    public int getMenuPrice() {
        return menu.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %d개\n", getMenuName(), getQuantity());
    }
}

package christmas.domain;

import christmas.utility.IllegalArgumentMessage;

public class Order {
    Menu foodMenu;
    public Order(String foodMenu) {
        this.foodMenu = Menu.getMenu(foodMenu);
        validate();
    }

    private void validate() {
        if(foodMenu.equals(Menu.ETC)) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    public Menu getFoodMenu() {
        return foodMenu;
    }

    public String getFoodName() {
        return foodMenu.getName();
    }

    public String getFoodType() {
        return foodMenu.getType();
    }

    public int getFoodPrice() {
        return foodMenu.getPrice();
    }
}

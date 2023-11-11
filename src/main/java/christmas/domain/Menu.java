package christmas.domain;

import christmas.utility.IllegalArgumentMessage;

public class Menu {
    FoodMenus foodMenu;
    public Menu(String foodMenu) {
        this.foodMenu = FoodMenus.getMenu(foodMenu);
        validate();
    }

    private void validate() {
        if(foodMenu.equals(FoodMenus.ETC)) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    public FoodMenus getFoodMenu() {
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

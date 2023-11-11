package christmas.domain;

public class Menu {
    FoodMenus foodMenu;
    public Menu(String foodMenu) {
        this.foodMenu = FoodMenus.getMenu(foodMenu);
        validate();
    }

    void validate() {
        if(foodMenu.getName().equals("ERROR")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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

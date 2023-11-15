package christmas.domain;

import christmas.utility.OrderConstant;
import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", OrderConstant.APPETIZER, 6_000),
    TAPAS("타파스", OrderConstant.APPETIZER, 5_500),
    CAESAR_SALAD("시저샐러드", OrderConstant.APPETIZER, 8_000),

    T_BONE("티본스테이크", OrderConstant.MAIN, 55_000),
    BBQ_RIBS("바비큐립", OrderConstant.MAIN, 54_000),
    SEAFOOD_PASTA("해산물파스타", OrderConstant.MAIN, 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", OrderConstant.MAIN, 25_000),

    CHOCO_CAKE("초코케이크", OrderConstant.DESSERT, 15_000),
    ICE_CREAM("아이스크림", OrderConstant.DESSERT, 5_000),

    ZERO_COKE("제로콜라", OrderConstant.DRINK, 3_000),
    RED_WINE("레드와인", OrderConstant.DRINK, 60_000),
    CHAMPAGNE("샴페인", OrderConstant.DRINK, 25_000),

    ETC("없음", "없음", 0);

    private final String name;
    private final String type;
    private final int price;

    Menu(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public static Menu getMenu(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(menuName))
                .findFirst()
                .orElse(ETC);
    }
}

package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.utility.IllegalArgumentMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("음식 메뉴의 정보가 제대로 저장되었는지 확인하는 테스트")
class OrderTest {
    Order order;

    @ParameterizedTest
    @CsvSource({
            "양송이수프,애피타이저,6000,4,20",
            "타파스,애피타이저,5500,2,20",
            "시저샐러드,애피타이저,8000,1,20"
    })
    void 애피타이저_메뉴_테스트(String menuName, String menuType, int menuPrice, int quantity, int reservationDate) {
        order = new Order(menuName, quantity, reservationDate);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({
            "티본스테이크,메인,55000,4,20",
            "바비큐립,메인,54000,2,20",
            "해산물파스타,메인,35000,1,20",
            "크리스마스파스타,메인,25_000,5,15"
    })
    void 메인_메뉴_테스트(String menuName, String menuType, int menuPrice, int quantity, int reservationDate) {
        order = new Order(menuName, quantity, reservationDate);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({"초코케이크,디저트,15000,4,20", "아이스크림,디저트,5000,2,20"})
    void 디저트_메뉴_테스트(String menuName, String menuType, int menuPrice, int quantity, int reservationDate) {
        order = new Order(menuName, quantity, reservationDate);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({
            "제로콜라,음료,3000,10,10,4,20",
            "레드와인,음료,60000,5,5,2,20",
            "샴페인,음료,25000,4,4,1,20"})
    void 음료_메뉴_테스트(String menuName, String menuType, int menuPrice, int quantity, int reservationDate) {
        order = new Order(menuName, quantity, reservationDate);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({"포비,메인,100,4,20", "오리,디저트,0,2,20", "x,x,0,1,20"})
    void 없는_메뉴_테스트(String menuName, String menuType, int menuPrice, int quantity, int reservationDate) {
        assertThatThrownBy(()-> new Order(menuName, quantity, reservationDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentMessage.INVALID_ORDER);
    }

    @Test
    void 최소_수량_테스트() {
        final String menuName = "제로콜라";
        final int quantity = 0;
        final int reservationDate = 10;
        assertThatThrownBy(()-> new Order(menuName, quantity, reservationDate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentMessage.INVALID_ORDER);
    }

    void assertEqualResult(String menuName, String menuType, int menuPrice) {
        assertEquals(menuName, order.getFoodName());
        assertEquals(menuType, order.getFoodType());
        assertEquals(menuPrice, order.getFoodPrice());
    }
}
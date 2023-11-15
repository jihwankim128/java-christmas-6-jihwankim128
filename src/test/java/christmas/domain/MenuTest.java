package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("메뉴 리스트 테스트")
class MenuTest {
    Menu menu;

    @ParameterizedTest
    @CsvSource({"양송이수프,애피타이저,6000", "타파스,애피타이저,5500", "시저샐러드,애피타이저,8000"})
    void 애피타이저_메뉴_테스트(String menuName, String menuType, int menuPrice) {
        menu = Menu.getMenu(menuName);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({"티본스테이크,메인,55000", "바비큐립,메인,54000", "해산물파스타,메인,35000", "크리스마스파스타,메인,25_000"})
    void 메인_메뉴_테스트(String menuName, String menuType, int menuPrice) {
        menu = Menu.getMenu(menuName);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({"초코케이크,디저트,15000", "아이스크림,디저트,5000"})
    void 디저트_메뉴_테스트(String menuName, String menuType, int menuPrice) {
        menu = Menu.getMenu(menuName);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({"제로콜라,음료,3000", "레드와인,음료,60000", "샴페인,음료,25000"})
    void 음료_메뉴_테스트(String menuName, String menuType, int menuPrice) {
        menu = Menu.getMenu(menuName);
        assertEqualResult(menuName, menuType, menuPrice);
    }

    @ParameterizedTest
    @CsvSource({"포비,메인,100", "오리,디저트,0", "x,x,0"})
    void 없는_메뉴_테스트(String menuName, String menuType, int menuPrice) {
        menu = Menu.getMenu(menuName);
        assertTrue(menu.equals(Menu.ETC));
    }

    void assertEqualResult(String menuName, String menuType, int menuPrice) {
        assertEquals(menuName, menu.getName());
        assertEquals(menuType, menu.getType());
        assertEquals(menuPrice, menu.getPrice());
    }
}
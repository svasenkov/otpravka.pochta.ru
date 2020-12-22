package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PochtaTests extends TestBase {

    @Test
    @DisplayName("Корректное открыте главной страницы")
    void mainPageTest() {
        open("https://otpravka.pochta.ru/");

        $(".inline-helper--title").shouldHave(text("Отправка писем и посылок"));
    }

    @Test
    @Disabled("Нужны учетные данные")
    @DisplayName("Успешная авторизация")
    void successfulLoginTest() {
        open("https://otpravka.pochta.ru/");
        // todo
    }

    @Test
    @DisplayName("Неуспешная авторизация")
    void unSuccessfulLoginTest() {
        open("https://otpravka.pochta.ru/");
        $("#enter-link").click();

        $("#username").val("123123123");
        $("#userpassword").val("123123123").pressEnter();

        $("body").shouldHave(text("Неверное имя пользователя или пароль"));
    }

    @Test
    @DisplayName("Проверка работы калькулятора")
    void calculatorTest() {
        open("https://otpravka.pochta.ru/calculator");

        $("#placeFrom").val("Москва");
        $("#placeTo").val("Томск").pressEnter();
        $(byText("обл Томская, Томск")).click();
        $("#mass").val("3").pressEnter();
        $(byText("3 кг")).click();
        $(byText("Подобрать тариф")).scrollTo().click();

        $("#calculatorResultTable tbody .calc-table__price").shouldHave(text("419,0"));
    }


}

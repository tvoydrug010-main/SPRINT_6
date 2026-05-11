package org.example.tests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTests extends BaseTests {
    private void completeOrder(String name, String surName, String address, String stationMetro,
                               String phone, String date, String rentalPeriod, String color) {
        // Заполняем форму "Для кого самокат"
        homePage.setName(name);
        homePage.setSurName(surName);
        homePage.setInputAddress(address);
        homePage.selectInputStationMetro(stationMetro);
        homePage.setInputTelNumber(phone);
        homePage.clickButtonNext();

        // Заполняем форму "Про аренду"
        rentalPage.setDate(date);
        rentalPage.selectRentalPeriod(rentalPeriod);
        rentalPage.selectColor(color);
        rentalPage.clickOrderButton();
        rentalPage.clickButtonYes();
    }

    @ParameterizedTest
    @CsvSource({
            "Иван, Петров, 'ул. Ленина, 10', Черкизовская, 89991234567, 01.01.2025, трое суток, black",
            "Анна, Смирнова, 'ул. Пушкина, 5', Бульвар Рокоссовского, 89999876543, 05.02.2025, пятеро суток, grey"
    })

    public void orderHeaderTest(String name, String surName, String address, String stationMetro,
                                String phone, String date, String rentalPeriod, String color) {
        homePage.clickButtonOrderHeader();
        completeOrder(name, surName, address, stationMetro, phone, date, rentalPeriod, color);
        verifyOrderConfirmation();
    }

    @ParameterizedTest
    @CsvSource({
            "Иван, Петров, 'ул. Ленина, 10', Черкизовская, 89991234567, 01.01.2025, трое суток, black",
            "Анна, Смирнова, 'ул. Пушкина, 5', Бульвар Рокоссовского, 89999876543, 05.02.2025, пятеро суток, grey"
    })
    public void orderFooterTest(String name, String surName, String address, String stationMetro,
                                String phone, String date, String rentalPeriod, String color) {
        homePage.clickButtonOrderFoot();
        completeOrder(name, surName, address, stationMetro, phone, date, rentalPeriod, color);
        verifyOrderConfirmation();
    }

    private void verifyOrderConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOf(rentalPage.orderConfirmationTitle)
        ).isDisplayed();

        assertTrue(isDisplayed, "Окно 'Заказ оформлен' не появилось");
    }
}

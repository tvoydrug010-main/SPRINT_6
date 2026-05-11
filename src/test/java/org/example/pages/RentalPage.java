package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RentalPage extends BasePage {

    public RentalPage(WebDriver driver) {
        super(driver);
    }

    // Поле "Когда привезти самокат"
    @FindBy(xpath = "//input[@placeholder='* Когда привезти самокат']")
    private WebElement inputDate;

    // Выпадающий список "Срок аренды"
    @FindBy(xpath = "//div[contains(@class, 'Dropdown-control')]")
    private WebElement dropdownRentalPeriod;

    // Варианты срока аренды
    @FindBy(xpath = "//div[contains(@class, 'Dropdown-option')]")
    private WebElement rentalPeriodOption;

    // Чекбокс "Чёрный жемчуг"
    @FindBy(xpath = "//input[@id='black']")
    private WebElement checkboxBlack;

    // Чекбокс "Серая безысходность"
    @FindBy(xpath = "//input[@id='grey']")
    private WebElement checkboxGrey;

    // Поле "Комментарий для курьера"
    @FindBy(xpath = "//input[@placeholder='Комментарий для курьера']")
    private WebElement inputComment;

    // Кнопка "Заказать"
    @FindBy(xpath = "//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']")
    private WebElement buttonOrder;

    //Кнопка "Да"
    @FindBy(xpath = "//button[text()='Да']")
    private WebElement buttonYes;

    //Кнопка "Нет"
    @FindBy(xpath = "//button[contains(@class, 'Button_Inverted__3IF-i') and text()='Нет']")
    private WebElement buttonNo;

    // Кнопка "Назад"
    @FindBy(xpath = "//button[text()='Назад']")
    private WebElement buttonBack;

    @FindBy(xpath = ".//div[contains(text(),'Заказ оформлен')]")
    public WebElement orderConfirmationTitle;

    public void setDate(String date) {
        inputDate.sendKeys(date);
        inputDate.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("react-datepicker")
        ));
    }

    public void selectRentalPeriod(String period) {
        dropdownRentalPeriod.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'Dropdown-option') and text()='" + period + "']")
        )).click();
    }

    public void selectColor(String color) {
        if (color.equalsIgnoreCase("black")) {
            checkboxBlack.click();
        } else if (color.equalsIgnoreCase("grey")) {
            checkboxGrey.click();
        }
    }
    public void setComment(String comment) {
        inputComment.sendKeys(comment);
    }

    public void clickOrderButton() {
        buttonOrder.click();
    }

    public void clickButtonYes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(buttonYes));
        yesButton.click();
    }

    public void clickButtonNo(){
        buttonNo.click();
    }
    public void clickBackButton(){
        buttonBack.click();
    }
}

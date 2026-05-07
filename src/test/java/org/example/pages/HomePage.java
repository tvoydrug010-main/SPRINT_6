package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Кнопка "Заказать" в верхней части страницы
    @FindBy(xpath = "//button[@class='Button_Button__ra12g' and text()='Заказать']")
    private WebElement buttonOrderHeader;
    //Кнопка "Заказать" в нижней части страницы
    @FindBy(xpath = "//button[contains(@class, 'Button_Button__ra12g') and text()='Заказать']")
    private WebElement buttonOrderFoot;

    //Поле ввода "Имя"
    @FindBy(xpath = "//input[@placeholder='* Имя']")
    private WebElement inputName;

    //Поле ввода "Фамилия"
    @FindBy(xpath = "//input[@placeholder='* Фамилия']")
    private WebElement inputSurName;

    //Поле ввода "Адрес"
    @FindBy(xpath = "//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement inputAddress;

    //Поле ввода "Станция метро" с выпадающим списком
    @FindBy(xpath = "//input[@placeholder='* Станция метро']")
    private WebElement inputStationMetro;

    //Выпадающий список "Станций метро"
    @FindBy(css = ".select-search__option")
    private WebElement selectStationMetro;

    //Поле ввода "Телефон"
    @FindBy(xpath = "//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement inputTelNumber;

    //Кнопка "Далее"
    @FindBy(xpath = "//button[contains(@class, 'Button') and text()='Далее']")
    private WebElement buttonNext;

    public void clickButtonOrderHeader(){
        buttonOrderHeader.click();
    }
    public void clickButtonOrderFoot(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonOrderFoot);
        buttonOrderFoot.click();
    }
    public void clickButtonNext(){
        buttonNext.click();
    }
    public void setName(String name){
        inputName.sendKeys(name);
    }
    public void setSurName(String surName){
        inputSurName.sendKeys(surName);
    }
    public void setInputAddress(String address){
        inputAddress.sendKeys(address);
    }

    public void selectInputStationMetro(String stationName){
        inputStationMetro.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement station = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class, 'Order_Text__') and text()='" + stationName + "']")
                )
        );
        station.click();
    }
    public void setInputTelNumber(String telNumber){
        inputTelNumber.sendKeys(telNumber);
    }
}

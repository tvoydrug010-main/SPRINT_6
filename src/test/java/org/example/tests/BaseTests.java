package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.QuestionsPage;
import org.example.pages.RentalPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;
    protected RentalPage rentalPage;
    protected QuestionsPage questionsPage;
    @BeforeEach
    public void setUp() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.education-services.ru/");

        homePage = new HomePage(driver);
        rentalPage = new RentalPage(driver);
        questionsPage = new QuestionsPage(driver);
    }

    @AfterEach
    public void tearDown() {
            driver.quit();
    }
}
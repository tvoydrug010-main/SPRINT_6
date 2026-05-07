package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuestionsPage extends BasePage {

    public QuestionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-accordion-component='AccordionItemButton']")
    private WebElement questions;

    @FindBy(xpath = "//div[@class='accordion__panel']")
    private WebElement answers;

    public void clickQuestion() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questions);
        try { Thread.sleep(500); } catch (InterruptedException e) {}
        questions.click();
    }

    public String getAnswerText() {
        return answers.getText();
    }
}
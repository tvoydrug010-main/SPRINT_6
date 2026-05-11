package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class QuestionsPage extends BasePage {

    public QuestionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-accordion-component='AccordionItemButton']")
    private List <WebElement> questions;

    @FindBy(xpath = "//div[@class='accordion__panel']")
    private List <WebElement> answers;

    public void clickQuestionsByIndex(int index) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questions.get(index));
        wait.until(ExpectedConditions.elementToBeClickable(questions.get(index))).click();
    }

    public String getAnswerText(int index) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", questions.get(index));
        wait.until(ExpectedConditions.elementToBeClickable(questions.get(index))).click();
        return answers.get(index).getText();
    }
}
package org.example.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionsTests extends BaseTests {

    @Test
    void firstQuestionShouldOpenAndShowCorrectAnswer() {
        questionsPage.clickQuestion();
        String actualAnswer = questionsPage.getAnswerText();

        Assertions.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", actualAnswer);
    }
}
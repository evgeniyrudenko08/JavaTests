package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AutomationRemarksPage {

    private SelenideElement Mentoring = $(By.cssSelector("#main > div > section > article.style6 > a > h2"));

    private SelenideElement ButtonEducation = $(By.cssSelector("#nav > div.nav-panel > a.course_link > span"));

    private SelenideElement ContactByEmail = $(By.id("email"));

    private SelenideElement AssertTextOnMentoringPage = $(By.cssSelector("#main > div > p"));

    public AutomationRemarksPage openAutomationRemarks() {
        Selenide.open("http://automation-remarks.com/2016/selenide-shadow-sides/index.html");
        return this;
    }

    public AutomationRemarksPage clickOnMentoring() {
        $(Mentoring).click();
        return this;
    }

    public AutomationRemarksPage clickOnEducationButton() {
        $(ButtonEducation).click();
        return this;
    }
    public AutomationRemarksPage enterEmail(String text) {
        $(ContactByEmail).setValue(text);
        return this;
    }

    public AutomationRemarksPage ValidTextExistsOnMentoringPage (String text){
        $(AssertTextOnMentoringPage).shouldHave(Condition.text(text));
        return this;
    }
}

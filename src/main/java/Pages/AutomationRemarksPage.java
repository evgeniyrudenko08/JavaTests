package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AutomationRemarksPage {

    private SelenideElement Mentoring1 = $(By.cssSelector("#main > div > section > article.style6 > a > h2"));

    private SelenideElement ButtonEducation1 = $(By.cssSelector("#nav > div.nav-panel > a.course_link > span"));

    private SelenideElement ContactByEmail1 = $(By.id("email"));

    public AutomationRemarksPage open() {
        Selenide.open("http://automation-remarks.com/2016/selenide-shadow-sides/index.html");
        return this;
    }

    public AutomationRemarksPage clickOnMentoring() {
        $(Mentoring1).click();
        return this;
    }

    public AutomationRemarksPage clickOnEducationButton() {
        $(ButtonEducation1).click();
        return this;
    }
    public AutomationRemarksPage enterEmail(String text) {
        $(ContactByEmail1).setValue(text);
        return this;
    }
}

package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AutomationRemarksPage {

    public SelenideElement Mentoring1 = $(By.cssSelector("#main > div > section > article.style6 > a > h2"));

    public SelenideElement ButtonEducation1 = $(By.cssSelector("#nav > div.nav-panel > a.course_link > span"));

    public SelenideElement ContactByEmail1 = $(By.id("email"));

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
        $(ContactByEmail1).val(text);
        return this;
    }


}

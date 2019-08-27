import Pages.AutomationRemarksPage;
import org.testng.annotations.Test;

public class SelenideTest {

    @Test
    public void Education(){
        AutomationRemarksPage automationRemarksPage = new AutomationRemarksPage();
        automationRemarksPage.open();
        automationRemarksPage.clickOnEducationButton();
        automationRemarksPage.clickOnMentoring();
        automationRemarksPage.enterEmail("rev08@gmail.co");
    }
}

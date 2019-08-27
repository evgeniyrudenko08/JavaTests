import Pages.AutomationRemarksPage;
import com.codeborne.selenide.testng.TextReport;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TextReport.class)
public class SelenideTest {
    private AutomationRemarksPage automationRemarksPage = new AutomationRemarksPage();

    @Test
    public void SelectEducationCourseAndSendInformationByEmail(){
        automationRemarksPage.open();
        automationRemarksPage.clickOnEducationButton();
        automationRemarksPage.clickOnMentoring();
        automationRemarksPage.enterEmail("rev08@gmail.co");
    }
}

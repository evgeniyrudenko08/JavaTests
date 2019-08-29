import Pages.AutomationRemarksPage;
import com.codeborne.selenide.testng.TextReport;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TextReport.class)
public class SelenideTest {
    private AutomationRemarksPage automationRemarksPage = new AutomationRemarksPage();

    @Test
    public void selectEducationCourseAndSendInformationByEmail(){
        automationRemarksPage.openAutomationRemarks();
        automationRemarksPage.clickOnEducationButton();
        automationRemarksPage.clickOnMentoring();
        automationRemarksPage.ValidTextExistsOnMentoringPage("Отличный формат если ты работаешь один в компании и хочешь найти ментора.");
        automationRemarksPage.enterEmail("rev08@gmail.co");
    }

    @Test
    public void openAutomationRemarks(){
        automationRemarksPage.openAutomationRemarks();
    }

}

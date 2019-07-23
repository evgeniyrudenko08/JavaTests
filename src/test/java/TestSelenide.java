import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class TestSelenide {

    @Test
    public void FindCheeseInGoogle(){
        Selenide.open("http://www.google.com/");
        Selenide.$(By.name("q")).setValue("Cheese!").submit();
        $("#rso > div:nth-child(1) > div > div:nth-child(1) > div > div > div.r > a > h3").shouldHave(Condition.text("Cheese - Wikipedia"));
    }
}

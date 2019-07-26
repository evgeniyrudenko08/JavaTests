import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{


    @Test(priority = 1)
    public void loginTest(){
        page.getInstance(LoginPage.class).doLogin("test780@test50.com", "123456q11");
    }
}

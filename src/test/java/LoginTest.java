import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        driver=browserOpen();
        loginPage=new LoginPage(driver);
    }
    @Test
    public void loginWithValidData (){
        loginPage.LoginOnPage("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void loginWithWrongUsername (){
        loginPage.LoginOnPage("standardst","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void loginWithWrongPassword (){
        loginPage.LoginOnPage("standard","secrets");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void loginWithOutData (){
        loginPage.LoginOnPage("","");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }
    @Test
    public void loginWithOutUsername(){
        loginPage.LoginOnPage("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
}

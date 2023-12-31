import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy (css = ".error-message-container h3")
    WebElement errorMessage;
    public LoginPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void LoginOnPage(String name,String pass)
    {
        userName.sendKeys(name);
        password.sendKeys(pass);
        loginButton.submit();
    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }
}







import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage {
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy (css = ".summary_subtotal_label")
    WebElement itemPrice;

    @FindBy (css = ".summary_total_label")
    WebElement totalPrice;

    public CheckOutPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputPersonalInfo(String name, String lastname, String zip){
        firstName.sendKeys(name);
        lastName.sendKeys(lastname);
        postalCode.sendKeys(zip);
        continueButton.click();
    }

    public String getItemPrice(){
        return  itemPrice.getText();
    }
    public String getTotalPrice() {
        return totalPrice.getText();
    }
    /* public void getItemPrice() {
        itemPrice.isDisplayed();
    }*/

   /* public void getTotalPrice (){
        totalPrice.isDisplayed();
    }*/
}
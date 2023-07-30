import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy (css = "#remove-sauce-labs-backpack")
    WebElement removePack;

    @FindBy (css = "#remove-sauce-labs-fleece-jacket")
    WebElement removeJacket;

    @FindBy (css = "#continue-shopping")
    WebElement continueShopping;

    public CartPage (ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void removeBackPack (){
        removePack.click();
    }

    public void removeFleeceJacket (){
        removeJacket.click();
    }

    public void buttomContinue (){
        continueShopping.click();
    }

}

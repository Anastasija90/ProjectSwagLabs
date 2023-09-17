import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
    @FindBy (className = "product_sort_container")
    WebElement sort;
    @FindBy (css = "#add-to-cart-sauce-labs-onesie")
    WebElement onesie;
    @FindBy (css = " #add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;
    @FindBy (css = "#add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tshirt;
    @FindBy (css = ".shopping_cart_link")
    WebElement shoppingCart;
    @FindBy (css = "#add-to-cart-sauce-labs-backpack")
    WebElement backpack;
    @FindBy (css = "#add-to-cart-sauce-labs-fleece-jacket")
    WebElement fleeceJacket;
    public InventoryPage (ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void sortingBox (String text){
        Select box = new Select(sort);
        box.selectByVisibleText(text);
    }
    public void addOnesie (){
        onesie.click();
    }
    public void addBikeLight (){
        bikeLight.click();
    }
    public void addBoldTshirt (){
        tshirt.click();
    }
    public String getCartNumber (){
        return shoppingCart.getText();
    }
    public void addBackpack (){
        backpack.click();
    }
    public void addFleeceJacket (){
        fleeceJacket.click();
    }
    public void clickOnCart (){
        shoppingCart.click();
    }
}

import com.beust.ah.A;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    @BeforeMethod
    public void Setup() {
        driver = browserOpen();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage=new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }
    @Test   //3a
    public void itemTotalPrice(){
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addOnesie();
        inventoryPage.addBikeLight();
        inventoryPage.addBoldTshirt();
        inventoryPage.clickOnCart();
        cartPage.buttomCheckout();
        checkOutPage.inputPersonalInfo("Anastasija","Savic","11000");
        Assert.assertEquals(checkOutPage.getItemPrice(),"Item total: $33.97");
        /*Assert.assertEquals(checkOutPage.itemPrice.isDisplayed(),true,"Item total: $33.97"); */
    }
    @Test   //3b
    public void totalPrice() {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addBackpack();
        inventoryPage.addFleeceJacket();
        inventoryPage.clickOnCart();
        cartPage.buttomCheckout();
        checkOutPage.inputPersonalInfo("Anastasija","Savic","11000");
        Assert.assertEquals(checkOutPage.getTotalPrice(),"Total: $86.38");
        /*Assert.assertEquals(checkOutPage.totalPrice.isDisplayed(),true,"Total: $86.38");*/
    }
    @Test   // 4
    public void buyingProcess() {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addBackpack();
        inventoryPage.addBikeLight();
        inventoryPage.clickOnCart();
        cartPage.buttomCheckout();
        checkOutPage.inputPersonalInfo("Anastasija","Savic","11000");
        checkOutPage.clickFinishButtom();
        Assert.assertEquals(checkOutPage.getInfoMessage(),"Thank you for your order!");
    }
   @AfterMethod
    public void after() {
        driver.quit();
    }
}
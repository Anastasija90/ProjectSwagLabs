import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

        LoginPage loginPage;
        InventoryPage inventoryPage;
        CartPage cartPage;

    @BeforeMethod
    public void setUp(){
        driver=browserOpen();
        loginPage=new LoginPage(driver);
        inventoryPage= new InventoryPage(driver);
        cartPage=new CartPage(driver);
    }

    @Test   //2a

    public void addThreeCheapestProducts (){
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.sortingBox("Price (low to high)");
        inventoryPage.addOnesie();
        inventoryPage.addBikeLight();
        inventoryPage.addBoldTshirt();
        Assert.assertEquals(inventoryPage.getCartNumber(),"3");
    }

    @Test   //2b

    public void addAndRemoveTwoProduts () {
        loginPage.LoginOnPage("standard_user","secret_sauce");
        inventoryPage.addBackpack();
        inventoryPage.addFleeceJacket();
        inventoryPage.clickOnCart();
        cartPage.removeBackPack();
        cartPage.removeFleeceJacket();
        cartPage.buttomContinue();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.getCartNumber(), "");
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}


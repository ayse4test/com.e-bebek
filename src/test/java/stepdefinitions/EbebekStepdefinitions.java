package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class EbebekStepdefinitions {

    HomePage homePage=new HomePage();
    SearchResultsPage searchResultsPage=new SearchResultsPage();
    ProductPage productPage=new ProductPage();
    CartPage cartPage=new CartPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    String expectedProductLink,actualProductLink;


    @Given("e-bebek anasayfasina gidilir")
    public void e_bebek_anasayfasina_gidilir() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homeUrl"));
    }
    
    @When("arama cubuguna {string} yazilir ve aratilir")
    public void arama_cubuguna_yazilir_ve_aratilir(String searchProduct) {
       // homePage.searchBox.click();
        homePage.searchBox.sendKeys(searchProduct+ Keys.ENTER);
    }
    @When("cikan ilk urune tiklanir")
    public void cikan_ilk_urune_tiklanir() {
        searchResultsPage.selectedProduct.click();
        expectedProductLink = searchResultsPage.selectedProduct.getAttribute("href");
        System.out.println(expectedProductLink);

    }
    @When("ilgili urun sepete eklenir")
    public void ilgili_urun_sepete_eklenir() {
        //wait.until(ExpectedConditions.visibilityOf(productPage.addToCartBtn));
        productPage.addToCartBtn.submit();
    }

    @When("sepete eklendigi kontrol edilir")
    public void sepete_eklendigi_kontrol_edilir()  {

       // wait.until(ExpectedConditions.elementToBeClickable(productPage.showCartBtn));
        wait.until(ExpectedConditions.visibilityOf(productPage.showCartBtn));
        productPage.showCartBtn.click();

        actualProductLink= cartPage.basketContent.getAttribute("href");
        System.out.println(actualProductLink);
        Assert.assertEquals("Urun sepete eklenmemistir!",expectedProductLink,actualProductLink);
         //Driver.getDriver().navigate().refresh();
        // Driver.waitForClickability(productPage.showCartBtn,3);

    }
    @When("sepette urun sayisi 1 kez arttirilir")
    public void sepette_urun_sayisi_kez_arttirilir()  {
        //wait.until(ExpectedConditions.elementToBeClickable(cartPage.plusButton));

        Driver.waitForPageToLoad(5);
        cartPage.plusButton.click();

    }
    @When("urun sayisinin arttigi gorulur")
    public void urun_sayisinin_arttigi_gorulur() {
        //wait.until(ExpectedConditions.visibilityOf(cartPage.showCart2));
        //cartPage.showCart2.click();

       // Driver.getDriver().navigate().refresh();

        Driver.waitForPageToLoad(10);
        System.out.println( cartPage.miniCartCounter.getText());
        Assert. assertEquals( "2",cartPage.miniCartCounter.getText());


    }
    @When("sepette urun sayisi 1 kez azaltilir")
    public void sepette_urun_sayisi_kez_azaltilir() throws InterruptedException {
        Driver.waitForPageToLoad(5);
        // wait.until(ExpectedConditions.elementToBeClickable(cartPage.minusButton));
       cartPage.minusButton.click();
        //Driver.getDriver().navigate().refresh();
    }
    @When("urun sayisinin azaldigi gorulur")
    public void urun_sayisinin_azaldigi_gorulur() throws InterruptedException {

        Driver.waitForPageToLoad(10);
        System.out.println( cartPage.miniCartCounter.getText());
        Assert.assertEquals( "1",cartPage.miniCartCounter.getText());

    }
    @When("ilgili urun sepetten silinir")
    public void ilgili_urun_sepetten_silinir()  {
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.removeButton));
        cartPage.removeButton.click();
    }

    @Then("sepetin bos oldugu kontrol edilir")
    public void sepetin_bos_oldugu_kontrol_edilir()  {

        Assert.assertTrue("Sepetinizde urun bulunmamaktadır, yazisi gorunmuyor!",cartPage.emptyBasketText.isDisplayed());
        Driver.closeDriver();
    }
}

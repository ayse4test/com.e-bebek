package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SearchResultsPage {
    public SearchResultsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[@class='product-item-anchor']")
    public WebElement selectedProduct;

    @FindBy(xpath="//button[contains(text(),'Sepete Ekle')]")
    public  List<WebElement>  productList;


    public WebElement findProduct(String productID){
        return  Driver.getDriver().findElement(By.cssSelector(String.format("div[class*='product-item'] a[href*='%s']",productID))) ;
    }
    public WebElement findProductLink(String productID){
        return  Driver.getDriver().findElement(By.partialLinkText(productID));
    }


}

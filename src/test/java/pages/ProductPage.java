package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {
    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "addToCartBtn")
    public WebElement addToCartBtn;

    @FindBy(id = "btnShowCart")
    public WebElement showCartBtn;
}




package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

     @FindBy(id="txtItemQuantity")
     public WebElement productQuantity;

    @FindBy(id="btnPlus")
    public WebElement plusButton;

    @FindBy(id="btnShowCart")
    public WebElement showCart2;

    @FindBy(id="btnMinus")
    public WebElement minusButton;


    @FindBy(id="btnRemoveProduct")
    public WebElement removeButton;

    @FindBy(xpath="//*[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]")
    public WebElement emptyBasketText;

    @FindBy (css = "div[class='basket-content'] a")
    public WebElement basketContent;

    @FindBy(css= "div.my-basket-card-wrapper.ng-star-inserted h3")
    public WebElement quantitiyTextElement;

    @FindBy(css=" button[id='iconMiniCart'] span[class='number ng-star-inserted'")
    public WebElement miniCartCounter;


}

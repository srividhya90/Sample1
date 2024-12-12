package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyShoppingCartPage extends BaseClass{
public MyShoppingCartPage() {
PageFactory.initElements(driver, this);
}

@FindBy(xpath="//h1[text()='My Shopping Cart']")
private WebElement cartPage;
public WebElement getCartPage() {
	return cartPage;
}

@FindBy(xpath="//input[@value='Buy']")
private WebElement clickBuy;
public WebElement getClickBuy() {
	return clickBuy;
}

}

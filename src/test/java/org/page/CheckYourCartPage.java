package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckYourCartPage extends BaseClass {
	public CheckYourCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Cart']")
	private WebElement yourCartPage;
	public WebElement getYourCartPage() {
		return yourCartPage;
	}

	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewRecipientName']")
	private WebElement name;
	public WebElement getName() {
		return name;
	}

	@FindBy(xpath="//textarea[@id='ctl00_cpBody_txtNewAddress']")
	private WebElement address;
	public WebElement getAddress() {
		return address;
	}

	@FindBy(xpath="//select[@id='ctl00_cpBody_ddlNewCountry']")
	private WebElement country;
	public WebElement getCountry() {
		return country;
	}

	@FindBy(xpath="//select[@id='ctl00_cpBody_ddlNewState']")
	private WebElement state;
	public WebElement getState() {
		return state;
	}

	@FindBy(xpath="//select[@id='ctl00_cpBody_ddlNewCities']")
	private WebElement city;
	public WebElement getCity() {
		return city;
	}

	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewPincode']")
	private WebElement pinCode;
	public WebElement getPinCode() {
		return pinCode;
	}

	@FindBy(xpath="//input[@id='ctl00_cpBody_txtNewMobile']")
	private WebElement mobile;
	public WebElement getMobile() {
		return mobile;
	}

	@FindBy(xpath="//input[@id='ctl00_cpBody_imgSaveNew']")
	private WebElement clickSave;
	public WebElement getClickSave() {
		return clickSave;
	}

	@FindBy(xpath="//h3[text()='Review your Order ']")
	private WebElement reviewPage;
	public WebElement getReviewPage() {
		return reviewPage;
	}

	@FindBy(xpath="//a[@href='https://www.bookswagon.com/']")
	private WebElement homeLogo;
	public WebElement getHomeLogo() {
		return homeLogo;
	}

}


package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseClass {

	public LogInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@class='logonew']")
	private WebElement homepage;
	public WebElement getHomepage() {
		return homepage;
	}

	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myaccount;
	public WebElement getMyaccount() {
		return myaccount;
	}

	@FindBy(xpath="//a[text()='Log in']")
	private WebElement logIn;
	public WebElement getLogIn() {
		return logIn;
	}

	@FindBy(xpath="//h3[text()='Log in']")
	private WebElement logInPage;
	public WebElement getLogInPage() {
		return logInPage;
	}

	@FindBy(xpath="(//input[@placeholder='Mobile/Email'])[1]")
	private WebElement userId;
	public WebElement getUserId() {
		return userId;
	}

	@FindBy(xpath="(//input[@placeholder='Password'])[1]")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath="//a[text()='Login']")
	private WebElement logInButton;
	public WebElement getLogInButton() {
		return logInButton;
	}

	@FindBy(xpath="//span[text()='srividhya']")
	private WebElement userhomePage;
	public WebElement getUserHomePage() {
		return userhomePage;
	}

	@FindBy(xpath="//a[@id='ctl00_lnkbtnLogout']")
	private WebElement logOut;
	public WebElement getLogOut() {
		return logOut;
	}

}

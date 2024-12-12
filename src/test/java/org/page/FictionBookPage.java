package org.page;

import org.global.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FictionBookPage extends BaseClass {
	public FictionBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Fiction Books']")
	private WebElement fiction;
	public WebElement getFiction() {
		return fiction;
	}

	@FindBy(xpath="//span[text()='Fiction Books']")
	private WebElement fictionPage;
	public WebElement getFictionPage() {
		return fictionPage;
	}

	@FindBy(xpath="//a[@href='https://www.bookswagon.com/book/richest-man-in-babylon-s/9789388144315']")
	//	@FindBy(xpath="//img[@alt='Richest Man in Babylon']")
	private WebElement book1;
	public WebElement getBook1() {
		return book1;
	}

	@FindBy(xpath="//a[text()='Add to Cart']")
	private WebElement addBook1;
	public WebElement getAddBook1() {
		return addBook1;
	}

	@FindBy(xpath="//a[@href='https://www.bookswagon.com/book/hidden-hindu-trilogy-gupta-akshat/9780143467359']")
	private WebElement book2;
	public WebElement getBook2() {
		return book2;
	}

	@FindBy(xpath="//a[@data-id='39211576']")
	private WebElement book2qview;
	public WebElement getBook2qview() {
		return book2qview;
	}

	@FindBy(xpath="//a[text()='Add To Cart']")
	private WebElement addbook2;
	public WebElement getAddbook2() {
		return addbook2;
	}

	@FindBy(xpath="(//button[text()='×'])[2]")
	private WebElement book2close;
	public WebElement getBook2close() {
		return book2close;
	}

	@FindBy(xpath="//a[@href='https://www.bookswagon.com/book/blue-umbrella-ruskin-bond/9788171673407']")
	private WebElement book3;
	public WebElement getBook3() {
		return book3;
	}

	@FindBy(xpath="//a[text()='Add to Cart']")
	private WebElement addbook3;
	public WebElement getAddbook3() {
		return addbook3;
	}

	@FindBy(xpath="(//span[@class='itemcount'])[1]")
	//  @FindBy(xpath="(//li[@class='list-inline-item position-relative'])[1]")
	//  @FindBy(xpath="(//a[@href='https://www.bookswagon.com/shoppingcart.aspx'])[1]")
	//	@FindBy(xpath="(//img[@alt='Cart Icon'])[1]")
	private WebElement clickCartIcon;
	public WebElement getClickCartIcon() {
		return clickCartIcon;
	}
}

package org.execution;

import org.global.BaseClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.SessionNotCreatedException;
import org.pageManager.PageManager;

public class MyShoppingcartPageValidation {

	public static BaseClass baseClass = new BaseClass();
	public static PageManager pageManager=new PageManager();

	@BeforeClass
	public static void LaunchBrowser() {
		try {
			//1.Launch the Web Browser
			baseClass.getDriver(baseClass.readExcel(1,0));

			//Maximize the window
			baseClass.maxwindow();
		}catch (SessionNotCreatedException e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();
			System.out.println("Check Browser Version and Dependecncy");

		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			//2.Launch BookStore Url
			baseClass.geturl(baseClass.readExcel(1, 1));
			baseClass.sleep(2000);

			//Take screenshot
			//baseClass.screenCapture();

			//Validate whether we have launched homepage
			if(pageManager.getLogInPage().getHomepage().isDisplayed()) {
				System.out.println("User is in Books Wagon HomePage");
				System.out.println(pageManager.getLogInPage().getHomepage().getText());

			}

		}catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			//	launch the bookstore login page	
			if(pageManager.getLogInPage().getMyaccount().isDisplayed()) {
				baseClass.clickByActions(pageManager.getLogInPage().getMyaccount(), "hoverover");
				baseClass.sleep(2000);
				if(pageManager.getLogInPage().getLogIn().isDisplayed()) {
					if(pageManager.getLogInPage().getLogIn().isEnabled()) {
						baseClass.clickByJava(pageManager.getLogInPage().getLogIn());
						baseClass.sleep(2000);

					}
				}
			}
		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			//3. Validate whether we have launched the bookstore login page successfully
			if(pageManager.getLogInPage().getLogInPage().isDisplayed()) {
				System.out.println("User is in LogIn page");

				//4.Enter Valid Username and Password	
				baseClass.sendKeysByJava(pageManager.getLogInPage().getUserId(),baseClass.readExcel(1, 2));
				baseClass.sendKeysByJava(pageManager.getLogInPage().getPassword(), baseClass.readExcel(1, 3));

				//5.Click LogIn	
				baseClass.clickByJava(pageManager.getLogInPage().getLogInButton());
				baseClass.sleep(2000);

			}

		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			//6.Navigated to HomePage
			if(pageManager.getLogInPage().getUserHomePage().isDisplayed()) {
				System.out.println("User is successfully logged in");

			}
		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			baseClass.clickByJava(pageManager.getFictionBookPage().getFiction());
			baseClass.sleep(3000);
			if(pageManager.getFictionBookPage().getFictionPage().isDisplayed()) {
				System.out.println("User is in Fiction Books Page");

			}
		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			//9.add book1
			if(pageManager.getFictionBookPage().getBook1().isDisplayed())
			{
				if(pageManager.getFictionBookPage().getBook1().isEnabled()) {
					baseClass.clickByJava(pageManager.getFictionBookPage().getBook1());
					baseClass.sleep(3000);
					if(pageManager.getFictionBookPage().getAddBook1().isDisplayed()) {
						if(pageManager.getFictionBookPage().getAddBook1().isEnabled()) {
							baseClass.clickByJava(pageManager.getFictionBookPage().getAddBook1());
							baseClass.sleep(2000);
							System.out.println("Book1 added successfully");
						}
					}
				}
			}

		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			//10.add book2
			baseClass.clickByJava(pageManager.getFictionBookPage().getFiction());
			baseClass.sleep(3000);
			baseClass.scrollType(pageManager.getFictionBookPage().getBook2(), "down");
			baseClass.sleep(2000);

			if(pageManager.getFictionBookPage().getBook2().isDisplayed())
			{	
				baseClass.clickByActions(pageManager.getFictionBookPage().getBook2(), "hoverover");
				if (pageManager.getFictionBookPage().getBook2qview().isDisplayed()) {
					baseClass.clickByJava(pageManager.getFictionBookPage().getBook2qview());
					baseClass.sleep(3000);

					baseClass.clickByJava(pageManager.getFictionBookPage().getAddbook2());
					baseClass.sleep(3000);

					baseClass.clickByJava(pageManager.getFictionBookPage().getBook2close());
					baseClass.sleep(3000);

					System.out.println("Book2 added Succesfully");
				}
			}

		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}

		//11.Scroll down and add Book3
		try {

			baseClass.scrollType(pageManager.getFictionBookPage().getBook3(), "down");;
			baseClass.sleep(2000);
			if(pageManager.getFictionBookPage().getBook3().isDisplayed()) {
				baseClass.clickByJava(pageManager.getFictionBookPage().getBook3());
				baseClass.sleep(2000);
				if(pageManager.getFictionBookPage().getAddbook3().isDisplayed()) {
					if(pageManager.getFictionBookPage().getAddbook3().isEnabled()) {
						baseClass.clickByJava(pageManager.getFictionBookPage().getAddbook3());
						baseClass.sleep(3000);
						System.out.println("Book3 added successfully");
					}

				}
			}

		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
		try {

			//12.Click Cart Icon
			if(pageManager.getFictionBookPage().getClickCartIcon().isDisplayed()) {
				baseClass.clickByJava(pageManager.getFictionBookPage().getClickCartIcon());
				baseClass.sleep(2000);

			}

		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
	}

	@Before
	public void ShoppingCart() {
		try {
			if(pageManager.getMyShoppingCartPage().getCartPage().isDisplayed()) {
				System.out.println("User is in MyShoppingCart Page");
			}

		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
	}


	@Test
	public void ClickBuyBooks() {
		try {

			if(pageManager.getMyShoppingCartPage().getClickBuy().isDisplayed()) {
				if(pageManager.getMyShoppingCartPage().getClickBuy().isEnabled()) {
					baseClass.clickByJava(pageManager.getMyShoppingCartPage().getClickBuy());
					baseClass.sleep(3000);
				}
			}
		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
	}

	@After
	public void MyShoppingCartPageValidation() {
		try {
			if(pageManager.getCheckYourCartPage().getYourCartPage().isDisplayed()) {
				System.out.println("User is in CheckoutYourCart Page");

			}
		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
	}
}

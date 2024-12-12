package org.execution;

import org.global.BaseClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pageManager.PageManager;
import org.openqa.selenium.SessionNotCreatedException;

public class LoginPageValidation extends BaseClass{
	
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
	}
	
	@Before
	public void LaunchUrl() {

		try {
			//2.Launch BookStore Url
			baseClass.geturl(baseClass.readExcel(1, 1));
			baseClass.sleep(2000);

			//Take screenshot
			//baseClass.screenCapture();

			//Validate whether we have launched homepage
			if(pageManager.getLogInPage().getHomepage().isDisplayed()) {
				System.out.println("User is in Books Wagon HomePage");
			}

		}catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}

	}
	
	@Test
	public void LogInCredentials() {
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
	}

	@After
	public void LogInValidation() {
		try {
			//6.Navigated to HomePage
			if(pageManager.getLogInPage().getUserHomePage().isDisplayed()) {
				System.out.println("User is successfully logged in");

			}
		} catch (Exception e) {

			System.out.println("Error Message :" + e.getMessage());
			e.printStackTrace();

		}
	}
}
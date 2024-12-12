package org.pageManager;

import org.global.BaseClass;
import org.page.CheckYourCartPage;
import org.page.FictionBookPage;
import org.page.LogInPage;
import org.page.MyShoppingCartPage;

public class PageManager extends BaseClass {
	private LogInPage logInPage;
	public LogInPage getLogInPage() {
		return (logInPage==null)?logInPage =new LogInPage():logInPage;
	}

	private FictionBookPage fictionBookPage;
	public FictionBookPage getFictionBookPage() {
		return (fictionBookPage==null)?fictionBookPage = new FictionBookPage():fictionBookPage;
	}

	private CheckYourCartPage checkYourCartPage;
	public CheckYourCartPage getCheckYourCartPage() {
		return (checkYourCartPage==null)?checkYourCartPage=new CheckYourCartPage():checkYourCartPage;
	}

	private MyShoppingCartPage myShoppingCartPage;
	public MyShoppingCartPage getMyShoppingCartPage() {
		return (myShoppingCartPage==null)?myShoppingCartPage=new MyShoppingCartPage():myShoppingCartPage;
	}
}

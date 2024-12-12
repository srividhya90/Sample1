package org.global;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static JavascriptExecutor jsExecutor;
	public static Actions actions;
	public static Alert alert;
	public static Select select;
	
	public void getDriver(String browser) {
		switch(browser){
			case "Chrome":
			{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		break;
			}
			case "Edge":
			{
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
			break;
			}
			
			default:
			{
				System.out.println("Invalid Browser Type");
				break;
			}
		}
	}

	public void geturl(String url) {
		driver.get(url);
	}
	
	public void maxwindow() {
		driver.manage().window().maximize();
	}
	
	public void sendKeysByJava(WebElement element,String keys) {
		element.sendKeys(keys);
	}
	
	public void sendKeysByJsExecutor(WebElement element2,String keys) {
	jsExecutor = (JavascriptExecutor)driver;
	jsExecutor.executeScript("arguments[0].setAttribute('value','"+keys+"')",element2);
	}

	public String getvalueByJava(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	public Object getvalueByJsExecutor(WebElement element) {
		jsExecutor = (JavascriptExecutor)driver;
		Object executeScript = jsExecutor.executeScript("return arguments[0].getAttribute('value')",element);
		return executeScript;
	}
	
	public void clickByJava(WebElement element) {
		element.click();
	}
	
	public void clickByJsExecutor(WebElement element) {
		jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click()",element);
	}
	
	public void scrollType(WebElement element,String scrollType) {
		jsExecutor=(JavascriptExecutor)driver;
		switch(scrollType) {
		case "up":
			jsExecutor.executeScript("arguments[0].scrollIntoView(false)",element);
		break;
		case "down":
			jsExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
		break;
			default:
				System.out.println("Invalid ScrollType");
				break;
			}
	}
	
	public void scrollpage(String value) {
		jsExecutor=(JavascriptExecutor)driver;
		switch (value){
	case "top":
		jsExecutor.executeScript("window.scroll(0,0)");
	break;
	case "bottom":
		jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		break;
		default:
			System.out.println("Invalid Scroll Type");
			break;
	}
	}
	
	public void windowshandling(int index) {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> list=new ArrayList();
		list.addAll(allWindows);
		String windowsid = list.get(index);
		driver.switchTo().window(windowsid);
	}
	
	public String getwindowsid(int index) {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		LinkedList<String> list=new LinkedList<String>();
		list.addAll(allWindows);
		String windowsid = list.get(index);
		return windowsid;
		}

	public void switchToWindows(String windowsid) {
		driver.switchTo().window(windowsid);
	}
	
	public void clickByActions(WebElement element,String actiontype) {
	actions =new Actions(driver);
	switch(actiontype) {
	case "click":
		actions.click(element).perform();
		break;
	case "doubleclick":
		actions.doubleClick(element).perform();
		break;
	case "rightclick":
		actions.contextClick(element).perform();
		break;
	case "hoverover":
		actions.moveToElement(element).perform();
		break;
		default:
			System.out.println("Invalid action Type");
			break;
	}
	}
	
	public void dragAndDrop(WebElement source,WebElement target) {
		actions =new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	
	public void robotaction(String functionType) throws AWTException {
	Robot r = new Robot();
	switch(functionType) {
	case "copy":
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_C);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_C);
	break;
	case "paste":
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		break;
	case "selectall":
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		break;
	case "delete":
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
		break;
	default:
		System.out.println("Invalid selection");
		break;
	}
	}
	
//	public void selectTypes(WebElement element,String selecttype,String value) {
//		Select s = new Select(element);
//		switch(selecttype){
//		case "Text":
//			s.selectByVisibleText(value);
//			break;
//		case "Value":
//			s.selectByValue(value);
//			break;
//		
//		}
//	}

	public void selectByVisibleText(WebElement element,String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByValue(WebElement element,String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectByIndex(WebElement element,int value) {
		select = new Select(element);
		select.selectByIndex(value);
	}
	
	public void simplealert() {
		alert =driver.switchTo().alert();
		alert.accept();
	}
	
	public void confirmalert(String value) {
		alert =driver.switchTo().alert();
		switch(value) {
		case "accept":
			alert.accept();
		break;
		case "dismiss":
			alert.dismiss();
			break;
		default:
			break;
		}
	}

	public void promptalert(WebElement element,String value, String result) {
		Alert alert =driver.switchTo().alert();
		alert.sendKeys(value);
//		sendKeysByJava(element, value);
		System.out.println(value);
		switch(result) {
		case "accept":
			alert.accept();
		break;
		case "dismiss":
			alert.dismiss();
			break;
		default:
			break;
		}
	}
	
	public void navigation(String command) {
	switch(command)
	{
	case "refresh":
		driver.navigate().refresh();
		break;
	case "forward":
		driver.navigate().forward();
		break;
	case "backward":
		driver.navigate().back();
		break;
		default:
			driver.navigate().to(command);
			break;
	}
	}
	
//	public void screenCapture(String image) throws IOException {
	public void screenCapture() throws IOException {
		TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		File destFile =new File("ErrorImage\\"+image+".jpeg");
		File destFile =new File("ErrorImage\\"+System.currentTimeMillis()+".jpeg");
		FileUtils.copyFile(srcFile, destFile);
	}

	public void sleep(int millis) throws InterruptedException {
		Thread.sleep(millis);
	}
	
	public void closeWindow() {
		driver.close();
	}
	
	public String readExcel(int rownum,int cellnum) throws IOException {
		File file=new File("C:\\Users\\Home\\Desktop\\sri_imp\\ValuesforBaseclass.xlsx"); 
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook book= new XSSFWorkbook(fileInputStream);
		
		Sheet sheet = book.getSheet("BookStore");
		
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		
		String cellValue=null;
		switch(cellType) {
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
				cellValue = simpleDateFormat.format(dateCellValue);
				}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l= (long)numericCellValue;
				BigDecimal valueOf = BigDecimal.valueOf(l);
				cellValue = valueOf.toString();
			}
		break;
		default:
			System.out.println("In Valid Cell Type");
			break;
		}
		return cellValue;
	}
	
	public String propertyfile(String key) throws IOException {

	File file=new File("Database\\Config.properties");
	FileInputStream fileInputStream=new FileInputStream(file);
	Properties properties=new Properties();
	properties.load(fileInputStream);
	String property = properties.getProperty(key);
	return property;
		
	}
}

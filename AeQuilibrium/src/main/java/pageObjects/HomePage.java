package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import utils.SeleniumUtils;

public class HomePage extends SeleniumUtils{

	@FindBy(how=How.XPATH,using="//div[@class='bm-burger-button']")
	WebElement menu;
	@FindBy(how=How.ID,using="logout_sidebar_link")
	WebElement logout;
	@FindBy(how=How.XPATH,using="//button[text()='ADD TO CART']")
	WebElement firstItem;
	@FindBy(how=How.XPATH,using="//button[text()='REMOVE']")
	WebElement removeItem;
	@FindBy(how=How.XPATH,using="//a[@class='shopping_cart_link fa-layers fa-fw']/span")
	WebElement cartsize;
	
	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPageTitle()
	{
		return driver.getTitle().equals("Swag Labs");
	}
	public LoginPage verifyLogout(){
		clickElement(menu, "menu");
		clickElement(logout, "logout");
		return new LoginPage(driver, test);
	}
	public boolean validateCart()
	{
		
		clickElement(firstItem, "firstItem");
		sleep();
		PageFactory.initElements(driver, this);
		int size=Integer.parseInt(cartsize.getText());
		clickElement(removeItem, "removeitem");
		return size==1;
	}
	public boolean validateRemoveCart()
	{
		
		clickElement(firstItem, "firstItem");
		PageFactory.initElements(driver, this);
		boolean result=removeItem.isDisplayed();
		clickElement(removeItem, "remove");
		return result;
	}
}

package endTests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class AssignmentTest extends BaseTest {

	@Test
	public void loginTest() {
		test = extent.startTest("loginTest");
		LoginPage loginPage = new LoginPage(driver, test);
		HomePage homePage = loginPage.login("standard_user", "secret_sauce");
		assertTrue(homePage.verifyPageTitle(), test);
		homePage.verifyLogout();
		test.log(LogStatus.PASS, "LoginTest passed");
		extent.endTest(test);
	}

	@Test
	public void logoutTest() {
		test = extent.startTest("logoutTest");
		LoginPage loginPage = new LoginPage(driver, test);
		HomePage homePage = loginPage.login("standard_user", "secret_sauce");
		assertTrue(homePage.verifyLogout().verifyPageTitle(), test);
		
		test.log(LogStatus.PASS, "LogoutTest passed");
		extent.endTest(test);
	}

	@Test
	public void lockedTest() {
		test = extent.startTest("lockedTest");
		LoginPage loginPage = new LoginPage(driver, test);
		boolean result = loginPage.verifyLockedUser("locked_out_user",
				"secret_sauce");
		assertTrue(result, test);
		test.log(LogStatus.PASS, "LockedTest passed");
		extent.endTest(test);
	}
	@Test
	public void validateCartTest() {
		test = extent.startTest("validateCartTsest");
		LoginPage loginPage = new LoginPage(driver, test);
		HomePage homePage = loginPage.login("standard_user", "secret_sauce");
		assertTrue(homePage.validateCart(), test);
		homePage.verifyLogout();
		test.log(LogStatus.PASS, "ValidateCartTsest passed");
		extent.endTest(test);
	}
	@Test
	public void validateRemoveCartTsest() {
		test = extent.startTest("validateRemoveCartTsest");
		LoginPage loginPage = new LoginPage(driver, test);
		HomePage homePage = loginPage.login("standard_user", "secret_sauce");
		assertTrue(homePage.validateRemoveCart(), test);
		homePage.verifyLogout();
		test.log(LogStatus.PASS, "ValidateRemoveCartTsest passed");
		extent.endTest(test);
	}
}

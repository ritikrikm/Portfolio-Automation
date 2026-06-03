package testCases;



import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


import base.BaseTest;
import data.DataProviders;
import pages.AdminExperiencePage;
import utils.ConfigReader;

public class AdminExperienceLoginTest extends BaseTest{

	AdminExperiencePage adminPage;
	@BeforeMethod(alwaysRun=true)
	public void pageSetup() {
		adminPage = new AdminExperiencePage(getDriver());
		adminPage.navigateTo(ConfigReader.get("URL"));
		
	}
	@Test(dataProvider="invalidPassword",dataProviderClass = DataProviders.class,priority=0,groups= {"smoke"})
	public void AdminLoginWithInCorrectPasswords(String invalidPassword, String expectedError) {
		adminPage.adminLogin(invalidPassword);
		Assert.assertEquals("Wrong admin password.", adminPage.errorToast("Admin"));
	}
	@Test(dataProvider="validPasswords",dataProviderClass = DataProviders.class,priority=1,groups= {"smoke"})
	public void AdminLoginWithCorrectPasswords(String Password) {
		adminPage.adminLogin(Password);
		Assert.assertEquals("studio uploader", adminPage.adminLoginAfterText().toLowerCase());
		
	}
	

}

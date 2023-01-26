package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;	
	
	
	public HomePageTest() {
	super(); 
	}

    @BeforeMethod
    public void setUp() throws IOException
    {
    	initialization();
    	testUtil =new TestUtil();

    	loginPage =new LoginPage();
    	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
    }
    
    @Test(priority=1)
    public void verifyHomePageTitleTest()
    {
    	String homePageTitle = homePage.verifyHomePageTitle();
    	Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not matched" );
    }
    
    @Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	     
    @AfterMethod
    public void tearDown(){
    	driver.quit();
    }
    
}

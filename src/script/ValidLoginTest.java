package script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.EnterTimeTrackpage;
import Page.LoginPage;
import generic.BaseClass;
import generic.Utility;

public class ValidLoginTest extends BaseClass{
	
	@Test
	public void testValidLogin() throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		String un = Utility.getXLData(testDataPath, configPath, 1, 0);
		String pw = Utility.getXLData(testDataPath, configPath, 1, 1);
		// 1. Enter Valid username		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(un);
		
		// 2. Enter Valid password		
		loginPage.setPassword(pw);	
		
		// 3. click on login button		
		loginPage.setLogin();	
		
		// 4. Verify that homepage is displayed
		EnterTimeTrackpage ett = new EnterTimeTrackpage(driver);
		boolean res = ett.verifyHomePageIsDisplayed(wait);
		// true -> PASS     false -> FAIL		
		Assert.assertEquals(res, true);
		
	}
	
	

}

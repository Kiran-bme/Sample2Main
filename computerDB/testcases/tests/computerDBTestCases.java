package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import computerDB.base;
import resources.PageObjectsCreate;
import resources.PageObjectsDelete;
import resources.PageObjectsEdit;

public class computerDBTestCases extends base {

	public PageObjectsCreate po;
	public PageObjectsEdit poe;
	public PageObjectsDelete pod;

	@BeforeMethod
	public void initDriver() throws IOException {

		driver = initialiseDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Navigate to the Computer database URL
		driver.get(prop.getProperty("url"));

	}

	@Test(priority = 1)
	public void addNewComputer() throws IOException, InterruptedException {

		// Click on Add a new computer from Home Page
		po = new PageObjectsCreate(driver);
		po.clickAdd().click();

		// Do not enter any details in the Computer name field
		
		// Enter invalid date formats and verify the error message
		po.enterIntroduced().sendKeys(prop.getProperty("intro_invalid_date"));
		po.enterDiscontinued().sendKeys(prop.getProperty("disc_invaid_date"));

		// Click on Create New Computer button and validate the error messages on the
		// screen
		po.clickCreate().click();

		// Verify the error message against Required field - Computer name
		String exp_createError_msg = prop.getProperty("exp_createError_msg");
		String act_createError_msg = po.validateCreateErrorMsg().getText();
		assertTrue(act_createError_msg.contains(exp_createError_msg));

		// Verify the error message against Date fields - Introduced and Discontinued
		String exp_dateError_msg = prop.getProperty("exp_dateError_msg");
		String act_intro_dateError_msg = po.validateIntroDateErrorMsg().getText();
		String act_disc_dateError_msg = po.validateDiscDateErrorMsg().getText();
		assertTrue(act_intro_dateError_msg.contains(exp_dateError_msg));
		assertTrue(act_disc_dateError_msg.contains(exp_dateError_msg));

		// Take screenshot of the messages displayed on the Contact Page
		getScreenshot("CreatePageErrors");
		
		Thread.sleep(2000);

		// Enter valid inputs for Computer Name, Introduced and Discontinued Dates
		po.computerName().sendKeys(prop.getProperty("Computername"));
		po.enterIntroduced().clear();
		po.enterIntroduced().sendKeys(prop.getProperty("Introduced"));
		po.enterDiscontinued().clear();
		po.enterDiscontinued().sendKeys(prop.getProperty("Discontinued"));

		// Select the Company from drop down
		po.select_list(prop.getProperty("Company"));

		Thread.sleep(2000);

		// Click on Create New Computer
		po.clickCreate().click();
		
		Thread.sleep(2000);

		// Validate that the alert displayed on the screen is correct
		Assert.assertEquals(po.actSuccessMsg().getText(), prop.getProperty("exp_successdb_msg"));

		// Take screenshot of the Alert Message
		getScreenshot("addComputer");

	}

	@Test(priority = 2)
	public void editComputer() throws InterruptedException, IOException {

		poe = new PageObjectsEdit(driver);

		// Enter computer name in the search box
		poe.searchComputer().sendKeys(prop.getProperty("searchComputer"));

		// Click on 'Filter by name'
		poe.clickSearch().click();

		Thread.sleep(2000);

		// Click on the search result to Edit
		poe.clickSearchResult().click();

		// Enter the Computer Name, Introduced and Discontinued details
		poe.edit_computerName().clear();
		poe.edit_computerName().sendKeys(prop.getProperty("edit_Computername"));
		poe.edit_Introduced().clear();
		poe.edit_Introduced().sendKeys(prop.getProperty("edit_Introduced"));
		poe.edit_Discontinued().clear();
		poe.edit_Discontinued().sendKeys(prop.getProperty("edit_Discontinued"));

		poe.edit_select_list(prop.getProperty("edit_Company"));

		Thread.sleep(2000);

		poe.clickSave().click();
		
		Thread.sleep(2000);

		// Validate that the alert displayed on the screen is correct
		Assert.assertEquals(poe.actSuccessEditMsg().getText(), prop.getProperty("exp_successEdit_msg"));

		// Take screenshot of the Alert Message
		getScreenshot("saveComputer");

	}

	@Test(priority = 3)
	public void DeleteComputer() throws IOException, InterruptedException {

		// Navigate to Login
		pod = new PageObjectsDelete(driver);

		// Enter computer name in the search box
		pod.searchComputer().sendKeys(prop.getProperty("delete_searchComputer"));

		// Click on 'Filter by name'
		pod.clickSearch().click();

		Thread.sleep(2000);

		// Click on the search result to Edit
		pod.clickSearchResult().click();

		Thread.sleep(2000);

		// Click on Delete this computer button
		pod.clickDelete().click();

		Thread.sleep(2000);

		// Validate that the alert displayed on the screen is correct
		Assert.assertEquals(pod.actSuccessDeleteMsg().getText(), prop.getProperty("exp_successDelete_msg"));

		// Take screenshot of the Alert Message
		getScreenshot("deleteComputer");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver = null;
	}

}

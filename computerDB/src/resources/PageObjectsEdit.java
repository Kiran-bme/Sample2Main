package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObjectsEdit {

	public WebDriver driver;
	
	public PageObjectsEdit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="#searchbox")
	WebElement searchComputer;
	
	@FindBy(css="#searchsubmit")
	WebElement clickSearch;
	
	@FindBy(xpath="//a[@href='/computers/456']")
	WebElement searchResult;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement edit_computerName;
	
	@FindBy(css="#introduced")
	WebElement edit_introduced;
	
	@FindBy(css="#discontinued")
	WebElement edit_discontinued;
	
	@FindBy(css="#company")
	WebElement edit_company_dropdown;
	
	@FindBy(css="input.btn.primary")
	WebElement clickSave;
	
	@FindBy(xpath="//*[@id='main']/div[1]")
	WebElement act_successEdit_msg;

	

	public WebElement searchComputer() {
		return searchComputer;
	}
	
	public WebElement clickSearch() {
		return clickSearch;
	}
	
	public WebElement clickSearchResult() {
		return searchResult;
	}
	
	public WebElement edit_computerName() {
		return edit_computerName;
	}
	
	public WebElement edit_Introduced() {
		return edit_introduced;
	}
	
	public WebElement edit_Discontinued() {
		return edit_discontinued;
	}
	
	public void edit_select_list(String Company){
	     Select companyDropdown=new Select(edit_company_dropdown);
	     companyDropdown.selectByVisibleText(Company);
	}
	
	public WebElement actSuccessEditMsg() {
		return act_successEdit_msg;
	}
	
	public WebElement clickSave() {
		return clickSave;
	} 

}

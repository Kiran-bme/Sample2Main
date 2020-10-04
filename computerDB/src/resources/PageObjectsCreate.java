package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObjectsCreate {

	public WebDriver driver;
	
	public PageObjectsCreate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.help-inline")
	WebElement act_createError_msg;
	
	@FindBy(xpath="//*[@id='main']/form/fieldset/div[2]/div/span")
	WebElement act_intro_dateError_msg;
	
	@FindBy(xpath="//*[@id='main']/form/fieldset/div[3]/div/span")
	WebElement act_disc_dateError_msg;
	
	@FindBy(xpath="//a[@id='add']")
	WebElement clickAdd;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement computerName;
	
	@FindBy(css="#introduced")
	WebElement introduced;
	
	@FindBy(css="#discontinued")
	WebElement discontinued;
	
	@FindBy(css="#company")
	WebElement company_dropdown;
	
	@FindBy(css="input.btn.primary")
	WebElement clickCreate;
	
	@FindBy(xpath="//section[@id='main']/div[1]")
	WebElement act_success_msg;

	
	
	public WebElement validateCreateErrorMsg() {
		return act_createError_msg;
	}

	public WebElement validateIntroDateErrorMsg() {
		return act_intro_dateError_msg;
	}
	
	public WebElement validateDiscDateErrorMsg() {
		return act_disc_dateError_msg;
	}
	
	public WebElement clickAdd() {
		return clickAdd;
	}
	
	public WebElement computerName() {
		return computerName;
	}
	
	public WebElement enterIntroduced() {
		return introduced;
	}
	
	public WebElement enterDiscontinued() {
		return discontinued;
	}
	
	public void select_list(String Company){
	     Select companyDropdown=new Select(company_dropdown);
	     companyDropdown.selectByVisibleText(Company);
	}
	
	public WebElement actSuccessMsg() {
		return act_success_msg;
	}
	
	public WebElement clickCreate() {
		return clickCreate;
	}

}

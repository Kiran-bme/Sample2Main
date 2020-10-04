package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsDelete {

	public WebDriver driver;
	
	public PageObjectsDelete(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="#searchbox")
	WebElement searchComputer;
	
	@FindBy(css="#searchsubmit")
	WebElement clickSearch;
	
	@FindBy(xpath="//a[@href='/computers/381']")
	WebElement searchResult;
	
	@FindBy(css="input.btn.danger")
	WebElement clickDelete;
	
	@FindBy(xpath="//*[@id='main']/div[1]")
	WebElement act_successDelete_msg;

	

	public WebElement searchComputer() {
		return searchComputer;
	}
	
	public WebElement clickSearch() {
		return clickSearch;
	}
	
	public WebElement clickSearchResult() {
		return searchResult;
	}
	
	public WebElement actSuccessDeleteMsg() {
		return act_successDelete_msg;
	}
	
	public WebElement clickDelete() {
		return clickDelete;
	} 

}

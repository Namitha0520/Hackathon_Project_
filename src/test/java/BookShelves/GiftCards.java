
package BookShelves;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.ExcelUtils;


public class GiftCards extends BasePage {
	WebDriver driver;
	public static String[] data;
	
	
	//Constructor
	public GiftCards(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	//Locators
	@FindBy(xpath="//*[contains(text(),'Gift Cards')]") 
	WebElement card;
	@FindBy(xpath="//*[@class=\"_14QEd\"]/h2") 
	WebElement scroll;
	@FindBy(xpath="(//*[@class=\"_11b4v\"])[3]") 
	WebElement BirthdayCard;
	@FindBy(id="ip_2251506436") 
	WebElement amount;
	@FindBy(xpath="(//*[@class=\"Upz18 _1hLiD UJU2v\"])[1]") 
	WebElement months;
	@FindBy(xpath="(//*[@class=\"Upz18 _1hLiD UJU2v\"])[2]") 
	WebElement dates;
	@FindBy(xpath="//*[contains(text(),'Next')]") 
	WebElement next;
	@FindBy(id="ip_4036288348") 
	WebElement tname;
	@FindBy(id="ip_3177473671") 
	WebElement tnum;
	@FindBy(id="ip_137656023") 
	WebElement tmail;
	@FindBy(id="ip_1082986083") 
	WebElement fname;
	@FindBy(id="ip_2121573464") 
	WebElement fnum;
	@FindBy(id="ip_4081352456") 
	WebElement fmail;
	@FindBy(id="ip_2194351474") 
	WebElement faddress;
	@FindBy(id="ip_567727260") 
	WebElement fpin;
	@FindBy(xpath="//*[contains(text(),'Confirm the details')]") 
	WebElement text;
	@FindBy(className="dL47V") 
	List<WebElement> details;
	
	//Actions
	public String[] getData() throws IOException {
		   data=ExcelUtils.readExcelData("data");
		   return data;
	  }
	
	public void BirthdayCard(WebDriver driver) {	
		
		card.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		BirthdayCard.click();
	}
	
	public void CustomiseCard() {
		 
		amount.sendKeys("1500");
		Select month=new Select(months);
		month.selectByIndex(2);
		Select date=new Select(dates);
		date.selectByValue("22");
		next.click();
	}
	
	public void EnterInvalidDetails(WebDriver driver) {
		
		tname.sendKeys(data[0]);     
	    tnum.sendKeys("9885656536");     
	    tmail.sendKeys(data[1]);     
	    fname.sendKeys(data[2]);  
	    fnum.sendKeys("9390452210");	      
	    fmail.sendKeys(data[3]); 	     
	    faddress.sendKeys(data[4]);	     
	    fpin.sendKeys("600130");
	    WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Confirm')]")));
        element.click();
        
	 }
	
	public void EnterValidDetails(WebDriver driver) throws InterruptedException {
		
	    fmail.clear();
	    fmail.sendKeys(data[5]);     
	    WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Confirm')]")));
        element.click();
        Thread.sleep(2000);
		 
	 }
	
	public void validateDetails() {
		
		System.out.println("Page After the Confirm button is clicked:- "+text.getText());
		if(text.getText().equals("Confirm the details")) {
			System.out.println("All details are valid");
		}else {
			System.out.println("Details are Invalid");
		}
		System.out.println("~*~*~*~*~TO and FROM Details~*~*~*~*~");
		for(WebElement detail:details) {
			System.out.println("~~~**Details**~~~");
			System.out.println(detail.getText());
		}
	}
}

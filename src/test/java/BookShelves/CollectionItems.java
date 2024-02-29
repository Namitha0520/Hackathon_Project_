package BookShelves;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import setup.ExcelUtils;

public class CollectionItems extends BasePage{
	WebDriver driver;
	public static List<String> living;
	
	
	//Constructor
	public CollectionItems(WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	//Locators
	@FindBy(xpath="(//*[@class=\"topnav_itemname\"])[3]") 
	WebElement Living;	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[1]/ul/li") 
	List<WebElement> items;

	
	//Actions
	 public void selectCategory(WebDriver driver) {
 		
		 Living.click();
		 Actions act=new Actions(driver);
		 act.clickAndHold(Living);
		
	}
	public void RetriveElements() throws IOException {		
		
		 List<String> elements=new ArrayList<String>();		
		 System.out.println("Number of items in Seating &chairs:- "+items.size());
		 System.out.println("~~~~~*****List of Items*****~~~~~");
		 for(WebElement item:items) {
			 elements.add(item.getText());
				System.out.println(item.getText());
			}
		 
		 ExcelUtils eu = new ExcelUtils();
		 eu.writeData("Living",elements, 1, 0);
	}
}

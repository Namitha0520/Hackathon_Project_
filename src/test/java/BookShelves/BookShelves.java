package BookShelves;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import setup.ExcelUtils;



public class BookShelves extends BasePage {
	WebDriver driver;
	
	
	//Constructor
	public BookShelves(WebDriver driver)
	{
		super(driver);
	}

	
	//Locators
	@FindBy(id="search") 
	WebElement search;	
	@FindBy(id="search_button") 
	WebElement click;	
	@FindBy(xpath="//*[@class=\"close-reveal-modal hide-mobile\"]") 
	WebElement close;	
	@FindBy(xpath="(//*[@class=\"item\"])[1]") 
	WebElement category;
	@FindBy(id="filters_primary_category_Kids_Bookshelves") 
	WebElement select_category;
	@FindBy(xpath="(//*[@class=\"caret\"])[2]") 
	WebElement price;
	@FindBy(xpath="//*[@class=\"noUi-handle noUi-handle-lower\"]") 
	WebElement min;
	@FindBy(xpath="//*[@class=\"noUi-handle noUi-handle-upper\"]") 
	WebElement max;
	@FindBy(id="filters_availability_In_Stock_Only") 
	WebElement stock;
	@FindBy(xpath="(//*[@class=\"caret\"])[3]") 
	WebElement sort;
	@FindBy(xpath="//*[contains(text(),'High to Low')]") 
	WebElement sort_price;
	@FindBy(xpath="//*[@class=\"product-title product-title-sofa-mattresses\"]/span") 
	List<WebElement> names;
	@FindBy(xpath="//*[@class=\"price-number\"]/span") 
	List<WebElement> prices;
	

	//Actions
	public void BookShelvesPage() {
		
		search.sendKeys("BookShelves");
		click.click();
		close.isDisplayed();
		close.click();
	}
	
	public void Category() {
		
		category.click();
		select_category.click();
	}
	
	public void PriceSlider(WebDriver driver) throws InterruptedException {
		
		Actions act=new Actions(driver);
		act.clickAndHold(price).perform();
		Thread.sleep(5000);
		Actions move=new Actions(driver);
		move.dragAndDropBy(min, 0,0);
		move.build().perform();
		move.dragAndDropBy(max, -210,0);			
		move.build().perform();		
	}
	
	public void ExcludeStock() {
		
		stock.click();		
	}
	
	public void SortPrice() {
		
		sort.click();
		sort_price.click();
	}
	
	public void BookShelvesNamesPrices() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		int i=0;
		List<String> shelves_names = new ArrayList<String>();
		List<String> shelves_prices = new ArrayList<String>();
		System.out.println("~~~~~*****List of BookShelves*****~~~~~");

		for(WebElement name:names)
			{
			for(WebElement price:prices) {
				if(i==3)
					break;
				i++;
				shelves_names.add(name.getText());
				shelves_prices.add(price.getText());
				System.out.println("Name:- "+name.getText());
				System.out.println("Price:- "+price.getText());
			}
			}
		ExcelUtils eu = new ExcelUtils();
		eu.writeData("BookShelves",shelves_names, 1, 0);
		eu.writeData("BookShelves",shelves_prices, 1, 1);
	}
}

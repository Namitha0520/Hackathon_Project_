package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import BookShelves.BookShelves;
import testBase.BaseClass;

public class TC_001_BookShelves extends BaseClass {
	

	@Test(priority = 0,groups= "smoke")
	public void DisplayBookShelves() throws InterruptedException, IOException {

		logger.info("********* starting TC_001_DisplayBookShelves *********");
		BookShelves book = new BookShelves(driver);
		logger.info("Searching for BookShelves");
		book.BookShelvesPage();
		logger.info("Select Category");
		book.Category();
		logger.info("Performing Slider Action on Price");
		logger.info("Select Price Below 15000");
		book.PriceSlider(driver);
		logger.info("Exclude Out of Stock");
		book.ExcludeStock();
		logger.info("Sorting the Price");
		logger.info("Sort High to Low");
		book.SortPrice();
		logger.info("Display BookShelves After all Filters");
		book.BookShelvesNamesPrices();
		
	}

}

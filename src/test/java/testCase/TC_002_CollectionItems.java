package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import BookShelves.CollectionItems;
import testBase.BaseClass;

public class TC_002_CollectionItems extends BaseClass{
	
	
	@Test(priority = 1,groups= {"regression"})
	public void RetriveAllItems() throws IOException {
		
		logger.info("********* starting TC_002_RetriveAllItems *********");
		CollectionItems item=new CollectionItems(driver);
		logger.info("Go to Living Category-----");
		item.selectCategory(driver);
		logger.info("Selecting Submenu Item like Seating & Chairs");
		logger.info("Retrive All Submenu Items from Seating & Chairs");
		item.RetriveElements();
		
	}

}

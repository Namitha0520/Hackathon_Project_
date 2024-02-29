package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import BookShelves.GiftCards;
import testBase.BaseClass;

public class TC_003_GiftCards extends BaseClass {
	
	BaseClass base =new BaseClass();
	
	@Test(priority = 2,groups= {"smoke","regression"})
	public void GiftCard() throws InterruptedException, IOException {
		
		logger.info("********* starting TC_003_GiftCards *********");
		GiftCards gift=new GiftCards(driver);
		logger.info("Setting up Excel Sheet Read Data-----");
		gift.getData();
		logger.info("Go to GiftCards-----");
		logger.info("Scrolling upto BirthdayCard");
		logger.info("Select Birthday/Anniversary Card");
		gift.BirthdayCard(driver);
		base.captureScreen("Cards");
		logger.info("Entering the amount");
		logger.info("Select Month and Date");
		logger.info("Click on Next Button");
		gift.CustomiseCard();
		base.captureScreen("Customise");
		logger.info("Entering all Required Details with Invalid Email");
		logger.info("Click on Confirm Button");
		gift.EnterInvalidDetails(driver);
		base.captureScreen("InvalidDetails");
		logger.info("Entering all Required Details");
		logger.info("Click on Confirm Button");
		logger.info("Check the Confirm Details Page is Opened");
		logger.error("~~**~~❗Please include an '@' in the email address. 'namitha#gmail.com' is missing an '@'. ~~**~~");
		gift.EnterValidDetails(driver);
		logger.info("Validating all Details");
		gift.validateDetails();
		
	}

}

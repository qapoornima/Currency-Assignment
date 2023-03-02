package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CoinPageLocators;
import utils.Base;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class CoinStepsClass {

	WebDriver driver; 
	CoinPageLocators locators;
	Base base;

	private static Logger Log = Logger.getLogger(CoinStepsClass.class.getName());


	@Before
	public void setup() throws Exception
	{
		base = new Base();
		System.setProperty("webdriver.chrome.driver",base.getChromeDriver()); 
		driver = new ChromeDriver();
		locators=PageFactory.initElements(driver, CoinPageLocators.class);
		DOMConfigurator.configure(base.getLog4jConfigure());
	}

	@Given("^user launching the coin market application$")
	public void open_The_Coin_Market_Application() throws Throwable {
		Log.info("Logs for UI Filter scenario has started : ");
		driver.get(base.getApplicationUrl());
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(2000);
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("scroll(0,300)");
		Thread.sleep(2000);
	}

	@When("^user displaying the content by (\\d+) row$")
	public void select_value_From_Show_Rows_DropDown(int arg) throws Throwable {
		locators.MoveToShowRows();
		locators.clickOnShowRowsDropDownValue();
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("scroll(0,1500)");
	}

	@Then("^user caputre the required page content$")
	public void capture_Required_Page_Content() throws Throwable {

		List<WebElement> availableName=driver.findElements(locators.available_name);
		Log.info("Number of available names are:"+availableName.size());
		for(WebElement name:availableName) { 

			String availableNameDetail=name.getText(); 
			Thread.sleep(5000);
			Log.info("Available names are :"+availableNameDetail); 
		}

		List<WebElement> availablePrice=driver.findElements(locators.available_price);
		Log.info("Number of available prices are:"+availablePrice.size());
		for(WebElement price:availablePrice) {

			String availablePriceDetail=price.getText();
			Thread.sleep(5000);
			Log.info("Available prices are :"+availablePriceDetail); 
		}
	}

	@When("^user set the filter on the page by Algorith PoW$")
	public void set_Filter_By_Algorith_Pow() throws Throwable {
		locators.clickOnFiltersButton();
		locators.ClickOnAlgorithmDropDown();
		locators.MoveToAlgorithmDropDownList();
		locators.ClickOnPow();
	}

	@When("^user applying the  filter with Mineable,Coins and price range$")
	public void apply_Filter_With_Mineable_Coins_And_PriceRange() throws Throwable {
		locators.CliOnAddFilter();
		locators.mineable();
		Thread.sleep(2000);
		locators.clickOnAllCryptocurrencies(); 
		locators.clickOnCoins();
		locators.clickOnPrice();
		locators.addPriceMinValue();
		locators.addPriceMaxValue();
		locators.applyFilter();
		Thread.sleep(2000);
		locators.showResultsButton();    
	}
	@Then("^user capture the filtered content names and compare with the previous content name$")
	public void capture_Filter_Content_And_Compare_With_The_PreviousContent() throws Throwable {
		List<WebElement> filteredNames=driver.findElements(locators.filtered_name);
		Log.info("Number of Filter names are:"+filteredNames.size());
		for(WebElement name:filteredNames) {
			String filterNameDetail=name.getText();
			String availableNameDetail="Ethereum"; 

			if(filterNameDetail.contentEquals(availableNameDetail)) { 
				Log.info(filterNameDetail + "is available from the filtered rows");
			}
			else{
				Log.info(filterNameDetail+ "is not available from the filtered rows");
			}
		}
		Log.info("Logs for UI Filter has ended here");
	}

	@After
	public void tearDown() throws Exception
	{
		driver.close();
	}
}


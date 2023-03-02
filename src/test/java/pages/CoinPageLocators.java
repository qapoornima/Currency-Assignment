package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Base;

import org.openqa.selenium.interactions.Actions;


public class CoinPageLocators {


	WebDriver driver;
	Base base;

	public CoinPageLocators(WebDriver Idriver) throws Exception
	{
		base = new Base();
		this.driver=Idriver;
	}

	@FindBy(xpath="//button[contains(text(),'20')]") 
	WebElement showRowsButtonValue;

	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]")
	WebElement filtersButton;

	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]")
	WebElement algorithmDropdown;

	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]")
	WebElement OptionPoW;

	@FindBy(xpath="//button[text()='Add Filter']")
	WebElement addFilterButton;

	@FindBy(xpath="//label[@id='mineable']")
	WebElement mineableToggle;

	@FindBy(xpath="//button[text()='All Cryptocurrencies']")
	WebElement allCryptocurrenciesFilterButton;

	@FindBy(xpath="//button[text()='Coins']")
	WebElement coinsFilterButton;

	@FindBy(xpath="//button[text()='Price']")
	WebElement priceFilterButton;

	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement priceRangeMinValue;

	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement priceRangeMaxValue;

	@FindBy(xpath="//button[text()='Apply Filter']")
	WebElement applyFilterButton;

	@FindBy(xpath="//button[text()='Show results']")
	WebElement showResultsButton;

	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]")
	WebElement showRowsElement;

	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")
	WebElement algorithmDropDownListElement;

	public By available_name= By.xpath("//p[contains(text(),'Name')]//following::p[@class='sc-e225a64a-0 ePTNty']");
	public By available_price= By.xpath("//p[contains(text(),'Price')]//following::div[@class='sc-8bda0120-0 dskdZn']");
	public By filtered_name= By.xpath("//p[contains(text(),'Name')]//following::p[@class='sc-e225a64a-0 ePTNty']");

	public void MoveToShowRows() {
		Actions act=new Actions(driver);
		act.moveToElement(showRowsElement).click().build().perform();
	}
	public void MoveToAlgorithmDropDownList() {
		Actions act=new Actions(driver);
		act.moveToElement(algorithmDropDownListElement).click().build().perform();
	}

	public void clickOnShowRowsDropDownValue()
	{
		showRowsButtonValue.click();
	}

	public void clickOnFiltersButton()
	{
		filtersButton.click();
	}

	public void ClickOnAlgorithmDropDown()
	{
		algorithmDropdown.click();
	}

	public void ClickOnPow()
	{
		OptionPoW.click();
	}

	public void CliOnAddFilter()
	{
		addFilterButton.click();
	}

	public void mineable()
	{
		mineableToggle.click();
	}

	public void clickOnAllCryptocurrencies()
	{
		allCryptocurrenciesFilterButton.click();
	}

	public void clickOnCoins()
	{
		coinsFilterButton.click();
	}

	public void clickOnPrice()
	{
		priceFilterButton.click();
	}

	public void addPriceMinValue()
	{
		priceRangeMinValue.sendKeys(base.getFirstPriceValue());
	}

	public void addPriceMaxValue()
	{
		priceRangeMaxValue.sendKeys(base.getSecondPriceValue());
	}

	public void applyFilter()
	{
		applyFilterButton.click();
	}

	public void showResultsButton()
	{
		showResultsButton.click();
	}
	}

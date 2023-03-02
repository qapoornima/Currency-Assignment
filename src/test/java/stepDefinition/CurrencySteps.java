package stepDefinition;


import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import utils.Base;
import utils.CurrencyConversion;
import org.apache.log4j.Logger;

public class CurrencySteps {

	CurrencyConversion conversion;
	Base base;
	String firstConversionValue;

	private static Logger Log = Logger.getLogger(CurrencySteps.class.getName());

	@Before
	public void setup() throws Exception
	{
		base = new Base();
		conversion= new CurrencyConversion();
		RestAssured.baseURI = "https://pro-api.coinmarketcap.com/";
	}

	@When("^user set the amount and get the first currency conversion value from Guatemalan Quetzal to British pounds$")
	public void set_the_amount_get_the_first_currency_conversion() throws Throwable {
		Log.info("Logs for API Currency conversion scenario has started : ");
		firstConversionValue = conversion.getpriceconversionvalue(base.getAmount(),base.getSymbol(),base.getFirstconversionCurrency());
		Log.info("First Conversion from GTQ to GBP is " + " "+ firstConversionValue +" ");
	}

	@Then("^user get the final conversion of the currency from GBP to doge coin$") 
	public void get_the_final_conversion_of_the_currency_from_GBP_to_doge_coin() throws Throwable { 
		double FirstConvertedCurrency  = Double.parseDouble(firstConversionValue);
		String FinalConversion = conversion.getpriceconversionvalue(FirstConvertedCurrency,base.getFirstconversionCurrency(),base.getFinalconversionCurrency());
		Log.info( "Final Conversion from GBP to doge coin is " +FinalConversion);
		int responseCode = conversion.getResponseCode();
		Log.info( " Response code is " +responseCode);
		Log.info("Logs for API Currency conversion scenario has ended here : ");
	}
}

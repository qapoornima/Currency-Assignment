package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Base  {
	Properties properties;

	public Base() throws Exception
	{
		File src=new File("src\\test\\resources\\property\\TestDataProperties.property");
		FileInputStream file=new FileInputStream(src);
		properties=new Properties();
		properties.load(file);
	}

	public String getChromeDriver()
	{
		return properties.getProperty("ChromeDriver");
	}
	public String getApplicationUrl()
	{
		return properties.getProperty("ApplicationURL");
	}
	public String getLog4jConfigure()
	{
		return properties.getProperty("Log4jConfigure");
	}

	public String getFirstPriceValue()
	{
		return properties.getProperty("FirstPriceTextValue");
	}
	public String getSecondPriceValue()
	{
		return properties.getProperty("SecondPriceTextValue");
	}
	public double getAmount()
	{
		String givenamount=properties.getProperty("GetAmount");
		double doubleValue=Double.parseDouble(givenamount);
		return doubleValue;
	}
	public String getSymbol()
	{
		return properties.getProperty("CurrentCurrencySymbol");
	}
	public String getFirstconversionCurrency()
	{
		return properties.getProperty("FirstConversionCurrency");
	}

	public String getFinalconversionCurrency()
	{
		return properties.getProperty("FinalCurrencyCurrency");
	}
}

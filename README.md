## Table of contents

Requirements

Recommended modules

Installation

Configuration

Element Locators

Test Data 

Logs

Execution Process
  



## Requirements

Java(Version 1.8.0_202)

junit(Version 4.11)

log4j(Version 1.2.2)

cucumber(Version 7.11.1)

rest-assured(4.2.0)



## Recommended module

https://coinmarketcap.com/

https://pro-api.coinmarketcap.com/

## Installation

Add all the required dependencies in POM.xml file

##  Configuration
Keep all module wise scenarios in simple english language in src/test/resources/feature/Coin.feature file and Currency.feature file


## Element Locators

All locators will be written on src/test/java/pages/CoinPageLocators class for UI scenario only

## Test Data 

All Test data are keep in src/test/resources/property/TestDataProperties file

Common Methods are in src/test/java/utils/Base class 

One Common method is in src/test/java/utils/CurrencyConversion class for API related scenario only

## Logs

All captured data will be written in src/test/resources/log/contentlogs file 

## Execution Process

Execution will be initiate from the src/test/java/runnner/RunnerClass for both the scenarios


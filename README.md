# TradeLing_Software_QA_Challenge_MohamedAteif

This project is to solve the QA challenge from Tradeling. The Project is representing three end-to-end tests to demonstrate my test automation abilities. MR. Sharma gave me the option to do the project in two different frameworks to demonstrate my skills in both of them and this is what was done and submited in the repo.
## Acceptance Criteria
first end-to-end test that
1.Starts on the landing page
2.Click the link view more market
3.Clicks the ETH/BTC button leading to Pair trading view
4.Verifies that all important information is loaded, e.g. trading chart, limit, market, stop limit input boxes, etc. (leaving this purposefully open to see what you think makes sense to test)

second end-to-end test that

1.Starts on the Pair trading view
2.Enters some valid values into the Buy ETH form
3.Make sure the Total field has the correct value (Total = price * Amount)
4.Verifies that you can't submit the form since you are not logged in
5.Write a data last end-to-end (WebSockets) test that

Starts on the Pair trading view
Under the hood, the UI uses WebSockets to fetch tickers
Verifies that the data is loaded in the tickers,
Verifies there is a consistent stream of data.
Verifies the time it takes the socket connection to connect is less than 1 second

## Used Test Framework

1. TestNG with Java
2. Nightwatch with Javascript

## Used Building tool for the java programm
1. Apache Maven

## prerequisites for the java project:

1. java version 1.8.0_151
2. maven version  3.6.1
3. java and maven environment variables are added to system environment variable


## project installation:
1. clone the project from the repo to your machine
2. open terminal in the project directory and type `Java -version`
3. if your version is lower than 1.8.0_151 , please download and install java jdk from here https://www.oracle.com/technetwork/java/javase/downloads/index.html
4. in the terminal try to check if you have maven installed by : `mvn -version` . please if you couldn't find it in your machine download it and install it.
5. please make sure to add java and maven to your environment variables
6. from the BinanceJava folder cut the Binance folder and paste it in user home in user home. this is important for logs
7. you can find chromedriver file in the BinanceJava folder please copy it to user home or download the suitable chromedriver.exe for your browser version and place it in user home
URL for download: https://chromedriver.chromium.org/downloads

## Executing test:
1. to run the java Test open terminal in the project directory and use the command `mvn install`
2. to run Nightwatch Test open terminal in the project directory and use the command `node nightwatch -e`

## Credits

I have developed all the framework from scratch by created the POM.xml for the java project. this file contains all the used libraries to be downloaded on the run when running the project. for log we used LOG4J which is an apache opensource tool and you can fine all logs in the Binance folder that we moved to user home.

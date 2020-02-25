package base;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class Base {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties OR;
	public static Properties Config;
	public static WebDriverWait wait;
	public static ExcelReader excel = new ExcelReader("src/test/resources/Excel/TestData.xlsx");
	public static Logger log = Logger.getLogger(Base.class);

	public Base() {
		// Loading the config file
		
		
		PropertyConfigurator.configure("src/test/resources/Properties/log4j.properties");
		log.info("log4j file is loaded");
		
		try {
			Config = new Properties();
			fis = new FileInputStream(
					"C:/Users/nepl/eclipse-workspace/PageObjectModel/src/test/resources/Properties/Config.properties");
			Config.load(fis);
			log.info("Config is loaded");
		} catch (Exception e) {
			System.out.println("Config File not uploaded");
		}

		// Loading the OR file
		try {
			OR = new Properties();
			fis = new FileInputStream(
					"C:/Users/nepl/eclipse-workspace/PageObjectModel/src/test/resources/Properties/OR.properties");
			OR.load(fis);
			log.info("OR is loaded");
		} catch (Exception e) {
			System.out.println("OR file is uploaded");
		}

		

	}

	public  void initBrowser(String browser) {

		if ("chrome".equals(browser.toLowerCase())) {

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-infobar");
			//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			cap.setCapability(ChromeOptions.CAPABILITY, options);

			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "D:\\chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			
		} else if ("firefox".equals(browser.toLowerCase())) {
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "D:\\firefox.txt");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		} else if ("ie".equals(browser.toLowerCase())) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		} else if ("edge".equals(browser.toLowerCase())) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
		} else {
			System.out.println("Enter the valid browser");
		}
		log.info("Browser launched" + browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public  void launchURL()
	{
		driver.get("https://accounts.staging.miso3app.com");
	}
	
	public  void tearDown()
	{
		driver.quit();
	}

}

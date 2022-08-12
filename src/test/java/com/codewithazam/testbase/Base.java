package com.codewithazam.testbase;

import com.codewithazam.utils.ConfigsReader;
import com.codewithazam.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Base {

    public static WebDriver driver;
    /**
     * This method will create the driver and return it.
     *
     * @return
     */
    public static WebDriver setUp() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.getProperty("browser").toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        driver.manage().window().maximize();

        driver.get(ConfigsReader.getProperty("url"));

        PageInitializer.initialize();

        return driver;
    }

    /**
     * This method will quit the browser
     */
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

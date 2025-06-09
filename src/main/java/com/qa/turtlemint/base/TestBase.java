package com.qa.turtlemint.base;

import com.qa.turtlemint.util.LogUtils;
import com.qa.turtlemint.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/turtlemint/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        LogUtils.info("Browser name: " + browserName);
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();

            // Stealth ChromeOptions
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features=AutomationControlled");

            // Exclude automation flags
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            // For Linux headless if needed
            String osName = System.getProperty("os.name");
            LogUtils.info("osName: " + osName);
            if (osName.toLowerCase().contains("linux")) {
                options.addArguments("--headless");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            }

            // Set system property if needed (make sure your chromedriver path is correct)
            // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_time, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

            // After driver creation, override navigator.webdriver via JS (Step 2 will expand on this)
            ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        }
    }

}

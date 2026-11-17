package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class WebpageTest {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        File file = new File(
                "src/main/resources/Website/index.html"
        );

        driver.get(file.toURI().toString());
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();

        System.out.println("Page title: " + actualTitle);

        Assert.assertFalse(actualTitle.isEmpty());
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
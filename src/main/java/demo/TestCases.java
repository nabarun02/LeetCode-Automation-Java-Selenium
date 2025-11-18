package demo;

import java.beans.Transient;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    
    ChromeDriver driver;
    
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){

        System.out.println("Start Test case: testCase01: Verify the Leetcode Homepage URL");
        
        driver.get("https://leetcode.com/");

        String curUrl = driver.getCurrentUrl();

        if(curUrl.contains("leetcode")){
            System.out.println("TestCase01: Verify that the Leetcode homepage URL contains 'leetcode': PASS");
        }

        else{
            System.out.println("TestCase01: Verify that the Leetcode homepage URL contains 'leetcode': FAIL");
        }

        System.out.println("End Test case: testCase01: Verify the Leetcode Homepage URL");

    }

    public void testCase02(){

        System.out.println("Start Test case: testCase02: Verify Problem Set URL and Display First 5 Questions");

        driver.get("https://leetcode.com/");

        WebElement questionLink = driver.findElement(By.xpath("//p[normalize-space(text()) = 'View Questions']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", questionLink);

        questionLink.click();

        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("problemset")){

            List<WebElement> questions = driver.findElements(By.xpath("(//a[contains(@href, '/problems/')])[position() > 1 and position() < 7]//div[contains(@class, 'ellipsis line-clamp-1')]"));
            
            for(WebElement question : questions){
                System.out.println(question.getText());
            }

            WebElement firstQuestion = driver.findElement(By.xpath("//a[contains(@href, '/problems/') and @id = '1']"));

            firstQuestion.click();

            WebElement questionTitle = driver.findElement(By.xpath("//a[contains(@href, '/problems/') and contains(@class, 'no-underline')]"));

            if(questionTitle.getText().trim().equals("1. Two Sum")){
                System.out.println("TestCase02: Retrieve details of the first 5 questions on the problems page: PASS");
            }

            else{
                System.out.println("TestCase02: Retrieve details of the first 5 questions on the problems page: FAIL");
            }

        }

        else{
                System.out.println("TestCase02: Retrieve details of the first 5 questions on the problems page: FAIL");
        }

        System.out.println("End Test case: testCase02: Verify Problem Set URL and Display First 5 Questions");

    }

    public void testCase03(){

        System.out.println("Start Test case: testCase03: Verify the Two Sum problem");

        driver.get("https://leetcode.com/");


        WebElement questionLink = driver.findElement(By.xpath("//p[normalize-space(text()) = 'View Questions']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", questionLink);

        questionLink.click();

        WebElement firstQuestion = driver.findElement(By.xpath("//a[contains(@href, '/problems/') and @id = '1']"));

        firstQuestion.click();

        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.contains("two-sum")){
            System.out.println("TestCase03: Open the Two Sum problem and verify the URL: PASS");
        }

        else{
            System.out.println("TestCase03: Open the Two Sum problem and verify the URL: FAIL");
        }

        System.out.println("End Test case: testCase03: Verify the Two Sum problem");

    }

    public void testCase04(){

        System.out.println("Start Test case: testCase04: Ensure the submissions tab displays 'Register or Login'");

        driver.get("https://leetcode.com/");


        WebElement questionLink = driver.findElement(By.xpath("//p[normalize-space(text()) = 'View Questions']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", questionLink);

        questionLink.click();

        WebElement firstQuestion = driver.findElement(By.xpath("//a[contains(@href, '/problems/') and @id = '1']"));

        firstQuestion.click();

        WebElement submissionsTab = driver.findElement(By.xpath("//div[normalize-space(text()) = 'Submissions'][2]"));

        submissionsTab.click();

        WebElement registerLoginButton = driver.findElement(By.xpath("//a[contains(@class, 'whitespace-nowrap')]"));

        String registerLoginButtonText = registerLoginButton.getText();

        if(registerLoginButtonText.contains("Register or Log in")){
            System.out.println("TestCase04: Check the submissions tab and verify if it displays 'Register or Login': PASS");
        }

        else{
            System.out.println("TestCase04: Check the submissions tab and verify if it displays 'Register or Login': FAIL");
        }

        System.out.println("End Test case: testCase04: Ensure the submissions tab displays 'Register or Login'");

    }





}

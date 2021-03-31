package climatehacks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NavigationClimateHacks {
    public static String browser = "chrome"; // External configuration -XLS, CVS
    public static WebDriver driver;
    //private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeMethod
    public void invokeTheDriver(){

        System.out.println("Invoke the driver");
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void closeTheDriver(){
        System.out.println("Close the driver");
        driver.quit();
    }

    /*@BeforeMethod
    public void openTheWebsite(){

        System.out.println("Open the website");
        driver.manage().deleteAllCookies();

    }*/

    /*@AfterMethod
    public void closeTheWebsite(){
        System.out.println("Close the website");
    }*/

    @Test(priority = 1, description = "Navigation at 'Get Started' test")
    public void NavigationAtHomeGetStart(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_banner_main > div > div.col-lg-5 > div > a")).click();
        //hard code
        Set<String> windowshandle = driver.getWindowHandles();
        //System.out.println(windowshandle);

        Iterator<String> iterator = windowshandle.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        //System.out.println(parentWindow);
        //System.out.println(childWindow);

        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        String actualTitle = driver.getTitle();
        //System.out.println(title);

        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at 'Get Started' successfully");

    }
//Here is a bug here
    @Test(priority = 2, description = "Navigation at Play Button at Home Page")
    public void NavigationAtHomePlayButton(){
        driver.get("https://climatehacks.dev/");

        WebElement element = driver.findElement(By.xpath("/html/body/section[3]/div/div/div[1]/div/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div/div/div[1]/div/div/a"))).click();
        //String currentUrl =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        //String title = driver.getTitle();
        //System.out.println(title);

        System.out.println("Navigation at Play Button at Home Page successfully");

    }

    @Test(priority = 3, description = "Navigation at Best UI at Home Page")
    public void NavigationAtBestUIAtHomePage(){

        driver.get("https://climatehacks.dev/");

        WebElement BestUI = driver.findElement(By.xpath("/html/body/section[5]/div/div/div[1]/div/div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(BestUI).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[5]/div/div/div[1]/div/div[2]/a/h2"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();
        //System.out.println(windowshandle);

        Iterator<String> iterator = windowshandle.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        //System.out.println(parentWindow);
        //System.out.println(childWindow);

        driver.switchTo().window(childWindow);
        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);


        System.out.println("Navigation at Best UI at Home Page successfully");
    }

    @Test(priority = 4, description = "Navigation at Best Pitch At Home Page")
    public void NavigationAtBestPitchAtHomePage(){
        driver.get("https://climatehacks.dev/");

        WebElement BestPitch = driver.findElement(By.xpath("/html/body/section[5]/div/div/div[2]/div/div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(BestPitch).perform();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[5]/div/div/div[2]/div/div[2]/a/h2"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);
        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Best Pitch At Home Page successfully");
    }

    @Test(priority = 5, description = "Navigation at Most Energy Efficient At Home Page")
    public void NavigationAtMostEnergyEfficientAtHomePage(){
        driver.get("https://climatehacks.dev/");

        WebElement MostEnergyEfficient = driver.findElement(By.xpath("/html/body/section[5]/div/div/div[3]/div/div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(MostEnergyEfficient).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[5]/div/div/div[3]/div/div[2]/a/h2"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);
        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Most Energy Efficient At Home Page successfully");
    }

    @Test(priority = 6, description = "Navigation at Best Blockchain At Home Page")
    public void NavigationAtBestBlockchainAtHomePage(){

        driver.get("https://climatehacks.dev/");

        WebElement BestBlockchain = driver.findElement(By.xpath("/html/body/section[5]/div/div/div[4]/div/div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(BestBlockchain).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[5]/div/div/div[4]/div/div[2]/a/h2"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);
        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);
        System.out.println("Navigation at Best Blockchain At Home Page successfully");
    }

    @Test(priority = 7, description = "Navigation at What Students Are Saying Left Button")
    public void NavigationatWhatStudentsAreSayingLeftButton(){
        driver.get("https://climatehacks.dev/");
        WebElement leftButton = driver.findElement(By.xpath("/html/body/section[6]/div/div[2]/div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(leftButton).click().perform();
        System.out.println("Navigation at What Students Are Saying Left Button successfully");
    }

    @Test(priority = 8, description = "Navigation at What Students Are Saying Right Button")
    public void NavigationatWhatStudentsAreSayingRightButton(){

        driver.get("https://climatehacks.dev/");
        WebElement rightButton = driver.findElement(By.xpath("/html/body/section[6]/div/div[2]/div[2]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(rightButton).click().perform();
        System.out.println("Navigation at What Students Are Saying Right Button successfully");
    }
    //How to test swipe-slide
    @Test(priority = 9, description = "Navigation At How to Start Learning Now At Home Page")
    public void NavigationAtHowtoStartLearningNowAtHomePage(){
        driver.get("https://climatehacks.dev/");
        WebElement Learning = driver.findElement(By.xpath("/html/body/section[7]/div/div/div/div[6]/div/a/img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(Learning).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[7]/div/div/div/div[6]/div/a/img"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation At How to Start Learning Now At Home Page");
    }
    @Test(priority = 10, description = "Navigation At Registration Open for ClimateHacks At Home Page")
    public void NavigationAtRegistrationOpenforClimateHacksAtHomePage(){
        driver.get("https://climatehacks.dev/");
        WebElement  dailyChallenge= driver.findElement(By.xpath("/html/body/section[7]/div/div/div/div[7]/div/a/img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(dailyChallenge).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[7]/div/div/div/div[7]/div/a/img"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation At Registration Open for ClimateHacks At Home Page");
    }


    @Test(priority = 11, description = "Navigation At Join Discord At Home Page")
    public void NavigationAtJoinDiscordAtHomePage(){
        driver.get("https://climatehacks.dev/");
        WebElement joinDiscord = driver.findElement(By.xpath("/html/body/section[7]/div/div/div/div[8]/div/a/img"));

        Actions actions = new Actions(driver);
        actions.moveToElement(joinDiscord).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[7]/div/div/div/div[8]/div/a/img"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation At Join Discord At Home Page");
    }
    @Test(priority = 12, description = "Navigation At SignUp At Stay Connected With Us At Home page")
    public void NavigationAtSignUpAtStayConnectedWithUsAtHomePage(){
        driver.get("https://climatehacks.dev/");
        WebElement signUp = driver.findElement(By.xpath("/html/body/section[8]/div/div"));

        Actions actions = new Actions(driver);
        actions.moveToElement(signUp).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[8]/div/div/div/div[2]/div/button"))).click();

        //hard code
        Set<String> windowshandle = driver.getWindowHandles();

        Iterator<String> iterator = windowshandle.iterator();
        iterator.next();
        String childWindow = iterator.next();


        driver.switchTo().window(childWindow);

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(actualWebsite);

        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation At SignUp At Stay Connected With Us At Home pagesuccessfully");
    }

}

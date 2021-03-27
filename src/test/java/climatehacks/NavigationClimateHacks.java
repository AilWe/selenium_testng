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

    @BeforeTest
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
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }


    @AfterTest
    public void closeTheDriver(){
        System.out.println("Close the driver");
        driver.quit();
    }

    @BeforeMethod
    public void openTheWebsite(){

        System.out.println("Open the website");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeTheWebsite(){
        System.out.println("Close the website");
    }

    /*@Test(priority = 1, description = "Navigation at 'Get Started' test")
    public void NavigationAtTopHomeSymbol(){
        driver.get("https://climatehacks.dev/");
        driver.findElement(By.cssSelector("body > section.ss_index_one > div > div.ss_banner_main > div > div.col-lg-5 > div > a")).click();

        String actualWebsite =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        String actualTitle = driver.getTitle();
        //System.out.println(title);

        String expectWebsite= "https://climatehacks.devpost.com/";
        String expectTitle = "ClimateHacks: Making a change for climate change - Devpost";

        Assert.assertEquals(actualTitle, expectTitle);
        Assert.assertEquals(actualWebsite,expectWebsite);

        System.out.println("Navigation at 'Get Started' successfully");

    }*/
//Here is a bug here
    /*@Test(priority = 2, description = "Navigation at Play Button at Home Page")
    public void NavigationAtTopCourse(){
        driver.get("https://climatehacks.dev/");

        WebElement element = driver.findElement(By.xpath("/html/body/section[3]/div/div/div[1]/div/div"));
        //Actions action = new Actions(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[3]/div/div/div[1]/div/div/a/svg"))).click();
        //String currentUrl =  driver.getCurrentUrl();
        //System.out.println(currentUrl);

        //String title = driver.getTitle();
        //System.out.println(title);

        System.out.println("Navigation at Play Button at Home Page successfully");

    }*/

    /*@Test(priority = 3, description = "Navigation at Best UI at Home Page")
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
    }*/

    @Test(priority = 4, description = "Navigation at Best Pitch$500 At Home Page")
    public void NavigationAtBestPitchAtHomePage(){
        driver.get("https://climatehacks.dev/");

        WebElement BestUI = driver.findElement(By.xpath("/html/body/section[5]/div/div/div[2]/div/div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(BestUI).perform();


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
        System.out.println("Navigation at Best Pitch$500 At Home Page successfully");
    }

    /*@Test(priority = 5, description = "Navigation at Bottom Home Symbol test")
    public void NavigationAtBottomHomeSymbol(){
        driver.findElement(By.cssSelector(".col-3 > a > img")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to home page successfully");
    }

    @Test(priority = 6, description = "Navigation to Bottom Home  test")
    public void NavigationAtBottomHome(){

        driver.findElement(By.cssSelector(".col-3:nth-child(2) > a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to home page successfully");
    }

    @Test(priority = 7, description = "Navigation at Bottom About Us test")
    public void NavigationAtBottomAboutUs(){
        driver.findElement(By.cssSelector(".col-3:nth-child(2) > a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to about us successfully");
    }

    @Test(priority = 8, description = "Navigation at Learn More test")
    public void NavigationAtLearnMore(){

        driver.findElement(By.linkText("LEARN MORE")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to about us successfully");
    }

    @Test(priority = 9, description = "Navigation At View Lesson 1")
    public void NavigationAtViewLesson1(){

        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[6]/div/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Lesson 1 successfully");
    }
    @Test(priority = 10, description = "Navigation At Start Course 1")
    public void NavigationAtStartCourse1(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[6]/div/div/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Course 1 successfully");
    }


    @Test(priority = 11, description = "Navigation At View Lesson 2")

    public void NavigationAtViewLesson2(){

        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[7]/div/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Lesson 2 successfully");
    }
    @Test(priority = 12, description = "Navigation At Start Course 2")
    public void NavigationAtStartCourse2(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[7]/div/div/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Course 2 successfully");
    }

    @Test(priority = 13, description = "Navigation At View Lesson 3")
    public void NavigationAtViewLesson3(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[8]/div/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Lesson 3 successfully");
    }
    @Test(priority = 14, description = "Navigation At Start Course 3")
    public void NavigationAtStartCourse3(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[8]/div/div/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Course 3 successfully");
    }

    @Test(priority = 15, description = "Navigation At View Lesson 4")
    public void NavigationAtViewLesson4(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[2]/li[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[9]/div/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Lesson 4 successfully");
    }

    @Test(priority = 16, description = "Navigation At Start Course 4")
    public void NavigationAtStartCourse4(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[2]/li[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[9]/div/div/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Course 4 successfully");
    }

    @Test(priority = 17, description = "Navigation At View Lesson 5")
    public void NavigationAtViewLesson5(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[2]/li[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[10]/div/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Lesson 5 successfully");
    }


    @Test(priority = 18, description = "Navigation At Start Course 5")
    public void NavigationAtStartCourse5(){
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[2]/li[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/section[3]/div/div/div/ul[1]/li[10]/div/div/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/div/a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to Course 5 successfully");
    }*/

}

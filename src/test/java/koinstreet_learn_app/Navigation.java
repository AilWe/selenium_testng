package koinstreet_learn_app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Navigation {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeTest
    public void invokeTheDriver(){

        System.out.println("Invoke the driver");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://koinstreet-learn.herokuapp.com/");
    }

    @AfterMethod
    public void closeTheWebsite(){
        System.out.println("Close the website");
    }

    @Test(priority = 1, description = "Navigation at Top Home Symbol test")
    public void NavigationAtTopHomeSymbol(){
        driver.findElement(By.cssSelector(".active > img")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to home page successfully");

    }

    @Test(priority = 2, description = "Navigation at Top Course test")
    public void NavigationAtTopCourse(){
        driver.findElement(By.cssSelector(".navigation__wrapper .active")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to home page successfully");

    }

    @Test(priority = 3, description = "Navigation at Top About Us test")
    public void NavigationAtTopAboutUs(){

        driver.findElement(By.cssSelector(".navigation__wrapper > li:nth-child(3) > a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to about us successfully");
    }

    @Test(priority = 4, description = "Navigation at Top Contact Us test")
    public void NavigationAtTopContactUs(){
        driver.findElement(By.cssSelector("li:nth-child(4) > a")).click();

        String currentUrl =  driver.getCurrentUrl();
        System.out.println(currentUrl);

        String title = driver.getTitle();
        System.out.println(title);

        System.out.println("Navigation to contact us successfully");
    }

    @Test(priority = 5, description = "Navigation at Bottom Home Symbol test")
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
    }



}

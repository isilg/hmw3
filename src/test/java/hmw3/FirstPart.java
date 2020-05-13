package hmw3;

import Utility.BrowserUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstPart {
    private WebDriver driver;

    private By cPlusBy = By.xpath("//input[@id='inlineCheckbox1']");
    private By javaBy = By.xpath("//input[@id='inlineCheckbox2']");
    private By jsBy = By.xpath("//input[@id='inlineCheckbox3']");

    private By firstNameBy = By.xpath("//input[@class='form-control' and @name='firstname']");
    private By lastNameBy = By.xpath("//input[@class='form-control' and @name='lastname']");
    private By usernameBy = By.xpath("//input[@class='form-control' and @name='username']");
    private By emailBy = By.xpath("//input[@class='form-control' and @name='email']");
    private By passwordBy = By.xpath("//input[@class='form-control' and @name='password']");
    private By phoneBy = By.xpath("//input[@class='form-control' and @name='phone']");

    private By femaleBy = By.cssSelector("input[value='female']");
    private By maleBy = By.cssSelector("input[value='male']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dobBy = By.cssSelector("input[name='birthday']");
    private By departmentBy = By.cssSelector("select[name='department']");
    private By jobTitleBy = By.cssSelector("select[name='job_title']");

    private By submitButtonBy = By.id("wooden_spoon");


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        BrowserUtility.wait(2);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtility.wait(2);
        driver.manage().window().maximize();
    }


    //Test case#1
    @Test(description = "Verify warning message displayed")
    public void dobWrongMessageTest() {
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("123");
        BrowserUtility.wait(2);
        WebElement message = driver.findElement(By.xpath("//small[@class='help-block' and text()='The date of birth is not valid']"));
        BrowserUtility.wait(2);
        Assert.assertTrue(message.isDisplayed());
    }


    //Test Case#2
    @Test(description = "verify c++, java, javascript displayed")
    public void progLangTest() {
        driver.findElement(cPlusBy).isDisplayed();
        BrowserUtility.wait(2);
        driver.findElement(javaBy).isDisplayed();
        BrowserUtility.wait(2);
        driver.findElement(jsBy).isDisplayed();
        BrowserUtility.wait(2);
    }

    //Test Case#3
    @Test(description = "Enter one alphabetic character into first name input box and verify the warning message is displayed")
    public void firstNameMessageTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        WebElement message = driver.findElement(By.xpath("//small[@class='help-block' and text()='first name must be more than 2 and less than 64 characters long']"));
        BrowserUtility.wait(2);
        Assert.assertTrue(message.isDisplayed());
    }


    //Test Case#4
    @Test(description = "Enter one alphabetic character into last name input box and verify the warning message is displayed")
    public void lastNameInputBoxMessageTest(){
        driver.findElement(lastNameBy).sendKeys("a");
        WebElement message = driver.findElement(By.xpath("//input[@class='form-control' and @name='lastname']"));
        BrowserUtility.wait(2);
        Assert.assertTrue(message.isDisplayed());
    }


    //Test Case#5
    @Test(description = "After entering necessary info and click submit button verify if success message is displayed")
    public void successMessageTest(){
        driver.findElement(firstNameBy).sendKeys("katie");
        BrowserUtility.wait(2);
        driver.findElement(lastNameBy).sendKeys("Mandel");
        BrowserUtility.wait(2);
        driver.findElement(usernameBy).sendKeys("katman");
        BrowserUtility.wait(2);
        driver.findElement(emailBy).sendKeys("katman@cybertek.com");
        BrowserUtility.wait(2);
        driver.findElement(passwordBy).sendKeys("12345678");
        BrowserUtility.wait(2);
        driver.findElement(phoneBy).sendKeys("123-456-7890");
        BrowserUtility.wait(2);
        driver.findElement(femaleBy).click();
        BrowserUtility.wait(2);
        driver.findElement(dobBy).sendKeys("05/06/1988");
        BrowserUtility.wait(2);

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Engineering");
        BrowserUtility.wait(2);

        Select jobSelect = new Select(driver.findElement(jobTitleBy));
        jobSelect.selectByVisibleText("SDET");
        BrowserUtility.wait(2);

        driver.findElement(cPlusBy).click();
        driver.findElement(javaBy).click();
        driver.findElement(jsBy).click();
        BrowserUtility.wait(2);

        driver.findElement(submitButtonBy).click();

    }


    @AfterMethod
    public void teardown()  {
        driver.quit();
        BrowserUtility.wait(2);
    }

}
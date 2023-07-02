import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LearningLocators {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Login web thực hành
        driver.get("https://crm.anhtester.com/admin/authentication");
        //Điền thông tin đăng nhập và Login
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Case 1: Kiểm tra khả năng login
        WebElement loginpage = driver.findElement(By.xpath("//li[@class='menu-item-dashboard active']"));
        if (loginpage.isDisplayed()) {
            System.out.println("Case 1: Passed");
        } else {
            System.out.println("Case 1: Failed");
        }

        //Lấy xpath button Customers
        driver.findElement(By.xpath("//a[@href='https://crm.anhtester.com/admin/clients']")).click();
        //Case 2: Kiểm tra hiển thị page Customers
        WebElement customepage = driver.findElement(By.xpath("(//span[normalize-space()='Customers Summary'])[1]"));
        if (customepage.isDisplayed()) {
            System.out.println("Case 2: Passed");
        } else {
            System.out.println("Case 2: Failed");
        }

        //Mở tạo mới Customer
        driver.findElement(By.xpath("(//a[normalize-space()='New Customer'])[1]")).click();
        //Case 3: Kiểm tra hiển th trang tạo mới Customer
        WebElement newcustomer = driver.findElement(By.xpath("(//a[normalize-space()='Customer Details'])[1]"));
        if (newcustomer.isDisplayed()) {
            System.out.println("Case 3: Passed");
        } else {
            System.out.println("Case 3: Failed");
        }

        //Case 4: Kiểm tra click Save khi chưa điền thông tin gì
        driver.findElement(By.xpath("//button[@class='btn btn-primary only-save customer-form-submiter']")).click();
        WebElement Error = driver.findElement(By.xpath("//p[@id='company-error']"));
        if (Error.isDisplayed()) {
            System.out.println("Case 4: Passed");
        } else {
            System.out.println("Case 4: Failed");
        }

        //Case5: Click Mở trang Project
        driver.findElement(By.xpath("//a[@href='https://crm.anhtester.com/admin/projects']")).click();
        WebElement projectpage = driver.findElement(By.xpath("//span[normalize-space()='Projects Summary']"));
        if (projectpage.isDisplayed()) {
            System.out.println("Case 5: Passed");
        } else {
            System.out.println("Case 5: Failed");
        }

        //Open New Project
        driver.findElement(By.xpath("//a[normalize-space()='New Project']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        //Case 6: Click Save khi để trống các trường
        WebElement nameerror = driver.findElement(By.xpath("//input[@aria-describedby=\"name-error\"]"));
        if (nameerror.isDisplayed()) {
            System.out.println("Case 6: Passed");
        } else {
            System.out.println("Case 6: Failed");
        }

        //Thoát chương trình
        Thread.sleep(5000);
        driver.quit();
    }
}

package runner;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pageclasses.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public LoginPage loginPage;
	@BeforeSuite
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
	}
	@BeforeClass
	public void pageObjects() {
		loginPage=new LoginPage(driver);
	}

}

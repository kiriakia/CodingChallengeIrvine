package pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest {

	public static WebDriver driver;
	public static WebDriverWait wait=null;
	
	public static String URL1="http://35.227.188.130/";
	public static String EnterAddress1= "Irvine, CA";
	public static String EnterAddress2= "92604";
	public static String EnterAddress3= "London";
	public static String EnterAddress4= "United Kingdom";
//	public static String EnterAddress5= "http://35.203.167.23/";
//	public static String EnterAddress6= "Ir vine";


	public void url1_positive(String address) throws Exception  {
		driver.findElement(By.id("address")).sendKeys(address); 
		//Submit
		driver.findElement(By.className("btn-primary")).click();

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("renderedAddress"), address));

		String ammount1=driver.findElement(By.id("renderedAddress")).getText();
		System.out.println("Outputs are available for "+ammount1 + " location");
		Thread.sleep(2000);		
		driver.findElement(By.id("address")).clear();

	}

	
	
	@Test(priority = 1, enabled = true)
	public void tc1_URL1_positive() throws Exception  {
		url1_positive(EnterAddress1);
	}
	
	@Test(priority = 2, enabled = true)
	public void tc2_URL1_positive() throws Exception  {
		url1_positive(EnterAddress2);
	}
	
	@Test(priority = 3, enabled = true)
	public void tc3_URL1_positive() throws Exception  {
		url1_positive(EnterAddress3);
	}
	
	@Test(priority = 4, enabled = true)
	public void tc4_URL1_positive() throws Exception  {
		url1_positive(EnterAddress4);
	}
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
    System.setProperty("webdriver.gecko.driver","C:\\workspaces\\Example\\api\\geckodriver.exe");		
  	driver = new FirefoxDriver();
  	driver.manage().window().maximize();
  	driver.get(URL1);
  	wait = new WebDriverWait(driver, 15);
	  
  }

  @AfterClass
  public void afterClass() throws Exception {
	  
	  Thread.sleep(3000);
	  driver.close();

  }

}

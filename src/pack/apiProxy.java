package pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class apiProxy {
	
	public static WebDriver driver;

	public static String url2="http://35.203.167.23/latlong/Irvine,%20CA";
			
  @Test
  public void f() throws InterruptedException {
	  String Lat=driver.findElement(By.className("objectBox-number")).getText();
	  System.out.println("Lat =  "+Lat);	
	  String Lon=driver.findElement(By.xpath(".//*[@id='/Long']/td[2]/span/span")).getText();	
	  System.out.println("Lon =  "+Lon);
	  String url3="http://35.203.167.23/weather/"+Lat+"/"+Lon+"/1522263575";
	  System.out.println("url3 =  "+url3);
	  Thread.sleep(2000);
	  driver.get(url3);
	  Thread.sleep(3000);
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
    System.setProperty("webdriver.gecko.driver","C:\\workspaces\\Example\\api\\geckodriver.exe");		
  	driver = new FirefoxDriver();
  	driver.manage().window().maximize();
  	driver.get(url2);
  
  }

  @AfterClass
  public void afterClass() throws Exception {	  
	  Thread.sleep(3000);
	  driver.close();

  }

}



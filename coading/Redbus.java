package firstmarathon.coading;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Redbus {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver d=new ChromeDriver(options);
		
		d.get("https://www.redbus.in/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		d.findElement(By.id("src")).sendKeys("Chennai");
		d.findElement(By.className("selected")).click();
		d.findElement(By.id("dest")).click();
		d.findElement(By.id("dest")).sendKeys("Bangalore");
		d.findElement(By.className("selected")).click();
		d.findElement(By.id("onward_cal")).click();
		d.findElement(By.xpath("//td[@class='wd day']")).click();
		d.findElement(By.id("search_btn")).click();
		String noOfBuses = d.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();	
		System.out.println(noOfBuses);
		Thread.sleep(3000);
		d.findElement(By.xpath("//div[@class='close-primo']")).click();
		WebElement clickSleeper = d.findElement(By.xpath("//label[text()='SLEEPER']"));
		d.executeScript("arguments[0].click();", clickSleeper);
		String secondBus = d.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();	
		System.out.println(secondBus);
		System.out.println(d.getTitle());
		
		d.close();
	
	}

}
 

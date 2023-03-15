package firstmarathon.coading;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver d=new ChromeDriver(options);
		
		d.get("https://www.amazon.in/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).click();
		d.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).sendKeys("Bags");
		d.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		String noOfResults = d.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(noOfResults);
        d.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']//i)[1]")).click();
        Thread.sleep(2000);
        d.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']//i)[2]")).click();
        d.findElement(By.xpath("//span[@class='a-button-inner']")).click();
        d.findElement(By.xpath("(//a[@class='a-dropdown-link'])[4]")).click();
        String bagInfo = d.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
        System.out.println(bagInfo);
        Thread.sleep(2000);
        String title = d.getTitle();
        System.out.println(title);
        //d.close();
        
        
        
	}

}
 

package firstmarathon.coading;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver d=new ChromeDriver(options);
		
		d.get("https://in.bookmyshow.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
        d.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Hyderabad");
        d.findElement(By.xpath("//strong[text()='Hyderabad']")).click();
        String City = d.getCurrentUrl();
        if (City.contains("Hyderabad")) {
			System.out.println("The city is verified");
		}
        d.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
        d.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).click();
        d.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Sir");
        d.findElement(By.xpath("//div[@class='sc-fFTYTi kXEckc']")).click();
        d.findElement(By.xpath("//div[@class='styles__CtaText-sc-1vmod7e-2 bBLrVT']")).click();
        String theaterName = d.findElement(By.xpath("//a[@class='__venue-name']")).getText();
        System.out.println(theaterName);
        d.findElement(By.xpath("//div[@class='info-section']")).click();
        String Parking = d.findElement(By.xpath("(//div[@class='facility-text'])[2]")).getText();
        System.out.println(Parking);
        d.findElement(By.xpath("//div[@class='cross-container']")).click();
        d.findElement(By.xpath("//div[@class='showtime-pill-container _available']")).click();
        //WebElement clk = d.findElement(By.id("//li[@id='pop_1']"));
        //d.executeScript("arguments[0].click();", clk);
        d.findElement(By.xpath("//ul[@id='popQty']/li[1]")).click();
        d.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
        WebElement click = d.findElement(By.xpath("//a[@class='_available']"));
        d.executeScript("arguments[0].click();", click);
        d.findElement(By.xpath("//a[@id='btmcntbook']")).click();
        Thread.sleep(2000);
        String Total = d.findElement(By.xpath("//span[@class='__sub-total']")).getText();
        System.out.println("Sub Total: " + Total);
        d.close();
        
	}

}
 

package DDTPractice;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prokabbadi {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.prokabaddi.com/standings");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the team name");
		String teamName = s.next();
		
		List<WebElement> team = driver.findElements(By.xpath("//p[@class='name']"));
		
		for(int i=0; i<team.size();i++) {
			if(team.get(i).getText().contains(teamName)) {
				String Name = team.get(i).getText();
				System.out.println(Name);
				////p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']
				String won = driver.findElement(By.xpath("//p[text()='"+Name+"']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']")).getText();
				System.out.println("Won: "+won);
				String lost = driver.findElement(By.xpath("//p[text()='"+Name+"']/ancestor::div[@class='row-head']//div[@class='table-data matches-lost']")).getText();
				System.out.println("Lost: "+lost);
				String tie = driver.findElement(By.xpath("//p[text()='"+Name+"']/ancestor::div[@class='row-head']//div[@class='table-data matches-draw']")).getText();
				System.out.println("Draw: "+tie);
				String pts = driver.findElement(By.xpath("//p[text()='"+Name+"']/ancestor::div[@class='row-head']//div[@class='table-data points']")).getText();
				System.out.println("Lost: "+pts);
				break;
				
			}
		}
		
		driver.quit();
		s.close();
		
	}

}

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadiusBankDemo {

	public static <WebElements> void main(String[] args) throws InterruptedException {

		String url = "https://radiusbank.com/";
		String rateAmount = "800";
		String firstName = "sam";
		String lastName = "Curran";
		String dob = "3/8/1966";
		String address = "21323 Fox Street, Lebanon, OK 73440, USA";
		String ssn = "6786784789";

		String monthlyPayment = "6876";
		String phNo = "3764836674";
		String email = "gggg@gmail.com";
		String password = "Abcd1234";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rober\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		// Navigating to personal loans link
		driver.findElement(By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.xpath("//div/div[1]/nav[1]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]"))
				.click();
		Thread.sleep(1000);
		String pageTitle = driver.getTitle();
		// verifying the page title to check whether navigated to the expected page
		Assert.assertTrue(pageTitle.equalsIgnoreCase("Personal Loans Credible | Radius Bank"));

		// clicking find my rates button
		driver.findElement(By.xpath("//main/section[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
		driver.findElement(By.linkText("Continue")).click();

		// Navigating to the child window by window id
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> idSets = windowIds.iterator();
		String parentWindow = idSets.next();
		String childWindow = idSets.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name='top-amount']")).sendKeys(rateAmount);
		driver.findElement(By.xpath("//button[contains(@class,'styles_primary__UJd1C')]")).click();

		// System.out.println(driver.getTitle());
		//
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/div[3]/div[1]/label/span")).click();
		// explicit wait
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[1]/div/label/span")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/div[1]/div/label/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("90000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='First name']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input[placeholder='Last name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Entering DOB in the given field
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input.inspectletIgnore")).sendKeys(dob);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Entering Address in the given field
		Thread.sleep(1000);
		driver.findElement(By.id("geosuggest__input")).sendKeys(address);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/ul/li/span")).click();
		driver.findElement(By.xpath("//div/p/a")).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// selecting home details by radio button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[3]/div/label/span")).click();
		// Entering monthly home payment
		Thread.sleep(1000);
		driver.findElement(By.id("expenses.housingPayment")).sendKeys(monthlyPayment);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(1000);
		driver.findElement(By.className("INZxdXwh")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Social security number']")).sendKeys(ssn);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Phone number']")).sendKeys(phNo);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.close();
	}
}
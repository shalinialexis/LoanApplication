import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RadiusBankOptimized {

	static String url = "https://radiusbank.com/";

	public void getPersonalLoan(WebDriver driver) throws InterruptedException {

		String rateAmount = "800";

		// Navigating to personal loans link
		WebElement personalLink = driver.findElement(By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[1]/a[1]"));
		WebElement personalLoan = driver.findElement(By.xpath("//a[contains(text(),'Personal Loans')]"));
		personalLink.click();
		personalLoan.click();

		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.titleContains("Personal Loans Credible | Radius Bank"));

		// verifying the page title to check whether navigated to the expected page
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.equalsIgnoreCase("Personal Loans Credible | Radius Bank"));

		// clicking find my rates button
		WebElement ratesButton = driver
				.findElement(By.xpath("//main/section[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]"));
		ratesButton.click();
		WebElement continueButton = driver.findElement(By.linkText("Continue"));
		continueButton.click();

		// Navigating to the child window by window id
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> idSets = windowIds.iterator();
		String parentWindow = idSets.next();
		String childWindow = idSets.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		WebElement findMyRate = driver.findElement(By.xpath("//input[@name='top-amount']"));
		WebElement findMyRateButton = driver
				.findElement(By.xpath("//button[contains(@class,'styles_primary__UJd1C')]"));
		findMyRate.sendKeys(rateAmount);
		findMyRateButton.click();
	}

	public void enterLoanInfo(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		WebElement loanPurpose = driver
				.findElement(By.xpath("//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]"));
		loanPurpose.click();
		Thread.sleep(1000);
		WebElement educationLevel = driver.findElement(By.xpath("//div/div[3]/div[1]/label/span"));
		educationLevel.click();
		Thread.sleep(1000);
		WebElement employment = driver.findElement(By.xpath("//div/div[1]/div/label/span"));
		employment.click();
		Thread.sleep(1000);
		WebElement annualIncome = driver.findElement(By.xpath("//div/div[2]/input"));
		annualIncome.sendKeys("90000");
		System.out.println(driver.getCurrentUrl());
		WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']"));
		continueButton.click();
	}

	public void getPersonalDetails(WebDriver driver) throws InterruptedException, IOException {
		ExcelData ed = new ExcelData();
		ArrayList<String> data = ed.getData("Users");

		Thread.sleep(1000);
		WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First name']"));
		firstName.sendKeys(data.get(1));
		WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last name']"));
		lastName.sendKeys(data.get(2));
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();
		// Entering DOB in the given field
		Thread.sleep(1000);
		WebElement dob = driver.findElement(By.cssSelector("input.inspectletIgnore"));
		dob.sendKeys(data.get(3));
		WebElement clickContinue = driver.findElement(By.xpath("//button[@type='submit']"));
		clickContinue.click();
		// Entering Address in the given field
		Thread.sleep(1000);
		WebElement addressBar = driver.findElement(By.id("geosuggest__input"));
		addressBar.sendKeys(data.get(4));
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.xpath("//div/ul/li/span"));
		button.click();
		WebElement enterManually = driver.findElement(By.xpath("//div/p/a"));
		enterManually.click();
		WebElement submitButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton2.click();
		// selecting home details by radio button
		Thread.sleep(1000);
		WebElement homeOwnership = driver.findElement(By.xpath("//div/div[2]/div/label/span"));
		homeOwnership.click();

		// Entering monthly home payment
		Thread.sleep(1000);
		WebElement housingPayment = driver.findElement(By.id("expenses.housingPayment"));
		housingPayment.sendKeys(data.get(6));
		WebElement submitButton3 = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton3.click();

		Thread.sleep(1000);
		WebElement citizenship = driver.findElement(By.className("INZxdXwh"));
		citizenship.click();
		Thread.sleep(1000);
		WebElement ssn = driver.findElement(By.cssSelector("input[placeholder='Social security number']"));
		ssn.sendKeys(data.get(7));
		WebElement submitButton4 = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton4.click();

		Thread.sleep(1000);
		WebElement phoneNumber = driver.findElement(By.cssSelector("input[placeholder='Phone number']"));
		phoneNumber.sendKeys(data.get(5));
		WebElement submitButton5 = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton5.click();

		Thread.sleep(1000);
		WebElement email = driver.findElement(By.cssSelector("input[placeholder='Email']"));
		email.sendKeys(data.get(8));
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(data.get(9));
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rober\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.get(url);
		driver.manage().window().maximize();

		RadiusBankOptimized rbt = new RadiusBankOptimized();
		rbt.getPersonalLoan(driver);
		rbt.enterLoanInfo(driver);
		rbt.getPersonalDetails(driver);

		driver.quit();

	}

}

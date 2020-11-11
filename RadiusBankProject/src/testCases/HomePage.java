package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository.LoanInfoPage;
import objectRepository.LoanQualificationPage;
import objectRepository.PersonalLoanPage;
import objectRepository.RbHomePage;

public class HomePage {
	@Test
	public void personalLoan() throws InterruptedException, IOException {
		String rateAmount = "800";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rober\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://radiusbank.com/");
		driver.manage().window().maximize();

		// creating object for RbHomepage
		RbHomePage rb = new RbHomePage(driver);
		rb.clickPersonal().click();

		// Navigating to the personal loans link
		rb.clickPersonalLoan().click();

		// creating object for PersonalLoanPage
		PersonalLoanPage lp = new PersonalLoanPage(driver);

		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.titleContains("Personal Loans Credible | Radius Bank"));

		// verifying the page title to check whether navigated to the expected page
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.equalsIgnoreCase("Personal Loans Credible | Radius Bank"));

		lp.clickRates().click();
		lp.clickContinue().click();

		// Navigating to the child window by window id
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> idSets = windowIds.iterator();
		String parentWindow = idSets.next();
		String childWindow = idSets.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());

		// creating object for LoanQualificationPage
		LoanQualificationPage qp = new LoanQualificationPage(driver);
		qp.rateFinder().sendKeys(rateAmount);
		qp.findRate().click();

		// creating object for LoanInfoPage
		LoanInfoPage ip = new LoanInfoPage(driver);
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		Thread.sleep(1000);
		ip.loanPurpose().click();
		Thread.sleep(1000);
		ip.getEducation().click();
		Thread.sleep(1000);

		ip.getEmployment().click();
		Thread.sleep(1000);

		ip.getIncome().sendKeys("90000");
		// System.out.println(driver.getCurrentUrl());
		ip.clickContinue().click();

		// Integrating data from Excel file
		ExcelData ed = new ExcelData();
		ArrayList<String> data = ed.getData("Users");
		ip.getFirstName().sendKeys(data.get(1));
		ip.getLastName().sendKeys(data.get(2));
		ip.submit().click();
		ip.getDob().sendKeys(data.get(3));
		ip.pressContinue().click();
		ip.getAddress().sendKeys(data.get(4));
		ip.pressButton().click();
		ip.enterManually().click();
		ip.submitButton2().click();
		ip.enterOwnership().click();
		ip.getPayment().sendKeys(data.get(6));
		ip.submitButton3().click();
		ip.getCitizenship().click();
		ip.getSsn().sendKeys(data.get(7));
		ip.submitButton4().click();
		ip.getPhoneNumber().sendKeys(data.get(5));
		ip.submitButton5().click();
		ip.getEmail().sendKeys(data.get(8));
		ip.getPassword().sendKeys(data.get(9));
		driver.quit();

	}
}

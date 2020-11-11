package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoanInfoPage {
	public WebDriver driver;

	public LoanInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	By loanPurpose = By.xpath("//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]");
	By educationLevel = By.xpath("//div/div[3]/div[1]/label/span");
	By employment = By.xpath("//div/div[3]/div/label/span");
	By annualIncome = By.xpath("//input[@name='employment.incomeYearly']");
	// By annualIncome = By.id("employment.incomeYearly");
	By continueButton = By.xpath("//button[@type='submit']");

	By firstName = By.cssSelector("input[placeholder='First name']");
	By lastName = By.cssSelector("input[placeholder='Last name']");
	By submitButton = By.xpath("//button[@type='submit']");

	By dob = By.cssSelector("input.inspectletIgnore");
	By clickContinue = By.xpath("//button[@type='submit']");
	By addressBar = By.id("geosuggest__input");
	By button = By.xpath("//div/ul/li/span");
	By enterManually = By.xpath("//div/p/a");
	By submitButton2 = By.xpath("//button[@type='submit']");
	By homeOwnership = By.xpath("//div/div[2]/div/label/span");
	By housingPayment = By.id("expenses.housingPayment");
	By submitButton3 = By.xpath("//button[@type='submit']");
	By citizenship = By.className("INZxdXwh");
	By ssn = By.cssSelector("input[placeholder='Social security number']");;
	By submitButton4 = By.xpath("//button[@type='submit']");
	By phoneNumber = By.cssSelector("input[placeholder='Phone number']");
	By submitButton5 = By.xpath("//button[@type='submit']");
	By email = By.cssSelector("input[placeholder='Email']");
	By password = By.name("password");

	public WebElement loanPurpose() {
		return driver.findElement(loanPurpose);
	}

	public WebElement getEducation() {
		return driver.findElement(educationLevel);
	}

	public WebElement getEmployment() {

		return driver.findElement(employment);
	}

	public WebElement getIncome() {

		return driver.findElement(annualIncome);
	}

	public WebElement clickContinue() {
		return driver.findElement(continueButton);
	}

	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}

	public WebElement getLastName() {
		return driver.findElement(lastName);
	}

	public WebElement submit() {
		return driver.findElement(submitButton);
	}

	public WebElement getDob() {
		return driver.findElement(dob);
	}

	public WebElement pressContinue() {
		return driver.findElement(clickContinue);
	}

	public WebElement getAddress() {
		return driver.findElement(addressBar);
	}

	public WebElement pressButton() {
		return driver.findElement(button);
	}

	public WebElement enterManually() {
		return driver.findElement(enterManually);
	}

	public WebElement submitButton2() {
		return driver.findElement(submitButton2);
	}

	public WebElement enterOwnership() {
		return driver.findElement(homeOwnership);
	}

	public WebElement getPayment() {
		return driver.findElement(housingPayment);
	}

	public WebElement submitButton3() {
		return driver.findElement(submitButton3);
	}

	public WebElement getCitizenship() {
		return driver.findElement(citizenship);
	}

	public WebElement getSsn() {
		return driver.findElement(ssn);
	}

	public WebElement submitButton4() {
		return driver.findElement(submitButton4);
	}

	public WebElement getPhoneNumber() {
		return driver.findElement(phoneNumber);
	}

	public WebElement submitButton5() {
		return driver.findElement(submitButton5);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}
}

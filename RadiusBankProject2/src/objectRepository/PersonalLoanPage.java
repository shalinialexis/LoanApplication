package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalLoanPage {
	public WebDriver driver;

	public PersonalLoanPage(WebDriver driver) {
		this.driver = driver;
	}

	By ratesButton = By.xpath("//main/section[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
	By continueButton = By.linkText("Continue");

	public WebElement clickRates() {
		return driver.findElement(ratesButton);
	}

	public WebElement clickContinue() {
		return driver.findElement(continueButton);
	}
}

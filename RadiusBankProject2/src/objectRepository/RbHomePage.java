package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RbHomePage {
	public WebDriver driver;

	public RbHomePage(WebDriver driver) {
		this.driver = driver;
	}

	By personalLink = By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[1]/a[1]");
	By personalLoan = By.xpath("//a[contains(text(),'Personal Loans')]");

	public WebElement clickPersonal() {
		return driver.findElement(personalLink);
	}

	public WebElement clickPersonalLoan() {
		return driver.findElement(personalLoan);
	}
}

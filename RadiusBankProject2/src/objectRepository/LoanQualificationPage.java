package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoanQualificationPage {
	public WebDriver driver;

	public LoanQualificationPage(WebDriver driver) {
		this.driver = driver;
	}

	By findMyRate = By.xpath("//input[@name='top-amount']");
	By findMyRateButton = By.xpath("//button[contains(@class,'styles_primary__UJd1C')]");

	public WebElement rateFinder() {
		return driver.findElement(findMyRate);
	}

	public WebElement findRate() {
		return driver.findElement(findMyRateButton);
	}
}

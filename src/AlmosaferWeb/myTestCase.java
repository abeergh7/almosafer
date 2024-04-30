package AlmosaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class myTestCase extends parameter {

	@BeforeTest()
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		driver.get(url);
		WebElement popUpScreen = driver.findElement(By.className("sc-iBmynh"));

		if (popUpScreen.isDisplayed()) {

			WebElement SArButton = driver.findElement(By.className("cta__saudi"));
			SArButton.click();

		}

	}

	@Test(priority = 1)
	public void checkTheLanguageIsEnglish() {
		String Expectedlanguage = "EN";
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		assertEquals(ActualLanguage, Expectedlanguage);

	}

	@Test(priority = 2)
	public void checkTheCurrensyIsSar() {

		String ActualCurrency = driver.findElement(By.className("sc-dRFtgE")).getText();
		assertEquals(ActualCurrency, "SAR");

	}

	@Test(priority = 3)
	public void checkNumber() {

		String ActualNumber = driver.findElement(By.tagName("strong")).getText();
		String ExpectedNumber = "+966554400000";

		assertEquals(ActualNumber, ExpectedNumber);
	}

	@Test(priority = 4)
	public void logo() {

		WebElement footer = driver.findElement(By.tagName("footer"));
		WebElement logoDisplayed = footer.findElement(By.className("eYboXF"));
		assertEquals(logoDisplayed.isDisplayed(), true);
	}

	@Test(priority = 5)
	public void checkHotelNotSelected() {

		assertEquals(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"),
				"false");

	}

	@Test(priority = 6)
	public void checkDepartureAndReturnDate() {

		LocalDate today = LocalDate.now();

		int ExpectedDepartureDate = today.plusDays(1).getDayOfMonth();
		int ExpectedReturnDate = today.plusDays(2).getDayOfMonth();

//		System.out.println(ExpectedDepartureDate);
//		System.out.println(ExpectedReturnDate);
		int ActualDepartureDate = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"))
				.getText());

		int ActualReturnDate = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"))
				.getText());

		assertEquals(ActualDepartureDate, ExpectedDepartureDate);
		assertEquals(ActualReturnDate, ExpectedReturnDate);

	}

	@Test(priority = 7)
	public void RandomMethodToChangeLanguage() {

		Random rand = new Random();
		int randomIndex = rand.nextInt(website.length);
		driver.get(website[randomIndex]);

		if (driver.getCurrentUrl().contains("ar")) {

			String expectedLang = "ar";
			String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(actualLang, expectedLang);

		} else {

			String expectedLang = "en";
			String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(actualLang, expectedLang);

		}

	}

	@Test(priority = 8)
	public void swichTab() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		if (driver.getCurrentUrl().contains("ar")) {
			WebElement searchCityInputA = driver.findElement(By.className("sc-phbroq-2"));

			searchCityInputA.sendKeys(citiesInArabic[randomArabic]);

		} else {
		WebElement searchCityInput = driver.findElement(By.className("sc-phbroq-2"));

			searchCityInput.sendKeys(citiesInEnglish[randomEnglish]);

		}

	}

	@AfterTest()
	public void myPostTest() {
	}

}

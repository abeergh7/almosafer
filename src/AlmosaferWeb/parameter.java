package AlmosaferWeb;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameter {

	
	WebDriver driver=new ChromeDriver();
	String url ="https://global.almosafer.com/en";
	Random randomCities=new Random();
	String [] website= {"https://global.almosafer.com/en","https://global.almosafer.com/ar"};
	String []citiesInEnglish= {"dubai","jaddah","reyadh"};
	int randomEnglish=randomCities.nextInt(citiesInEnglish.length);
	String []citiesInArabic= {"دبي","جدة"};
	int randomArabic=randomCities.nextInt(citiesInArabic.length);

	
	
	
}

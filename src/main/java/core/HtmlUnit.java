package core;
//BEGIN
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HtmlUnit {
	
		public static void main(String[] args) throws FileNotFoundException, IOException {

			String csvFile = "./src/main/resources/Test.csv";

			BufferedReader br = null;
			String line = null;
			String cvsSplitBy = ",";
			String text_case_id = null;
			String url = null;
			String title_expected = null;

			br = new BufferedReader(new FileReader(csvFile));
		

		//String text_case_id = "TC-002.01";
		//String url = "http://www.learn2test.net";
		//String title_expected = "learn2test.net";
		
			while ((line = br.readLine()) != null) {
			WebDriver driver = new FirefoxDriver();   // Version 1.2 :: HtmlUnit

			String[] csv = line.split(cvsSplitBy);

			text_case_id = csv[0];
			url = csv[1];
			title_expected = csv[2];
			/*	System.out.println("text_case_id="+text_case_id);
				System.out.println("url="+url);
				System.out.println("title_expected="+title_expected);
			 */
			driver.get(url);
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			
			System.out.println("");	
			

		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
		}
		driver.quit();
		
		//System.out.println("=================================================================== quit ================================================");

}
br.close();}
		
}
//END


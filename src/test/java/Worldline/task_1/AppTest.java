package Worldline.task_1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest 
{
	WebDriver driver;
	@Test
	public void openBrowser() 
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\web_driver_2\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://cosmocode.io/automation-practice-webtable/");
	    driver.manage().window().maximize();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 500)"); // Scroll down by 500 pixels
	    
	    //Find the table element
	    WebElement table = driver.findElement(By.id("countries"));

	    // Find all rows in the table
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    
	    System.out.println("The list of countries are:");
	    
	    for (WebElement row : rows) 
	    {
	        // Find cells in each row
	        List<WebElement> cells = row.findElements(By.tagName("td"));
	        // Iterate through each cell and print the text
	        for (WebElement cell : cells) {
	            System.out.print(cell.getText() + "\t");
	        }
	        System.out.println(); // Move to the next line after printing all cells of the row
	    }
	    
	    Boolean countryFound = false;
	    
	    String expectedCountry = "Afghanistan";
	    
	    for (WebElement row : rows) {
	        // Find cells in each row
	        List<WebElement> cells = row.findElements(By.tagName("td"));
	        // Iterate through each cell and find the country
	        for (WebElement cell : cells) {
	            if (cell.getText().equals(expectedCountry)) {
	            	System.out.println("The details you are searching for is ");
	                countryFound = true;
	                // Print the text of all cells in the row
	                for (WebElement rowCell : cells) {
	                    System.out.print(rowCell.getText() + "\t");
	                }
	                System.out.println(); // Move to the next line after printing all cells of the row
	                break; // Exit the loop once the country is found
	            }
	        }
	        if (countryFound) {
	            break; // Exit the loop if the country is found
	        }
	    }
	    
	    // Close the WebDriver
	    driver.quit();
	}

   
    
}


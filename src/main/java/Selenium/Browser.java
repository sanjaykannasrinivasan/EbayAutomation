package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser
{
public static WebDriver driver;
public static WebDriver setDriver()

{

try{
	Scanner scan = new Scanner(System.in);
    System.out.println("Ebay Search Automation\n");
    System.out.println("=======================\n");
    System.out.println("Which browser would you like to execute the script on? \n"
                        +"1.Google Chrome \n"
    		            +"2.Microsoft Edge");
    int browserChoice = scan.nextInt();
    scan.close();

    if (browserChoice == 1)
    {
	   driver = setChromeDriver();
    }else if(browserChoice==2)
    {
       driver=setEdgeDriver();
    }
    else
    {
       System.out.println("Invalid data...");
    }
}
catch(Exception e)
{
   e.printStackTrace();
}
  return driver;
}

// Setting up ChromeDriver

public static WebDriver setChromeDriver()
{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
}

// Setting up Microsoft Edge Driver
public static WebDriver setEdgeDriver()
{
	
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	}

//Get the URL
public static void getUrl() throws Exception
{
	try
	{
		String filelocation = System.getProperty("user.dir") + "\\Properties\\Configure.properties";
		File file = new File(filelocation);
		FileInputStream fileinput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileinput);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	catch(Exception e)
	{
		e.printStackTrace();
		}
	}

/*
 *  Close the Browser
 */
public static void closeBrowser()
{
	driver.quit();
	}
}

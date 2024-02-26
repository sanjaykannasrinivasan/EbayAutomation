package Selenium;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ToysSearch extends Browser {
	
//Advanced search button is selected
public void advanced() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.id("gh-as-a")).click();      
}
//Text box element is located
public void keyword_textbox() throws Exception {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.findElement( By.id("_nkw")).sendKeys(ReadExcel.readExcel(0,0));      
}

//drop down element is located
public void keyword_options(){
	Select Keyword=new Select(driver.findElement(By.name("_in_kw")));
	Keyword.selectByVisibleText("Any words, any order");           
}
//Wait until the check box element is located
public void searchInc()  { 
         List<WebElement> checkboxes = driver.findElements(By.xpath("//fieldset[@class='adv-fieldset__searchIncluding']/div/span[@class='checkbox']"));
        for(int i=0;i<checkboxes.size();i++) {
        checkboxes.get(i).click();
        }      
}
//Wait until the check box condition element is located
public void condition_new() {
        driver.findElement(By.xpath("//*[@id=\"s0-1-17-6[4]-[0]-LH_ItemCondition\"]")).click();          
}
//Wait until the check box results element is located
public void Results(){	
	List<WebElement> checkboxes1 =driver.findElements(By.xpath("//fieldset[@class=\"adv-fieldset__showResults\"]/div/span[@class=\"checkbox\"]"));
	for(int i=0;i<3;i++) {
		checkboxes1.get(i).click();
        }   
}
//Wait until the check box shipping element is located
public void Shipping() {
	driver.findElement(By.cssSelector("label[for='s0-1-17-5[6]-[0]-LH_FS']")).click();           
}
//Wait until the list box element for preferred location is located
public void location_select()  {
	driver.findElement(By.id("s0-1-17-6[7]-[3]-LH_PrefLoc")).click();         
}
//Wait until the search button element is located
public void click_search() {
   driver.findElement(By.xpath("/html/body/div[2]/div/main/form/div[2]/button")).click();            
}
//Wait until the search button element is located
public void category_verify() throws Exception {
    Select sel = new Select(driver.findElement(By.id("gh-cat")));
    List<WebElement> opts = sel.getOptions();
    for(WebElement ele:opts)
    {
    	String name=ele.getText();
    	if (name.equals(ReadExcel.readExcel(1, 0))) {
    		System.out.println("Outdoors Toys & Structures category  matches!");
    		break;
          } else {
             System.out.println("Outdoors Toys & Structures category does not match!");
             break;
                         }              
                 }            
}
 
/*
 Collecting all the href_values that are present in the web 
 and clicking on the first link that consists of Portable word
 */


/*
public void href_values() throws IOException  {
	List<WebElement> allLinks = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]//a[@class=\"s-item__title\"]"));
	for(WebElement ele : allLinks) {
		String url=ele.getText();
// checks the link that consists of "Portable"
		if (url.contains(ReadExcel.readExcel(2, 0)))
		{
			ele.click();
			System.out.println("Verified the link contains \"Portable\" text");
            System.out.println("Clicked on the link contains \"Portable\" text");
            System.out.println(url);
            break;
            }else{
            	System.out.println("Portable text does not match with any Product");
                break;
 
               }
           }
           
          }
          */


//check the product present in result page
public void Fin() {

String product = driver.findElement(By.xpath("//*[@id='srp-river-results']/ul/li[2]/div/div/h3")).getText();
       if(product.contains("No exact matches found")) {
            System.out.println("No items Found");
         }
}
// Invoking all the methods
public static void main(String[] args)  {
try {
     ToysSearch obj = new ToysSearch();
     setDriver();
     getUrl();
     obj.advanced();
     obj.keyword_textbox();
     obj.keyword_options();
     obj.searchInc();
     obj.condition_new();
     obj.Results();
     obj.Shipping();
     obj.location_select();
     obj.click_search();
     obj.category_verify();
     //obj.href_values();
     obj.Fin();
     closeBrowser();
     System.out.println("Script completed successfully");
    } catch (Exception e) {
          e.printStackTrace();
    }
 }
 
}

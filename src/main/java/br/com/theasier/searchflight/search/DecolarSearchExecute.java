package br.com.theasier.searchflight.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.theasier.searchflight.domain.Scan;
import br.com.theasier.searchflight.infra.AbstractSearchExecutor;

public class DecolarSearchExecute extends AbstractSearchExecutor<Scan> {

	@Override
	public void execute() {
		
		WebDriver driver = new FirefoxDriver();
		
		
		try {
			String baseUrl = "https://www.decolar.com/";
			
			driver.get(baseUrl);
			
			WebElement origin = driver.findElement(By.xpath("//input[@class='input-tag' and @placeholder='Insira sua cidade de origem']"));
			origin.sendKeys("São Paulo, São Paulo, Brasil");
			
			List<WebElement> optionsToSelectOrigin = driver.findElements(By.className("item-text"));
			for(WebElement option : optionsToSelectOrigin){
			    System.out.println(option);
			    if(option.getText().equals("São Paulo, São Paulo, Brasil")) {
			        option.click();
			        break;
			    }
			}
		
			
			WebElement destination = driver.findElement(By.xpath("//input[@class='input-tag' and @placeholder='Insira sua cidade de destino']"));
			destination.sendKeys("Natal");
			
			WebElement buttonSearch = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr--3LK5x sbox5-3-btn -secondary -icon -lg']"));
			buttonSearch.click();
			
		}  finally {
			driver.quit();
		}
	}

}

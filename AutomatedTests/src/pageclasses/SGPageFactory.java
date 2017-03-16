package pageclasses;

import java.util.List;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitTypes;

public class SGPageFactory {
	WebDriver driver;

	@FindBy (css="button[data-qa-id='sgList.addSG']")
	WebElement CreateSG;
	
	@FindBy (css="button[data-qa-id='sgList.table.addSG']")
	WebElement noSGcreateButton;
	
	@FindBy (id="CHIP_ACCOUNT_REP_HYBRID")
	WebElement AcctRepToggle;
	
	@FindBy (xpath="//*[@data-qa-id='sgBuilder.segment.ACCOUNT_REP_HYBRID.rep.0.repName']/descendant-or-self::button[contains(@ng-click, 'toggle')]")
	WebElement Selection;
	
	@FindBy (xpath="//*[@id='account_rep_0']/span/div/div[2]/div[1]")
	WebElement AcctRep;
	
	public SGPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCreateSG() {
		CreateSG.click();
	}
	
	public void clickAcctRepToggle() {
		AcctRepToggle.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.className("panel-loader")));
	}
	
	public void clickSelection() {
		Selection.click();
	}

	public void displayCount() {
		WebElement text = driver.findElement(By.xpath("//*[@id='ars_col_1_0']/div/p"));
		System.out.println("Acct Reps: " + text.getAttribute("innerText"));
	}
	
}

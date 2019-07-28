package cursoselenium;

import org.openqa.selenium.WebDriver;

public class AlertPage {

	private DSL dsl;
	
	public AlertPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void clicar(String id) {
		dsl.clicar(id);
	}
}

package cursoselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrimeFaces {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
//		WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
//		driver.quit();
	}
	
	@Test
	public void deveInteragirComCombobox() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt701:console_input","j_idt701:console_1", "Xbox One");
		assertEquals("Xbox One", dsl.obterTexto("j_idt701:console_label"));
		
	}
}

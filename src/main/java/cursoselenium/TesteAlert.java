package cursoselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
//		WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void deveInteragirComAlertSimples() {

		dsl.clicar("alert");
		String texto = dsl.alertaObterTextoEAceita();
		assertEquals("Alert Simples", texto);
		
		dsl.escreve("elementosForm:nome", texto);
	}
	
	@Test
	public void deveInteragirComAlertConfima() {

		dsl.clicar("confirm");
		assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveInteragirComAlertNaoConfima() {

		dsl.clicar("confirm");
		assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		assertEquals("Negado", dsl.alertaObterTextoENega());
	}
	
	@Test
	public void deveInteragirComPrompt() {

		dsl.clicar("prompt");
		assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		assertEquals(":D", dsl.alertaObterTextoEAceita());
	}
}

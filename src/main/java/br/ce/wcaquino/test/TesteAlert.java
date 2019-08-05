package br.ce.wcaquino.test;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.page.AlertPage;

public class TesteAlert extends BaseTest {

	private DSL dsl;
	private AlertPage page;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new AlertPage();
	}
	
	@Test
	public void deveInteragirComAlertSimples() {

		page.clicar("alert");
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

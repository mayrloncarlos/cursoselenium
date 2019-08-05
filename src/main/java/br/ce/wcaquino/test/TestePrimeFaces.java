package br.ce.wcaquino.test;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DSL;

public class TestePrimeFaces extends BaseTest {

	private DSL dsl;

	@Before
	public void inicializa() {
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@Test
	public void deveInteragirComCombobox() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt701:console_input","j_idt701:console_1", "Xbox One");
		assertEquals("Xbox One", dsl.obterTexto("j_idt701:console_label"));
		
	}
}

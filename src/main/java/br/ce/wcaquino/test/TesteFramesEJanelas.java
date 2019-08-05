package br.ce.wcaquino.test;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DSL;

public class TesteFramesEJanelas extends BaseTest {
	
	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}


	@Test
	public void deveInteragirComFrames() {
		
		dsl.entrarFrame("frame1");
		dsl.clicar("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		assertEquals("Frame OK!", msg);
		
		dsl.sairFrame();
		dsl.escreve("elementosForm:nome", msg);
	}
	
	@Test
	public void deveInteragirComJanelas() {
		
		dsl.clicar("buttonPopupEasy");
		dsl.trocarJanela("Popup");
		dsl.escreve(By.tagName("textarea"), "Deu certo?");
		getDriver().close();
		dsl.trocarJanela("");
		dsl.escreve(By.tagName("textarea"), "E agora?");
		
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicar("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		assertEquals("Frame OK!", msg);
		
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		
		dsl.clicar("buttonPopupHard");
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
		dsl.escreve(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
		dsl.escreve(By.tagName("textarea"), "E agora?");
		
	}
}

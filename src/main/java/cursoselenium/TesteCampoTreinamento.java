package cursoselenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {
	
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
	public void deveInteragirComTextField() {
		dsl.escreve("elementosForm:nome", "Teste de escrita");
		assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
		
	}
	
	@Test
	public void deveInteragirComTextFieldDuplo() {
		dsl.escreve("elementosForm:nome", "Mayrlon");
		assertEquals("Mayrlon", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosForm:nome", "Carlos");
		assertEquals("Carlos", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void deveInteragirComTextArea() {

		dsl.escreve("elementosForm:sugestoes", "Teste\nde\nescrita\nno\ntext\narea");
		assertEquals("Teste\nde\nescrita\nno\ntext\narea", dsl.obterValorCampo("elementosForm:sugestoes"));
		
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		dsl.clicar("elementosForm:sexo:1");
		assertTrue(dsl.isMarcado("elementosForm:sexo:1"));
		
	}
	
	@Test
	public void deveInteragirComCheckbox() {
		dsl.clicar("elementosForm:comidaFavorita:2");
		assertTrue(dsl.isMarcado("elementosForm:comidaFavorita:2"));
		
	}
	
	@Test
	public void deveInteragirComCombo() {

		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));
		
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		assertEquals(8, dsl.ObterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Superior"));
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		assertEquals(3, opcoesMarcadas.size());
		
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		assertEquals(2, opcoesMarcadas.size());
		assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));	
	}
	
	@Test
	public void deveInteragirComBotoes() {
		
		dsl.clicar("buttonSimple");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		
		assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComLinks() {
		
		dsl.clicarLink("Voltar");
		assertEquals("Voltou!", dsl.obterTexto("resultado"));
		
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		
		assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
		assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		
	}
}

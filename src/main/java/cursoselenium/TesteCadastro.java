package cursoselenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
//		WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void deveCadastrarUmUsuario() {
		page.setNome("Mayrlon");
		page.setSobrenome("Carlos");
		page.setSexoMasculino();
		page.setComidaFrango();
		page.setEscolaridade("Superior");
		page.setEsporte("Corrida");
		page.setSugestao("Nenhuma sugestao");
		page.cadastrar();
		
		assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		assertEquals("Nome: Mayrlon", page.obterNomeCadastro());
		assertEquals("Sobrenome: Carlos", page.obterSobrenomeCadastro());
		assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		assertEquals("Comida: Frango", page.obterComidaCadastro());
		assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());
		assertEquals("Esportes: Corrida", page.obterEsporteCadastro());
		assertEquals("Sugestoes: Nenhuma sugestão", page.obterSugestaoCadastro());

	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		
		page.cadastrar();
		assertEquals("Nome eh obrigatorio", dsl.alertaObterTexto());
		
	}
	

	@Test
	public void deveValidarSobrenomeObrigatorio() {
		
		page.setNome("Mayrlon");
		page.cadastrar();
		assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTexto());
		
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		
		page.setNome("Mayrlon");
		page.setSobrenome("Carlos");	
		page.cadastrar();
		assertEquals("Sexo eh obrigatorio", dsl.alertaObterTexto());
		
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		
		page.setNome("Mayrlon");
		page.setSobrenome("Carlos");	
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegetariana();
		page.cadastrar();

		assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTexto());
		
	}
	
	@Test
	public void deveValidarEsporte() {
		
		page.setNome("Mayrlon");
		page.setSobrenome("Carlos");	
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEscolaridade("Superior");
		page.setEsporte("Corrida", "O que eh esporte?");
		page.setSugestao("Nenhuma sugestao");
		page.cadastrar();
		assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTexto());
		
	}
}

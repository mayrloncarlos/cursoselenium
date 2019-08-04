package cursoselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {

	private WebDriver driver;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
//		WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
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
		page.setSugestao("Nenhuma sugestão");
		page.cadastrar();
		
		assertEquals("Cadastrado!", page.obterResultadoCadastro());
		assertEquals("Mayrlon", page.obterNomeCadastro());
		assertEquals("Carlos", page.obterSobrenomeCadastro());
		assertEquals("Masculino", page.obterSexoCadastro());
		assertEquals("Frango", page.obterComidaCadastro());
		assertEquals("superior", page.obterEscolaridadeCadastro());
		assertEquals("Corrida", page.obterEsporteCadastro());
		assertEquals("Nenhuma sugestão", page.obterSugestaoCadastro());

	}
}

package cursoselenium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String escolaridade;
	@Parameter(value=5)
	public String[] esportes;
	@Parameter(value=6)
	public String msg;

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
	
	@Parameters
	public static Collection<Object[]> getCollections(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), "Superior", new String[]{}, "Nome eh obrigatorio"},
			{"Mayrlon", "", "", Arrays.asList(), "Superior", new String[]{}, "Sobrenome eh obrigatorio"},
			{"Mayrlon", "Carlos", "", Arrays.asList(), "Superior", new String[]{}, "Sexo eh obrigatorio"},
			{"Mayrlon", "Carlos", "Masculino", Arrays.asList("Carne", "Vegetariano"), "Superior", new String[]{}, 
				"Tem certeza que voce eh vegetariano?"},
			{"Mayrlon", "Carlos", "Masculino", Arrays.asList("Carne"), "Superior", new String[]{"Corrida", "O que eh esporte?"}, 
				"Voce faz esporte ou nao?"}	
		});
	}

	@Test
	public void deveValidarRegras() {
		
		page.setNome(nome);
		page.setSobrenome(sobrenome);	
		if(sexo.equals("Masculino")) { 
			page.setSexoMasculino();
		}
		if(sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if(comidas.contains("Carne")) page.setComidaCarne();
		if(comidas.contains("Frango")) page.setComidaFrango();
		if(comidas.contains("Vegetariano")) page.setComidaVegetariana();
		
		page.setEscolaridade(escolaridade);
		page.setEsporte(esportes);
		page.setSugestao("Nenhuma sugestao");
		page.cadastrar();
		System.out.println(msg);
		assertEquals(msg, dsl.alertaObterTexto());
		
	}
}

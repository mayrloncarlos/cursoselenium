package cursoselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEJanelas {
	
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
		driver.close();
		dsl.trocarJanela("");
		dsl.escreve(By.tagName("textarea"), "E agora?");
		
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = driver.findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicar("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		assertEquals("Frame OK!", msg);
		
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		
		dsl.clicar("buttonPopupHard");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escreve(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
		dsl.escreve(By.tagName("textarea"), "E agora?");
		
	}
}

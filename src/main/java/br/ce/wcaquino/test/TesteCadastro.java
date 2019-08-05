package br.ce.wcaquino.test;

import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {

	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
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

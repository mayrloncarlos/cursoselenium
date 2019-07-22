package cursoselenium;

import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicar("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicar("elementosForm:sexo:1");
	}
	
	public void setComidaCarne() {
		dsl.clicar("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFrango() {
		dsl.clicar("elementosForm:comidaFavorita:1");
	}
	
	public void setComidaVegetariana() {
		dsl.clicar("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}
	
	public void setEsporte(String... valores) {
		for(String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void setSugestao(String sugestao) {
		dsl.escreve("elementosForm:sugestoes", sugestao);
	}
	
	public void cadastrar() {
		dsl.clicar("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}
	
	public String obterNomeCadastro() {
		return dsl.obterTexto("descNome");
	}
	
	public String obterSobrenomeCadastro() {
		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto("descSexo");
	}
	
	public String obterComidaCadastro() {
		return dsl.obterTexto("descComida");
	}
	
	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto("descEscolaridade");
	}
	
	public String obterEsporteCadastro() {
		return dsl.obterTexto("descEsportes");
	}
	
	public String obterSugestaoCadastro() {
		return dsl.obterTexto("descSugestoes");
	}
}

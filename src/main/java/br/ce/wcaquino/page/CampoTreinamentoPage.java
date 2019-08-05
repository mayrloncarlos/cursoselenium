package br.ce.wcaquino.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class CampoTreinamentoPage extends BasePage {
	
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
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String obterNomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
	}
	
	public String obterSobrenomeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterComidaCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsporteCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}
	
	public String obterSugestaoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='descSugestoes']/span"));
	}
}

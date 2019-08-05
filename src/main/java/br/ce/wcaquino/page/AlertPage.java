package br.ce.wcaquino.page;

import br.ce.wcaquino.core.DSL;

public class AlertPage {

	private DSL dsl;
	
	public AlertPage() {
		dsl = new DSL();
	}
	
	public void clicar(String id) {
		dsl.clicar(id);
	}
}

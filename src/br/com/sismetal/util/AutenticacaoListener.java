package br.com.sismetal.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.sismetal.beans.AutenticacaoBeans;
import br.com.sismetal.doumain.Funcionario;

public class AutenticacaoListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		
		String paginaAtual = Faces.getViewId();		
		boolean pagAuten = false;
		pagAuten = paginaAtual.contains("faces/autenticar/autenticacao.xhtml");
		if(!pagAuten) {
			AutenticacaoBeans autenticacaoBeans = null;
			autenticacaoBeans = Faces.getSessionAttribute("autenticacaoBeans");
			if(autenticacaoBeans == null) {
				
				Faces.navigate("faces/autenticar/autenticacao.xhtml");
				return;
			}
			Funcionario funcionario = new Funcionario();
			funcionario = autenticacaoBeans.getUsuarioLogado();
			if(funcionario == null) {
				Faces.navigate("faces/autenticar/autenticacao.xhtml");
				return;
			}
		}
		System.out.println("CCCC");
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		
		
	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.RESTORE_VIEW;
	}

}

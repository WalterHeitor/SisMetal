package br.com.sismetal.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OrdemServicoInsumoBeans {

	
public void salvar() {
		
		try {
			
			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}

		try {

			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
	
	public void editar() {
		try {

			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
	public void excluir() {
		try {

			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
	@PostConstruct
	public void listar() {
		try {

			
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
}

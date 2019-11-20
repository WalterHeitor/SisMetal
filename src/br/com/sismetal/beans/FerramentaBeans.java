package br.com.sismetal.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.sismetal.dao.FerramentaDAO;
import br.com.sismetal.doumain.Ferramenta;
import br.com.sismetal.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FerramentaBeans implements Serializable {
	
	private Ferramenta ferramenta;
	private List<Ferramenta> ferramentas;
	private List<Ferramenta> ferramentasStatus;
	

	public Ferramenta getFerramenta() {
		return ferramenta;
	}


	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}


	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}


	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}
	

	public List<Ferramenta> getFerramentasStatus() {
		return ferramentasStatus;
	}


	public void setFerramentasStatus(List<Ferramenta> ferramentasStatus) {
		this.ferramentasStatus = ferramentasStatus;
	}

	@PostConstruct
	public void listar() {
		try {
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramentas = ferramentaDAO.listar();
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void novo() {
		ferramenta = new Ferramenta();
	}
	
	public void salvar() {
		try {
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramentaDAO.salvar(ferramenta);
			
			novo();
			
			ferramentas = ferramentaDAO.listar();
			
			JSFUtil.addMensagemSucesso("Ferrmenta salvo com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Ferramenta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void salvarEditar() {
		try {
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramentaDAO.salvarMerge(ferramenta);
			
			novo();
			
			ferramentas = ferramentaDAO.listar();
			
			JSFUtil.addMensagemSucesso("Ferrmenta salvo com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Ferramenta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			novo();
			ferramenta = (Ferramenta) evento.getComponent().getAttributes().get("ferrEditarSelecionado");
			
			
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao editar Ferramenta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			novo();
			ferramenta = (Ferramenta) evento.getComponent().getAttributes().get("ferrExcluirSelecionado");
			System.out.println(ferramenta);
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramentaDAO.excluir(ferramenta);
			ferramentas = ferramentaDAO.listar();
			JSFUtil.addMensagemSucesso("Ferrmenta deletado com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao excluir Ferramenta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}

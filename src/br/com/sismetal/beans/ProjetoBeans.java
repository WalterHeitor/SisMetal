package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.ClienteDAO;
import br.com.sismetal.dao.ProjetoDAO;
import br.com.sismetal.doumain.Cliente;
import br.com.sismetal.doumain.Projeto;

//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProjetoBeans {

	private Projeto projeto;
	private List<Projeto>projetos;
	
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	public void novo() {
		projeto = new Projeto();
	}
	public void novoLista() {
		projetos = new ArrayList<>();
	}
	public void salvar() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.salvar(projeto);
	}
	public void editar() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.salvarMerge(projeto);;
	}
	public void puxarCliente(ActionEvent event) {
		try {
			novo();
			projeto = (Projeto) event.getComponent().getAttributes().get("proEditarSelecionado");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selcionar o projeto!!!");
			e.printStackTrace();
		}
	}
	public void excluir(ActionEvent event) {
		try {
			novo();
			projeto = (Projeto) event.getComponent().getAttributes().get("proExcluirSelecionado");
			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetoDAO.excluir(projeto);;
			projetos = projetoDAO.listar();	
			Messages.addFlashGlobalInfo("Projeto Deletado com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar Deletar o Projeto!!!");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetos = projetoDAO.listar();
		novo();
	}
	
}

package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.ProjetoDAO;
import br.com.sismetal.doumain.Cliente;
import br.com.sismetal.doumain.Projeto;

//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProjetoBeans {

	private Projeto projeto;
	private List<Projeto>projetos;
	Cliente cliente;
	
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
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void novo() {
		projeto = new Projeto();
	}
	public void novoCliente() {
		cliente = new Cliente();
	}
	public void novoLista() {
		projetos = new ArrayList<>();
	}
	public void salvar() {
		try {
			projeto.setCliente(cliente);
			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetoDAO.salvar(projeto);
			Messages.addFlashGlobalInfo("Projeto Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selcionar o projeto!!!");
			e.printStackTrace();
		}
	}
	public void editar() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.salvarMerge(projeto);;
	}
	public void puxarProjeto(ActionEvent event) {
		try {
			novo();
			projeto = (Projeto) event.getComponent().getAttributes().get("proEditarSelecionado");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selcionar o projeto!!!");
			e.printStackTrace();
		}
	}
	public void puxarCliente(ActionEvent event) {
		try {
			novoCliente();
			cliente = (Cliente) event.getComponent().getAttributes().get("cliEditarSelecionado");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selecionar o cliente!!!");
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
		try {
			projetos = new ArrayList<>();
			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetos = projetoDAO.listar();
			novo();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar Listar os Projetos!!!");
			e.printStackTrace();
		}
	}
	
}

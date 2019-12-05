package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sismetal.dao.ProjetoDAO;
import br.com.sismetal.doumain.Projeto;

//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProjetoBeans {

	private Projeto projeto;
	private List<Projeto>projetos;
	
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
	
	public void listar() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetos = projetoDAO.listar();
		novo();
	}
	
}

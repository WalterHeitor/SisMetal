package br.com.sismetal.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sismetal.dao.OrdemServicoDAO;
import br.com.sismetal.doumain.OrdemServico;
//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OrdemServicoBeans {

	
	private OrdemServico ordemServico;
	private List<OrdemServico>ordemServicos;
	
	public void novo() {
		ordemServico = new OrdemServico();
	}
	
	public void salvar() {
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
		ordemServicoDAO.salvar(ordemServico);
	}
	
	public void listar() {
		OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
		ordemServicos = ordemServicoDAO.listar();
		novo();
	}
	
}

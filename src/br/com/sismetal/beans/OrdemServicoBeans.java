package br.com.sismetal.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.OrdemServicoDAO;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.doumain.OrdemServico;
import br.com.sismetal.doumain.Projeto;
//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OrdemServicoBeans {

	
	private OrdemServico ordemServico;
	private List<OrdemServico>ordemServicos;
	private Projeto projeto;
	private Funcionario funcionarioGerente;
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Funcionario getFuncionarioGerente() {
		return funcionarioGerente;
	}

	public void setFuncionarioGerente(Funcionario funcionarioGerente) {
		this.funcionarioGerente = funcionarioGerente;
	}

	public void novo() {
		ordemServico = new OrdemServico();
	}
	public void novoProjeto() {
		projeto = new Projeto();
	}
	public void novoFuncionarioGerente() {
		funcionarioGerente = new Funcionario();
	}
	
	public void salvar() {
		try {
			ordemServico.setProjeto(projeto);
			ordemServico.setFuncionarioGerente(funcionarioGerente);
			OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
			ordemServicoDAO.salvar(ordemServico);
			ordemServicos = ordemServicoDAO.listar();
			novo();
			Messages.addFlashGlobalInfo("Ordem de Serviço Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o Ordem de Serviço!!!");
		}
	}
	public void editar() {
		try {
			
			OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
			ordemServicoDAO.salvarMerge(ordemServico);
			ordemServicos = ordemServicoDAO.listar();
			novo();
			Messages.addFlashGlobalInfo("Ordem de Serviço Editado com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar Editar o Ordem de Serviço!!!");
		}
	}
	public void puxarOsEditar(ActionEvent event) {
		try {
			novo();
			ordemServico = (OrdemServico) event.getComponent().getAttributes().get("OS_SelecionadoEd");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selcionar o projeto!!!");
			e.printStackTrace();
		}
	}
	public void puxarOsExcluir(ActionEvent event) {
		try {
			novo();
			ordemServico = (OrdemServico) event.getComponent().getAttributes().get("OS_SelecionadoEx");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selcionar o projeto!!!");
			e.printStackTrace();
		}
	}
	public void puxarProjeto(ActionEvent event) {
		try {
			novoProjeto();
			projeto = (Projeto) event.getComponent().getAttributes().get("proEditarSelecionado");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selcionar o projeto!!!");
			e.printStackTrace();
		}
	}
	public void puxarFuncionarioGerente(ActionEvent event) {
		try {
			novoFuncionarioGerente();
			funcionarioGerente = (Funcionario) event.getComponent().getAttributes().get("funEditarSelecionado");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selcionar o projeto!!!");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar() {
		try {
			OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
			ordemServicos = ordemServicoDAO.listar();
			novo();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar listar a Ordem de Serviço!!!");
		}
	}
	
}

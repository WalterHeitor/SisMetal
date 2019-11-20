package br.com.sismetal.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.sismetal.dao.TelefoneDAO;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.doumain.Telefone;
import br.com.sismetal.util.JSFUtil;
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TelefoneBeans implements Serializable {

	private Funcionario funcionario;
	private Telefone telefone;
	private List<Funcionario> funcionarios;
	private List<Telefone> telefones;
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	@PostConstruct
	public void listar() {
		try {
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			telefones = telefoneDAO.listar();
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao listar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void novo() {
		telefone = new Telefone();
	}
	
	public void puxarFuncionarioTable(ActionEvent event) {
		funcionario = new Funcionario();
		funcionario = (Funcionario) event.getComponent().getAttributes().get("funcTelefoneSelecionado");
		novo();		
	}
	public void excluir(ActionEvent event) {
		try {
			telefone = new Telefone();
			telefone = (Telefone) event.getComponent().getAttributes().get("telefoneExcluirSelecionado");
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			telefoneDAO.excluir(telefone);
			novo();		
			telefones = telefoneDAO.listar();
			JSFUtil.addMensagemSucesso("Telefone Deletado com Sucesso!!!");
		
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao Deletar Telefone: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void salvarTelefone() {

		try {		
			telefone.setFuncionario(funcionario);			
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			telefoneDAO.salvar(telefone);
			novo();
			telefones = telefoneDAO.listar();
			JSFUtil.addMensagemSucesso("Telefone salvo com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Telefone: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void mergeTelefone() {

		try {		
			telefone.setFuncionario(funcionario);			
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			telefoneDAO.salvarMerge(telefone);
			novo();
			telefones = telefoneDAO.listar();
			JSFUtil.addMensagemSucesso("Telefone salvo com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Telefone: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void editar(ActionEvent event) {
		try {
			telefone = new Telefone();
			telefone = (Telefone) event.getComponent().getAttributes().get("telefoneEditarSelecionado");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao editar Telefone: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void editarTelefone() {

		try {		
			telefone.setFuncionario(funcionario);			
			TelefoneDAO telefoneDAO = new TelefoneDAO();
			telefoneDAO.salvarMerge(telefone);
			novo();
			telefones = telefoneDAO.listar();
			JSFUtil.addMensagemSucesso("Telefone editado com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Telefone: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
}

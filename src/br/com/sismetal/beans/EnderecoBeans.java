package br.com.sismetal.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.sismetal.dao.EnderecoDAO;
import br.com.sismetal.doumain.Endereco;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoBeans implements Serializable{
	
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private Endereco endereco;
	private List<Endereco>enderecos;
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	@PostConstruct
	public void listar() {
		try {
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecos = enderecoDAO.listar();
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao listar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void novo() {
		endereco = new Endereco();
	}
	/**
	 * função que puxa da tabela o funcionario 
	 * @param event
	 */
	public void puxarFuncionarioTable(ActionEvent event) {
		funcionario = new Funcionario();
		funcionario = (Funcionario) event.getComponent().getAttributes().get("funcEnderecoSelecionado");
		novo();
	}
	/**
	 * 
	 * função salvar endereço
	 */
	public void salvar() {
		try {
			endereco.setFuncionario(funcionario);
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.salvar(endereco);
			novo();
			enderecos = enderecoDAO.listar();
			JSFUtil.addMensagemSucesso("Endereço salvo com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Endereço: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}public void merge() {
		try {
			endereco.setFuncionario(funcionario);
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.salvarMerge(endereco);
			novo();
			enderecos = enderecoDAO.listar();
			JSFUtil.addMensagemSucesso("Endereço salvo com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Endereço: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			novo();
			endereco = (Endereco) evento.getComponent().getAttributes().get("enderEditarSelecionado");			
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao editar Funcionario: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent event) {
		try {
			endereco = new Endereco();
			endereco = (Endereco) event.getComponent().getAttributes().get("EnderExcluirSelecionado");
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.excluir(endereco);
			novo();		
			enderecos = enderecoDAO.listar();
			JSFUtil.addMensagemSucesso("Telefone Deletado com Sucesso!!!");
		
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao Deletar Telefone: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}

}

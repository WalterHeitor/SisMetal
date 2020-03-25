package br.com.sismetal.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import br.com.sismetal.dao.FuncionarioDAO;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.doumain.Telefone;
import br.com.sismetal
.util.JSFUtil;
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBeans implements Serializable {
	
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
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
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
			novo();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarios = funcionarioDAO.listar();
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao listar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void novo() {
		funcionario = new Funcionario();
		telefone = new Telefone();

	}

	
	public void salvar() {
		if(funcionario.getSenhaSemCriptografia().equals(funcionario.getSenha())) {
			try {
				SimpleHash hash = new SimpleHash("md5", funcionario.getSenhaSemCriptografia());
				funcionario.setSenha(hash.toHex());
				FuncionarioDAO fdao = new FuncionarioDAO();
				fdao.salvar(funcionario);
				
				novo();
				
				funcionarios = fdao.listar();
				
				JSFUtil.addMensagemSucesso("Funcionario salvo com Sucesso!!!");
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao salvar Funcionario: e.getMessage() " + e.getMessage());
				e.printStackTrace();
			}
		}else {
			Messages.addFlashGlobalError("Senha não Confere !!!");
			
		}
	}
	
	public void salvarEditar() {
		if(funcionario.getSenhaSemCriptografia().equals(funcionario.getSenha())) {
			try {
				SimpleHash hash = new SimpleHash("md5", funcionario.getSenhaSemCriptografia());
				funcionario.setSenha(hash.toHex());
				FuncionarioDAO fdao = new FuncionarioDAO();
				fdao.salvarMerge(funcionario);
				
				novo();
				
				funcionarios = fdao.listar();
				
				JSFUtil.addMensagemSucesso("Funcionario salvo com Sucesso!!!");
			} catch (Exception e) {
				JSFUtil.addMensagemErro("erro ao salvar Funcionario: e.getMessage() " + e.getMessage());
				e.printStackTrace();
			}
		}else {
			Messages.addFlashGlobalError("Senha não Confere !!!");
		}
		
	}
	
	public void salvar2() {
		novo();
		FuncionarioDAO fdao = new FuncionarioDAO();
		funcionarios = fdao.listar();	
		try {			
			fdao.salvarMerge(funcionario);									
			funcionarios = fdao.listar();			
			JSFUtil.addMensagemSucesso("Funcionario salvo com Sucesso!!!");
			
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar Funcionario: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		
		try {			
			novo();
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcExcluirSelecionado");
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionario);
			
			funcionarios = funcionarioDAO.listar();
			
			JSFUtil.addMensagemSucesso("Funcionario Deletado com Sucesso!!!");
			
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao excluir Funcionario: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			novo();
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcEditarSelecionado");	
			funcionario.setSenha("");
			Messages.addGlobalInfo("Insira uma nova senha");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao editar Funcionario: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}

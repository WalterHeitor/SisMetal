package br.com.sismetal.beans;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.sismetal.dao.FuncionarioDAO;
import br.com.sismetal.doumain.Funcionario;

@ManagedBean
@SessionScoped
public class AutenticacaoBeans {

	private Funcionario funcionario;
	private Funcionario usuarioLogado;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Funcionario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Funcionario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	@PostConstruct
	public void novo() {
		funcionario = new Funcionario();
	}
	
	public void autenticar() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			usuarioLogado = funcionarioDAO.autenticar
			(funcionario.getEmail_func(), funcionario.getSenha());
			if(usuarioLogado == null) {
				Messages.addGlobalError("Email ou senha incorretos");
				return;
			}
			
			Faces.redirect("faces/admin/pages/index.xhtml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}

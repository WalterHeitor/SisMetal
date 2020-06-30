package br.com.sismetal.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private boolean c = false;
	private boolean d = false;
	private boolean r = false;

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
	
	public boolean isC() {
		return c;
	}

	public void setC(boolean c) {
		this.c = c;
	}

	public boolean isD() {
		return d;
	}

	public void setD(boolean d) {
		this.d = d;
	}
	

	public boolean isR() {
		return r;
	}

	public void setR(boolean r) {
		this.r = r;
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
			temPermisssaoCadastrar();
			temPermisssaoDeletar();
			temPermisssaoRelatorio();
			Faces.redirect("faces/index.xhtml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean temPermisCadastrar(List<String>permissoes) {
		
		for (String permissao: permissoes) {
			if(usuarioLogado.getCargo_func().equals(permissao)) {
				return true;				
			}
		}
		return false;
	}
public boolean temPermisssaoCadastrar() {
	List<String>permissoes;
	permissoes = new ArrayList<String>();
	permissoes.add("Administrador");
	permissoes.add("Gerente");
		for (String permissao: permissoes) {
			if(usuarioLogado.getCargo_func().equals(permissao)) {
				c = true;
				return c;				
			}
		}
		c = false;
		return c;
	}
public boolean temPermisssaoRelatorio() {
	List<String>permissoes;
	permissoes = new ArrayList<String>();
	permissoes.add("Administrador");
	permissoes.add("Gerente");
	permissoes.add("Encarregado");
		for (String permissao: permissoes) {
			if(usuarioLogado.getCargo_func().equals(permissao)) {
				r = true;
				return r;				
			}
		}
		r = false;
		return r;
	}
public boolean temPermisssaoDeletar() {
	String permissoes;
	permissoes = "Administrador";

			if(usuarioLogado.getCargo_func().equals(permissoes)) {
				System.out.println("true - 1");
				d = true;
				return d;				
			}
		
		System.out.println("false ");
		d = false;
		return d;
	}
	
}

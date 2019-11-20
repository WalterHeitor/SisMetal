package br.com.sismetal.doumain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
@SuppressWarnings("serial")
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	@Id()
	@NotEmpty(message="Insira a matricula:")
	@Column(unique = true)
	private String matricula;
	@NotEmpty(message="Insira a nome:")
	@Column
	private String nome;
	@NotEmpty(message="Selecione o setor:")
	@Column
	private String setor;
	// @CPF(message="Cpf Incorreto")
	@Column(length = 50, unique = true)
	private String cpf_func;
	@NotEmpty(message="Selecione o cargo:")
	@Column
	private String cargo_func;
	@NotEmpty(message="Selecione o status:")
	@Column
	private String status_func;
	@NotEmpty(message="Insira o email:")
	@Column
	private String email_func;
	@NotEmpty(message="insira a senha:")
	@Column
	private String senha;
	
	@Transient
	private String senhaSemCriptografia;

	public Funcionario() {
	}

	public Funcionario(String matricula, String nome, String setor, String cpf_func, String cargo_func,
			String status_func, String email_func, String senha) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.setor = setor;
		this.cpf_func = cpf_func;
		this.cargo_func = cargo_func;
		this.status_func = status_func;
		this.email_func = email_func;
		this.senha = senha;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCpf_func() {
		return cpf_func;
	}

	public void setCpf_func(String cpf_func) {
		this.cpf_func = cpf_func;
	}

	public String getCargo_func() {
		return cargo_func;
	}

	public void setCargo_func(String cargo_func) {
		this.cargo_func = cargo_func;
	}

	public String getEmail_func() {
		return email_func;
	}

	public void setEmail_func(String email_func) {
		this.email_func = email_func;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus_func() {
		return status_func;
	}

	public void setStatus_func(String status_func) {
		this.status_func = status_func;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}
	
	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", nome=" + nome + ", setor=" + setor + ", cpf_func=" + cpf_func
				+ ", cargo_func=" + cargo_func + ", status_func=" + status_func + ", email_func=" + email_func
				+ ", senha=" + senha + "]";
	}

	
	
}

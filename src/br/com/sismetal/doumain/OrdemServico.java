package br.com.sismetal.doumain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
@Table(name="ordem_servico")
public class OrdemServico implements Serializable {

	@Id
	@Column(unique = true)
    private String id_ordem_servico;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_inicio")
    private Date dt_inicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_fim")
    private Date dt_fim;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="projeto",
    referencedColumnName="id_projeto", nullable=true)
    Projeto projeto;
        
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionarioGerente",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionarioGerente;

	public String getId_ordem_servico() {
		return id_ordem_servico;
	}
	public void setId_ordem_servico(String id_ordem_servico) {
		this.id_ordem_servico = id_ordem_servico;
	}
	public Date getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Date getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
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
	public OrdemServico() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdemServico(String id_ordem_servico, Date dt_inicio, Date dt_fim, Projeto projeto,
			Funcionario funcionarioGerente) {
		super();
		this.id_ordem_servico = id_ordem_servico;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.projeto = projeto;
		this.funcionarioGerente = funcionarioGerente;
	}
    
    
}

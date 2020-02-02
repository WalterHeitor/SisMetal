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
@Table(name="ordem_servico_insumo")
public class OrdemServicoInsumo implements Serializable{

	
	@Id
	@Column(unique = true)
    private String id_ordem_servico_insumo;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dtEntrInsumo;
	
	@Column
	private float qtdInsumo;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="insumo",
    referencedColumnName="id_insumo", nullable=true)
    Insumo insumo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ordem_servico",
    referencedColumnName="id_ordem_servico", nullable=true)
    OrdemServico ordemServico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionario_almoxarifado",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionarioAlmoxarifado;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionario_fabrica",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionarioFabrica;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionario_gerente",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionarioGerente;

	public String getId_ordem_servico_insumo() {
		return id_ordem_servico_insumo;
	}

	public void setId_ordem_servico_insumo(String id_ordem_servico_insumo) {
		this.id_ordem_servico_insumo = id_ordem_servico_insumo;
	}

	public Date getDtEntrInsumo() {
		return dtEntrInsumo;
	}

	public void setDtEntrInsumo(Date dtEntrInsumo) {
		this.dtEntrInsumo = dtEntrInsumo;
	}

	public float getQtdInsumo() {
		return qtdInsumo;
	}

	public void setQtdInsumo(float qtdInsumo) {
		this.qtdInsumo = qtdInsumo;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Funcionario getFuncionarioAlmoxarifado() {
		return funcionarioAlmoxarifado;
	}

	public void setFuncionarioAlmoxarifado(Funcionario funcionarioAlmoxarifado) {
		this.funcionarioAlmoxarifado = funcionarioAlmoxarifado;
	}

	public Funcionario getFuncionarioFabrica() {
		return funcionarioFabrica;
	}

	public void setFuncionarioFabrica(Funcionario funcionarioFabrica) {
		this.funcionarioFabrica = funcionarioFabrica;
	}

	public Funcionario getFuncionarioGerente() {
		return funcionarioGerente;
	}

	public void setFuncionarioGerente(Funcionario funcionarioGerente) {
		this.funcionarioGerente = funcionarioGerente;
	}
	
    
	
	
    
}

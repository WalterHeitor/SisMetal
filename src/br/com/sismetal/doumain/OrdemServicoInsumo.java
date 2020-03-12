package br.com.sismetal.doumain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(
		 name = "optimized-sequence-ordem_servico_insumo",
		 strategy = "enhanced-sequence",
		 parameters = {
		 @Parameter(name="prefer_sequence_per_entity", value="true"),
		 @Parameter(name="optimizer", value="hilo"),
		 @Parameter(name="increment_size", value="1")})
		@SuppressWarnings("serial")
@Entity
@Table(name="ordem_servico_insumo")
public class OrdemServicoInsumo implements Serializable{

	@Id
    @GeneratedValue(generator="optimized-sequence-ordem_servico_insumo")
    private Long id_ordem_servico_insumo;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dtEntrInsumo;
	
	@Column
	private float qtdInsumo;
	
	@Column
	private BigDecimal preco;
    
	
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

	public Long getId_ordem_servico_insumo() {
		return id_ordem_servico_insumo;
	}

	public void setId_ordem_servico_insumo(Long id_ordem_servico_insumo) {
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setQtdInsumo(float qtdInsumo) {
		this.qtdInsumo = qtdInsumo;
	}

	public void setPreco(BigDecimal bigDecimal) {
		this.preco = bigDecimal;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_ordem_servico_insumo == null) ? 0 : id_ordem_servico_insumo.hashCode());
		result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
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
		OrdemServicoInsumo other = (OrdemServicoInsumo) obj;
		if (id_ordem_servico_insumo == null) {
			if (other.id_ordem_servico_insumo != null)
				return false;
		} else if (!id_ordem_servico_insumo.equals(other.id_ordem_servico_insumo))
			return false;
		if (insumo == null) {
			if (other.insumo != null)
				return false;
		} else if (!insumo.equals(other.insumo))
			return false;
		return true;
	}

    
	

	
	
    
	
	
    
}

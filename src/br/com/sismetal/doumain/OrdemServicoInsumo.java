package br.com.sismetal.doumain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ordem_servico_insumo")
public class OrdemServicoInsumo implements Serializable{

	
	@Id
	@Column(unique = true)
    private String id_ordem_servico_insumo;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="insumo",
    referencedColumnName="id_insumo", nullable=true)
    Insumo insumo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ordem_servico",
    referencedColumnName="id_ordem_servico", nullable=true)
    OrdemServico ordemServico;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="projeto",
    referencedColumnName="id_projeto", nullable=true)
    Projeto projeto;
       
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente",
    referencedColumnName="id_cliente", nullable=true)
    Cliente cliente;
    
    public Insumo getInsumo() {
		return insumo;
	}
    public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
    
    public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
    public Projeto getProjeto() {
		return projeto;
	}
    
    public Cliente getCliente() {
		return cliente;
	}
    public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
    public OrdemServico getOrdemServico() {
		return ordemServico;
	}
    public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
   
    
	public OrdemServicoInsumo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getId_ordem_servico_insumo() {
		return id_ordem_servico_insumo;
	}
	public void setId_ordem_servico_insumo(String id_ordem_servico_insumo) {
		this.id_ordem_servico_insumo = id_ordem_servico_insumo;
	}
	
    
	
	
    
}

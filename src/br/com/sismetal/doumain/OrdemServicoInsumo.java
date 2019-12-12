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
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="insumo",
    referencedColumnName="id_insumo", nullable=true)
    Insumo insumo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ordem_servico",
    referencedColumnName="id_ordem_servico", nullable=true)
    OrdemServico ordemServico;
    
   
	
    
	
	
    
}

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_prevista")
    private Date dt_prevista;
    @Column
    private String descricao_servico;
    @Column
    private String statusservco;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="projeto",
    referencedColumnName="id_projeto", nullable=true)
    Projeto projeto;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionarioColaborador",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionarioColaborador;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionarioGerente",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionarioGerente;
    
}

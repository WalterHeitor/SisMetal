package br.com.sismetal.doumain;

import java.io.Serializable;
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
		 name = "optimized-sequence-ordem_servico_mao_obra",
		 strategy = "enhanced-sequence",
		 parameters = {
		 @Parameter(name="prefer_sequence_per_entity", value="true"),
		 @Parameter(name="optimizer", value="hilo"),
		 @Parameter(name="increment_size", value="1")})

@SuppressWarnings("serial")
@Entity
@Table(name="ordem_servico_mao_obra")
public class OrdemServicoMaoObra implements Serializable{

	@Id
    @GeneratedValue(generator="optimized-sequence-ordem_servico_mao_obra")
	//@Column(unique = true)
    private Long id_osMaoObra;
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_inicioAtv")
    private Date dt_inicioAtv;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_fimAtv")
    private Date dt_fimAtv;
	@Column
    private String descricao_servico;
    @Column
    private String statusservco;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionarioColaborador",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionarioColaborador;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ordem_servico",
    referencedColumnName="id_ordem_servico", nullable=true)
    OrdemServico ordemServico;
}

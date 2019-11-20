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

@GenericGenerator(
		 name = "optimized-sequence-emprestimo_ferramenta",
		 strategy = "enhanced-sequence",
		 parameters = {
		 @Parameter(name="prefer_sequence_per_entity", value="true"),
		 @Parameter(name="optimizer", value="hilo"),
		 @Parameter(name="increment_size", value="1")})
@SuppressWarnings("serial")
		@Entity
		@Table(name="devolucao_ferramenta")
public class DevolucaoFerramentaEstragada implements Serializable{

	@Id
    @GeneratedValue(generator="optimized-sequence-emprestimo_ferramenta")
    private Long id_devolucao_ferramenta;
	@Column
	String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="emprestimo_ferramenta_codigo",
    referencedColumnName="id_emprestimo_ferramenta", nullable=true)
    EmprestimoFerramenta emprestimoFerramenta;

	public Long getId_devolucao_ferramenta() {
		return id_devolucao_ferramenta;
	}

	public void setId_devolucao_ferramenta(Long id_devolucao_ferramenta) {
		this.id_devolucao_ferramenta = id_devolucao_ferramenta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EmprestimoFerramenta getEmprestimoFerramenta() {
		return emprestimoFerramenta;
	}

	public void setEmprestimoFerramenta(EmprestimoFerramenta emprestimoFerramenta) {
		this.emprestimoFerramenta = emprestimoFerramenta;
	}

	public DevolucaoFerramentaEstragada() {
		super();
	}

	public DevolucaoFerramentaEstragada(String descricao, EmprestimoFerramenta emprestimoFerramenta) {
		super();
		this.descricao = descricao;
		this.emprestimoFerramenta = emprestimoFerramenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_devolucao_ferramenta == null) ? 0 : id_devolucao_ferramenta.hashCode());
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
		DevolucaoFerramentaEstragada other = (DevolucaoFerramentaEstragada) obj;
		if (id_devolucao_ferramenta == null) {
			if (other.id_devolucao_ferramenta != null)
				return false;
		} else if (!id_devolucao_ferramenta.equals(other.id_devolucao_ferramenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DevolucaoFerramentaEstragada [id_devolucao_ferramenta=" + id_devolucao_ferramenta + ", descricao="
				+ descricao + ", emprestimoFerramenta=" + emprestimoFerramenta + "]";
	}
	
	
}

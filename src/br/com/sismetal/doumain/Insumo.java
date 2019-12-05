package br.com.sismetal.doumain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="insumo")
public class Insumo implements Serializable {

	
	@Id
	@Column(unique = true)
    private String id_insumo;
    @Column
    private String descricao_produto;
    @Column
    private float unidade;
    @Column
    private BigDecimal preco;
    
	public String getId_insumo() {
		return id_insumo;
	}
	public void setId_insumo(String id_insumo) {
		this.id_insumo = id_insumo;
	}
	public String getDescricao_produto() {
		return descricao_produto;
	}
	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	public float getUnidade() {
		return unidade;
	}
	public void setUnidade(float unidade) {
		this.unidade = unidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Insumo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insumo(String id_insumo, String descricao_produto, float unidade, BigDecimal preco) {
		super();
		this.id_insumo = id_insumo;
		this.descricao_produto = descricao_produto;
		this.unidade = unidade;
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Insumo [id_insumo=" + id_insumo + ", descricao_produto=" + descricao_produto + ", unidade=" + unidade
				+ ", preco=" + preco + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_insumo == null) ? 0 : id_insumo.hashCode());
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
		Insumo other = (Insumo) obj;
		if (id_insumo == null) {
			if (other.id_insumo != null)
				return false;
		} else if (!id_insumo.equals(other.id_insumo))
			return false;
		return true;
	}
	
	

    
    
}

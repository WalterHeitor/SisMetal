package br.com.sismetal.doumain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
@Table(name = "ferramenta")
public class Ferramenta implements Serializable{
	@Id
	//@NotEmpty(message="Insira o codigo da ferramenta:")
	@Column(unique=true)
	private String codigoBarra;
	//@NotEmpty(message="Selecione o status da ferramenta:")
	@Column
    private  String status;
	//@NotEmpty(message="Insira a descriçaõ da ferramenta:")
    @Column
    private String descricao_ferr;
	//@NotEmpty(message="Insira a numero da nota fiscal:")
    @Column
    private String num_nota_fiscal_ferr;
	//@NotEmpty(message="Selecione a categoria da ferramenta:")
    @Column
    private String categoria_ferr;
    @Temporal(TemporalType.DATE)
    @Column(name="dt_entrega_ferr")
    private Date dt_entrega_ferr;
   // @NotEmpty(message="Insira o local:")
    @Column
    private String local_ferr;
    
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescricao_ferr() {
		return descricao_ferr;
	}
	public void setDescricao_ferr(String descricao_ferr) {
		this.descricao_ferr = descricao_ferr;
	}
	public String getNum_nota_fiscal_ferr() {
		return num_nota_fiscal_ferr;
	}
	public void setNum_nota_fiscal_ferr(String num_nota_fiscal_ferr) {
		this.num_nota_fiscal_ferr = num_nota_fiscal_ferr;
	}
	public String getCategoria_ferr() {
		return categoria_ferr;
	}
	public void setCategoria_ferr(String categoria_ferr) {
		this.categoria_ferr = categoria_ferr;
	}
	public Date getDt_entrega_ferr() {
		return dt_entrega_ferr;
	}
	public void setDt_entrega_ferr(Date dt_entrega_ferr) {
		this.dt_entrega_ferr = dt_entrega_ferr;
	}
	public String getLocal_ferr() {
		return local_ferr;
	}
	public void setLocal_ferr(String local_ferr) {
		this.local_ferr = local_ferr;
	}
	public Ferramenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ferramenta(String codigoBarra, String status, String descricao_ferr, String num_nota_fiscal_ferr,
			String categoria_ferr, Date dt_entrega_ferr, String local_ferr) {
		super();
		this.codigoBarra = codigoBarra;
		this.status = status;
		this.descricao_ferr = descricao_ferr;
		this.num_nota_fiscal_ferr = num_nota_fiscal_ferr;
		this.categoria_ferr = categoria_ferr;
		this.dt_entrega_ferr = dt_entrega_ferr;
		this.local_ferr = local_ferr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoBarra == null) ? 0 : codigoBarra.hashCode());
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
		Ferramenta other = (Ferramenta) obj;
		if (codigoBarra == null) {
			if (other.codigoBarra != null)
				return false;
		} else if (!codigoBarra.equals(other.codigoBarra))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ferramenta [codigoBarra=" + codigoBarra + ", status=" + status + ", descricao_ferr=" + descricao_ferr
				+ ", num_nota_fiscal_ferr=" + num_nota_fiscal_ferr + ", categoria_ferr=" + categoria_ferr
				+ ", dt_entrega_ferr=" + dt_entrega_ferr + ", local_ferr="
				+ local_ferr + "]";
	}
    
    
}

package br.com.sismetal.doumain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.br.CNPJ;

@GenericGenerator(
		 name = "optimized-sequence-emprestimo_ferramenta",
		 strategy = "enhanced-sequence",
		 parameters = {
		 @Parameter(name="prefer_sequence_per_entity", value="true"),
		 @Parameter(name="optimizer", value="hilo"),
		 @Parameter(name="increment_size", value="1")})
		@SuppressWarnings("serial")
		@Entity
public class Cliente implements Serializable {

	@Id
    @GeneratedValue(generator="optimized-sequence-emprestimo_ferramenta")
	//@Column(unique = true)
    private Long id_cliente;
    @Column
	private String nome;
	@Column
    private String razao_social;
    @Column
    private String fantasia;
    @Column
   // @CNPJ
    private String cnpj;
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nome, String razao_social, String fantasia, String cnpj) {
		super();
		this.nome = nome;
		this.razao_social = razao_social;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", razao_social=" + razao_social + ", fantasia="
				+ fantasia + ", cnpj=" + cnpj + "]";
	}
    
    
}

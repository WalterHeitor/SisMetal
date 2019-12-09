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
import org.hibernate.validator.constraints.NotEmpty;
@GenericGenerator(
	    name = "optimized-sequence-endereco",
	    strategy = "enhanced-sequence",
	    parameters = {
	        @Parameter(name="prefer_sequence_per_entity", value="true"),
	        @Parameter(name="optimizer", value="hilo"),
	        @Parameter(name="increment_size", value="1")})
@SuppressWarnings("serial")
@Entity
@Table(name ="endereco")
public class Endereco implements Serializable{

	@Id
    @GeneratedValue(generator="optimized-sequence-endereco")
    private Integer id_endereco;
	@NotEmpty(message="Insira a largadouro:")
    @Column
    private String largadouro;
	@NotEmpty(message="Insira a cidade:")
    @Column
    private String cidade;
	@NotEmpty(message="Insira a estado:")
    @Column
    private String estado;
	@NotEmpty(message="Insira o CEP:")
    @Column
    private String cep;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="funcionario_matricula",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente",
    referencedColumnName="id_cliente", nullable=true)
    Cliente cliente;

	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getLargadouro() {
		return largadouro;
	}

	public void setLargadouro(String largadouro) {
		this.largadouro = largadouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Endereco() {
		super();
	}
	
	

	public Endereco(String largadouro, String cidade, String estado, String cep, Funcionario funcionario) {
		super();
		this.largadouro = largadouro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_endereco == null) ? 0 : id_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (id_endereco == null) {
			if (other.id_endereco != null)
				return false;
		} else if (!id_endereco.equals(other.id_endereco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id_endereco=" + id_endereco + ", largadouro=" + largadouro + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + ", funcionario=" + funcionario + "]";
	}
    
    
}

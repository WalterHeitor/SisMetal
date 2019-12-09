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
		name = "optimized-sequence-telefone", 
		strategy = "enhanced-sequence",
		parameters= {
				@Parameter(name="prefer_sequence_per_entity", value="true"),
		        @Parameter(name="optimizer", value="hilo"),
		        @Parameter(name="increment_size", value="1")})
@SuppressWarnings("serial")
@Entity
@Table(name = "telefone")

public class Telefone implements Serializable{

	@Id
    @GeneratedValue(generator="optimized-sequence-telefone")
    @Column
    private Long id_telefone;
	@NotEmpty(message="Digite o telefone:")
    @Column
    private String num_telefone;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="matricula",
    referencedColumnName="matricula", nullable=true)
    Funcionario funcionario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente",
    referencedColumnName="id_cliente", nullable=true)
    Cliente cliente;

	public Long getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(Long id_telefone) {
		this.id_telefone = id_telefone;
	}

	public String getNum_telefone() {
		return num_telefone;
	}

	public void setNum_telefone(String num_telefone) {
		this.num_telefone = num_telefone;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Telefone(String num_telefone, Funcionario funcionario) {
		super();
		this.num_telefone = num_telefone;
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_telefone == null) ? 0 : id_telefone.hashCode());
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
		Telefone other = (Telefone) obj;
		if (id_telefone == null) {
			if (other.id_telefone != null)
				return false;
		} else if (!id_telefone.equals(other.id_telefone))
			return false;
		return true;
	}
	

	

	

	
    
}

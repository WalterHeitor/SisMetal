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
 name = "optimized-sequence-emprestimo_ferramenta",
 strategy = "enhanced-sequence",
 parameters = {
 @Parameter(name="prefer_sequence_per_entity", value="true"),
 @Parameter(name="optimizer", value="hilo"),
 @Parameter(name="increment_size", value="1")})
@SuppressWarnings("serial")
@Entity
@Table(name="emprestimo_ferramenta")
public class EmprestimoFerramenta implements Serializable {

	    @Id
	    @GeneratedValue(generator="optimized-sequence-emprestimo_ferramenta")
	    private Long id_emprestimo_ferramenta;
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name="dt_saida_emp")
	    private Date dt_saida_emp;
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name="dt_entrega")
	    private Date dt_entrega;
	    @Column
	    private boolean devolucao;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name="funcionario_almoxarifado",
	    referencedColumnName="matricula", nullable=true)
	    Funcionario funcionarioAlmoxarifado;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name="funcionario_fabrica",
	    referencedColumnName="matricula", nullable=true)
	    Funcionario funcionarioFabrica;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name="ferramenta_codigo_barra",
	    referencedColumnName="codigoBarra", nullable=true)
	    Ferramenta ferramenta;

		public EmprestimoFerramenta() {
			super();
			// TODO Auto-generated constructor stub
		}

		public EmprestimoFerramenta(Long id_emprestimo_ferramenta, Date dt_saida_emp, Date dt_entrega,
				Funcionario funcionarioAlmoxarifado, Funcionario funcionarioFabrica, Ferramenta ferramenta) {
			super();
			this.id_emprestimo_ferramenta = id_emprestimo_ferramenta;
			this.dt_saida_emp = dt_saida_emp;
			this.dt_entrega = dt_entrega;
			this.funcionarioAlmoxarifado = funcionarioAlmoxarifado;
			this.funcionarioFabrica = funcionarioFabrica;
			this.ferramenta = ferramenta;
		}

		public Long getId_emprestimo_ferramenta() {
			return id_emprestimo_ferramenta;
		}

		public void setId_emprestimo_ferramenta(Long id_emprestimo_ferramenta) {
			this.id_emprestimo_ferramenta = id_emprestimo_ferramenta;
		}

		public Date getDt_saida_emp() {
			return dt_saida_emp;
		}

		public void setDt_saida_emp(Date dt_saida_emp) {
			this.dt_saida_emp = dt_saida_emp;
		}

		public Date getDt_entrega() {
			return dt_entrega;
		}

		public void setDt_entrega(Date dt_entrega) {
			this.dt_entrega = dt_entrega;
		}
		

		public boolean isDevolucao() {
			return devolucao;
		}

		public void setDevolucao(boolean devolucao) {
			this.devolucao = devolucao;
		}

		public Funcionario getFuncionarioAlmoxarifado() {
			return funcionarioAlmoxarifado;
		}

		public void setFuncionarioAlmoxarifado(Funcionario funcionarioAlmoxarifado) {
			this.funcionarioAlmoxarifado = funcionarioAlmoxarifado;
		}

		public Funcionario getFuncionarioFabrica() {
			return funcionarioFabrica;
		}

		public void setFuncionarioFabrica(Funcionario funcionarioFabrica) {
			this.funcionarioFabrica = funcionarioFabrica;
		}

		public Ferramenta getFerramenta() {
			return ferramenta;
		}

		public void setFerramenta(Ferramenta ferramenta) {
			this.ferramenta = ferramenta;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id_emprestimo_ferramenta == null) ? 0 : id_emprestimo_ferramenta.hashCode());
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
			EmprestimoFerramenta other = (EmprestimoFerramenta) obj;
			if (id_emprestimo_ferramenta == null) {
				if (other.id_emprestimo_ferramenta != null)
					return false;
			} else if (!id_emprestimo_ferramenta.equals(other.id_emprestimo_ferramenta))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "EmprestimoFerramenta [id_emprestimo_ferramenta=" + id_emprestimo_ferramenta + ", dt_saida_emp="
					+ dt_saida_emp + ", dt_entrega=" + dt_entrega + ", devolucao=" + devolucao
					+ ", funcionarioAlmoxarifado=" + funcionarioAlmoxarifado + ", funcionarioFabrica="
					+ funcionarioFabrica + ", ferramenta=" + ferramenta + "]";
		}

		
		
	    
	    
}

package br.com.sismetal.doumain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="projeto")
public class Projeto implements Serializable {


    @Id
    @Column(unique = true)
    private String id_projeto;
    @Column
    private String local_projeto;
    @Column
    private String titulo_projeto;
    @Column
    private String subtitulo_projeto;
    @Column
    private String projetado;
    @Column 
    private String desenhado;
    @Column
    private String revisado;
    @Column
    private String aprovado;
	public String getId_projeto() {
		return id_projeto;
	}
	public void setId_projeto(String id_projeto) {
		this.id_projeto = id_projeto;
	}
	public String getLocal_projeto() {
		return local_projeto;
	}
	public void setLocal_projeto(String local_projeto) {
		this.local_projeto = local_projeto;
	}
	public String getTitulo_projeto() {
		return titulo_projeto;
	}
	public void setTitulo_projeto(String titulo_projeto) {
		this.titulo_projeto = titulo_projeto;
	}
	public String getSubtitulo_projeto() {
		return subtitulo_projeto;
	}
	public void setSubtitulo_projeto(String subtitulo_projeto) {
		this.subtitulo_projeto = subtitulo_projeto;
	}
	public String getProjetado() {
		return projetado;
	}
	public void setProjetado(String projetado) {
		this.projetado = projetado;
	}
	public String getDesenhado() {
		return desenhado;
	}
	public void setDesenhado(String desenhado) {
		this.desenhado = desenhado;
	}
	public String getRevisado() {
		return revisado;
	}
	public void setRevisado(String revisado) {
		this.revisado = revisado;
	}
	public String getAprovado() {
		return aprovado;
	}
	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}
	public Projeto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projeto(String id_projeto, String local_projeto, String titulo_projeto, String subtitulo_projeto,
			String projetado, String desenhado, String revisado, String aprovado) {
		super();
		this.id_projeto = id_projeto;
		this.local_projeto = local_projeto;
		this.titulo_projeto = titulo_projeto;
		this.subtitulo_projeto = subtitulo_projeto;
		this.projetado = projetado;
		this.desenhado = desenhado;
		this.revisado = revisado;
		this.aprovado = aprovado;
	}
	@Override
	public String toString() {
		return "Projeto [id_projeto=" + id_projeto + ", local_projeto=" + local_projeto + ", titulo_projeto="
				+ titulo_projeto + ", subtitulo_projeto=" + subtitulo_projeto + ", projetado=" + projetado
				+ ", desenhado=" + desenhado + ", revisado=" + revisado + ", aprovado=" + aprovado + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_projeto == null) ? 0 : id_projeto.hashCode());
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
		Projeto other = (Projeto) obj;
		if (id_projeto == null) {
			if (other.id_projeto != null)
				return false;
		} else if (!id_projeto.equals(other.id_projeto))
			return false;
		return true;
	}


    
}

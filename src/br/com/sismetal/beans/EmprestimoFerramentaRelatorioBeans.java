package br.com.sismetal.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sismetal.doumain.EmprestimoFerramenta;

@ManagedBean
@ViewScoped
public class EmprestimoFerramentaRelatorioBeans {

	private List<EmprestimoFerramenta>emprestimoFerramentasRel;
	
	public List<EmprestimoFerramenta> getEmprestimoFerramentasRel() {
		return emprestimoFerramentasRel;
	}
	public void setEmprestimoFerramentasRel(List<EmprestimoFerramenta> emprestimoFerramentasRel) {
		this.emprestimoFerramentasRel = emprestimoFerramentasRel;
	}
}

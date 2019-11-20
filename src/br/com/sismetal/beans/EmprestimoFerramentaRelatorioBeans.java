package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sismetal.dao.EmprestimoFerramentaDAO;
import br.com.sismetal.doumain.EmprestimoFerramenta;

@ManagedBean
@ViewScoped
public class EmprestimoFerramentaRelatorioBeans {

	private EmprestimoFerramenta emprestimoFerramenta;
	private List<EmprestimoFerramenta>emprestimoFerramentasRel;
	
	public EmprestimoFerramenta getEmprestimoFerramenta() {
		return emprestimoFerramenta;
	}
	public void setEmprestimoFerramenta(EmprestimoFerramenta emprestimoFerramenta) {
		this.emprestimoFerramenta = emprestimoFerramenta;
	}
	public List<EmprestimoFerramenta> getEmprestimoFerramentasRel() {
		return emprestimoFerramentasRel;
	}
	public void setEmprestimoFerramentasRel(List<EmprestimoFerramenta> emprestimoFerramentasRel) {
		this.emprestimoFerramentasRel = emprestimoFerramentasRel;
	}
	
	public void novoEF() {
		emprestimoFerramenta = new EmprestimoFerramenta();
	}
	public void novoEmp() {
		emprestimoFerramentasRel = new ArrayList<>();
	}
	@PostConstruct
	public void buscarEmpNaoDevolvidos() {
		novoEmp();
		EmprestimoFerramentaDAO efnd = new EmprestimoFerramentaDAO();
		emprestimoFerramentasRel =  efnd.listarDevFalse(emprestimoFerramenta);
		novoEF();
	}
}

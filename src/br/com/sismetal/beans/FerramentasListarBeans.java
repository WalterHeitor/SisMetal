package br.com.sismetal.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.sismetal.dao.FerramentaDAO;
import br.com.sismetal.doumain.Ferramenta;
import br.com.sismetal.util.JSFUtil;

@ManagedBean
@ViewScoped
public class FerramentasListarBeans {

	private Ferramenta ferramenta;
	private List<Ferramenta> ferramentasStatus;
	
	private List<Ferramenta> listaferramentasemp;
	
	public Ferramenta getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}
	public List<Ferramenta> getFerramentasStatus() {
		return ferramentasStatus;
	}
	public void setFerramentasStatus(List<Ferramenta> ferramentasStatus) {
		this.ferramentasStatus = ferramentasStatus;
	}
	
	
	public List<Ferramenta> getListaferramentasemp() {
		return listaferramentasemp;
	}
	public void setListaferramentasemp(List<Ferramenta> listaferramentasemp) {
		this.listaferramentasemp = listaferramentasemp;
	}
	@PostConstruct
	public void listarStatusNaoEmprestado() {
		try {
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramentasStatus = ferramentaDAO.listarStatus("não-emprestado");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void carregarListaFerramentas() {
		try {
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			listaferramentasemp = ferramentaDAO.listarStatus("não-emprestado");
			System.out.println(listaferramentasemp);
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao carregar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}		
	}
	/**
	 * função que puxa da tabela o ferramenta 
	 * @param event
	 */
	public void puxarFerrTable(ActionEvent event) {		
		ferramenta = (Ferramenta) event.getComponent().getAttributes().get("ferrEmprFerrSelecionado");				
	}
}


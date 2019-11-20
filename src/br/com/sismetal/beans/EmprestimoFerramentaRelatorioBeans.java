package br.com.sismetal.beans;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.sismetal.dao.EmprestimoFerramentaDAO;
import br.com.sismetal.doumain.EmprestimoFerramenta;
import br.com.sismetal.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

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
	public void imprimir() {
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent
					("formListagemEmpres:dttabelaEmpres");
			Map<String, Object> filtros = tabela.getFilters();
			String funNome = (String) filtros.get("nome_func");
			
			String caminho = Faces.getRealPath("Relatorios/emprestimosFiltrados.jasper");
			
			Map<String, Object> parametros = new HashMap<>();          
			if(funNome == null) {
				parametros.put("nomeColaborador", "%%");
			}else {
				parametros.put("nomeColaborador", "%" +funNome+ "%");
			}
			
			Connection conexao = HibernateUtil.getConexao();
			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
		
			JasperPrintManager.printReport(relatorio, true);
			
		} catch (JRException e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar carregar o relatorio");
			e.printStackTrace();
		}
	}
	
	
}

package br.com.sismetal.beans;


import java.io.Serializable;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@ManagedBean
@ViewScoped
public class EmprestimoFerramentaRelatorioBeans implements Serializable{

	
	private EmprestimoFerramenta emprestimoFerramenta;
	private List<EmprestimoFerramenta>emprestimoFerramentasRel;
	private List<EmprestimoFerramenta>emprestimoFerramentasRelDAO;
	
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
	public List<EmprestimoFerramenta> getEmprestimoFerramentasRelDAO() {
		return emprestimoFerramentasRelDAO;
	}
	public void setEmprestimoFerramentasRelDAO(List<EmprestimoFerramenta> emprestimoFerramentasRelDAO) {
		this.emprestimoFerramentasRelDAO = emprestimoFerramentasRelDAO;
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
		System.out.println(emprestimoFerramentasRel);
		novoEF();
	}
	public void imprimir() {
		try {
			System.out.println("AAAA");
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent
					("formListagemEmpres:dttabelaEmpres");
			System.out.println("AAAA"+tabela);
			Map<String, Object> filtros = tabela.getFilters();
			String funNome = (String) filtros.get("funcionarioFabrica.nome");
			System.out.println("BBBBBBB"+filtros);
			System.out.println(funNome);
			String caminho = Faces.getRealPath("/Relatorios/emprestimosFiltrado.jasper");
			System.out.println("CCCCCC"+caminho);
			Map<String, Object> parametros = new HashMap<>();          
			if(funNome == null) {
				parametros.put("nomeColaborador", "%%");
				System.out.println("DDD"+parametros);
			}else {  
				parametros.put("nomeColaborador", "%" +funNome+ "%");
				System.out.println("DDD2"+parametros);
			}
			System.out.println("EEEEE");
			Connection conexao = HibernateUtil.getConexao();
			System.out.println("conexao"+conexao);
			
				JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			
		System.out.println("FFFFFFF");
			JasperPrintManager.printReport(relatorio, true);
			System.out.println("GGGGG");
		} catch (JRException e) {
			System.out.println("HHH");
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar carregar o relatorio");
			e.printStackTrace();
		}
	}
		
		public void imprimir2() {
			try {
				
				String caminho = Faces.getRealPath("/Relatorios/emprestimos.jasper");
				Map<String, Object> parametros = new HashMap<>();
				Connection conexao = HibernateUtil.getConexao();
				JasperPrint relatorio = JasperFillManager.fillReport(caminho,parametros,conexao);
			System.out.println("FFFFFFF");
				JasperPrintManager.printReport(relatorio, true);
				System.out.println("GGGGG");
			} catch (JRException e) {
				System.out.println("HHH");
				Messages.addFlashGlobalError("Ocorreu u erro ao tentar carregar o relatorio");
				e.printStackTrace();
			}
	}
		public void imprimir3() {
			//relatorio funcionarios  
		     
		        System.out.println("gerando relatorio Funcionarios");
		        EmprestimoFerramentaDAO emprestimoFerramentaDAO = new EmprestimoFerramentaDAO();
		        emprestimoFerramentasRelDAO = emprestimoFerramentaDAO.listar();
		        //List listaFuncionarios = FuncionarioDAO.getInstance().findAll();
		        
		        JasperReport jr;
				try {
					jr = JasperCompileManager.compileReport("/Relatorios/emprestimos.jasper");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jr, null, new JRBeanCollectionDataSource(emprestimoFerramentasRelDAO));
			        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/walter heitor/Desktop/teste/reportFunc.pdf");
			        System.out.println("Relatorio gerado");
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		    
		}
	
	

		
}

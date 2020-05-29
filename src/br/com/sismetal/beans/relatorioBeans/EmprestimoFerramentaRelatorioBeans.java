package br.com.sismetal.beans.relatorioBeans;


import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.sismetal.dao.EmprestimoFerramentaDAO;
import br.com.sismetal.dao.FuncionarioDAO;
import br.com.sismetal.doumain.EmprestimoFerramenta;
import br.com.sismetal.doumain.Funcionario;
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

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private EmprestimoFerramenta emprestimoFerramenta;
	private List<EmprestimoFerramenta>emprestimoFerramentasRel;
	private List<EmprestimoFerramenta>emprestimoFerramentasRelDAO;
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
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
	/**
	 * função que puxa da tabela o funcionario
	 * 
	 * @param event
	 */
	public void puxarFuncionarioFabriTable(ActionEvent event) {

		funcionario = (Funcionario) event.getComponent().getAttributes().get("funcEmprFerrSelecionadoFabri");
		novoEmp();
		EmprestimoFerramentaDAO efnd = new EmprestimoFerramentaDAO();
		emprestimoFerramentasRel = efnd.listarNomeFunc(funcionario);
	}
	@PostConstruct
	public void buscarEmpNaoDevolvidos() {
		novoEmp();
		EmprestimoFerramentaDAO efnd = new EmprestimoFerramentaDAO();
		emprestimoFerramentasRel =  efnd.listarDevFalse(emprestimoFerramenta);
		novoEF();
	}
	public void listarPorNome() {
		novoEmp();
		EmprestimoFerramentaDAO efnd = new EmprestimoFerramentaDAO();
		emprestimoFerramentasRel = efnd.listarNome(emprestimoFerramenta);
	}
	public void imprimir() {
		try {
			//DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagemEmpres:dttabelaEmpres");
			//Map<String, Object> filtros = tabela.getFilters();
			//String funNome = (String) filtros.get("funcionarioFabrica.nome");
			String funNome;
			if(funcionario == null) {
				funNome = "";
			}else {
			 funNome = funcionario.getNome();
			}
			String caminho = Faces.getRealPath("/Relatorios/emprestimosFiltrado.jasper");
			Map<String, Object> parametros = new HashMap<>();          
			if(funNome == null) {
				parametros.put("nomeColaborador", "%%");
				System.out.println("1"+funNome);
			}else {  
				funNome = "%"+funNome+"%";
				parametros.put("nomeColaborador", funNome);
				System.out.println("2"+funNome);
			}
			Connection conexao = HibernateUtil.getConexao();
				JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperPrintManager.printReport(relatorio, true);
		} catch (JRException e) {
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

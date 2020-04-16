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

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.sismetal.dao.FuncionarioDAO;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@ManagedBean
@ViewScoped
public class funcionarioRelatorioBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private Funcionario funcionario;
	 private List<Funcionario> funcionarios;
	 
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	@PostConstruct
	public void buscarFuncAtivo() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarios = new ArrayList<>();
		funcionarios = funcionarioDAO.buscarFuncAtivo();
	}
	 
	
	public void imprimir() {
		try {
			
			String caminho = Faces.getRealPath("/Relatorios/funcionario.jasper");
			Map<String, Object> parametros = new HashMap<>();          
			
			Connection conexao = HibernateUtil.getConexao();
				JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperPrintManager.printReport(relatorio, true);
		} catch (JRException e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar carregar o relatorio");
			e.printStackTrace();
		}
	}

}

package br.com.sismetal.beans.relatorioBeans;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.sismetal.doumain.Ferramenta;
import br.com.sismetal.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@ManagedBean
@ViewScoped
public class RelatorioFerramentasAtivasBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Ferramenta ferramenta;
	private List<Ferramenta> ferramentas;
	private boolean rend = false;
	
	public Ferramenta getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}
	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}
	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}
	public boolean isRend() {
		return rend;
	}
	public void setRend(boolean rend) {
		this.rend = rend;
	}
	
	public void listarFerrEstragada() {
		rend = true;
	}
	
	public void imprimirRelFerr() {
		try {
			
			String caminho = Faces.getRealPath("/Relatorios/FerramentasAtivas.jasper");
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

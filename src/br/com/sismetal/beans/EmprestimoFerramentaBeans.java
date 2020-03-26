package br.com.sismetal.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.DevolucaoFerramentaEstragadaDAO;
import br.com.sismetal.dao.EmprestimoFerramentaDAO;
import br.com.sismetal.dao.FerramentaDAO;
import br.com.sismetal.doumain.DevolucaoFerramentaEstragada;
import br.com.sismetal.doumain.EmprestimoFerramenta;
import br.com.sismetal.doumain.Ferramenta;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EmprestimoFerramentaBeans implements Serializable {

	private Date dt_entrega;
	private String local_ferr;
	private String descricaoEstragada;
	private EmprestimoFerramenta emprestimoFerramenta;
	private DevolucaoFerramentaEstragada devolucaoFerramentaEstragada;
	private List<DevolucaoFerramentaEstragada> devolucoesFerramentasEstragas;
	private List<EmprestimoFerramenta> emprestimoFerramentas;
	private List<EmprestimoFerramenta> emprestimoFerramentaEmprestado;
	private List<EmprestimoFerramenta> emprestimoFerramentaDevolvidas;
	private List<EmprestimoFerramenta> emprestimoFerramentasLista;
	private Funcionario funcionarioAlmoxarifado;
	private Funcionario funcionarioFabrica;
	private List<Funcionario> funcionarioAlmoxarifados;
	private List<Funcionario> funcionarioFabricas;
	private Ferramenta ferramenta;
	private List<Ferramenta> ferramentas;
	private List<Ferramenta> ferramentasStatus;

	public Date getDt_entrega() {
		return dt_entrega;
	}
	public void setDt_entrega(Date dt_entrega) {
		this.dt_entrega = dt_entrega;
	}
	public String getLocal_ferr() {
		return local_ferr;
	}
	public void setLocal_ferr(String local_ferr) {
		this.local_ferr = local_ferr;
	}
	
	public String getDescricaoEstragada() {
		return descricaoEstragada;
	}
	public void setDescricaoEstragada(String descricaoEstragada) {
		this.descricaoEstragada = descricaoEstragada;
	}
	public EmprestimoFerramenta getEmprestimoFerramenta() {
		return emprestimoFerramenta;
	}

	public void setEmprestimoFerramenta(EmprestimoFerramenta emprestimoFerramenta) {
		this.emprestimoFerramenta = emprestimoFerramenta;
	}

	public DevolucaoFerramentaEstragada getDevolucaoFerramentaEstragada() {
		return devolucaoFerramentaEstragada;
	}
	public void setDevolucaoFerramentaEstragada(DevolucaoFerramentaEstragada devolucaoFerramentaEstragada) {
		this.devolucaoFerramentaEstragada = devolucaoFerramentaEstragada;
	}
	
	public List<DevolucaoFerramentaEstragada> getDevolucoesFerramentasEstragas() {
		return devolucoesFerramentasEstragas;
	}
	public void setDevolucoesFerramentasEstragas(List<DevolucaoFerramentaEstragada> devolucoesFerramentasEstragas) {
		this.devolucoesFerramentasEstragas = devolucoesFerramentasEstragas;
	}
	public List<EmprestimoFerramenta> getEmprestimoFerramentas() {
		return emprestimoFerramentas;
	}

	public List<EmprestimoFerramenta> getEmprestimoFerramentaEmprestado() {
		return emprestimoFerramentaEmprestado;
	}

	public void setEmprestimoFerramentaEmprestado(List<EmprestimoFerramenta> emprestimoFerramentaEmprestado) {
		this.emprestimoFerramentaEmprestado = emprestimoFerramentaEmprestado;
	}

	public List<EmprestimoFerramenta> getEmprestimoFerramentaDevolvidas() {
		return emprestimoFerramentaDevolvidas;
	}

	public void setEmprestimoFerramentaDevolvidas(List<EmprestimoFerramenta> emprestimoFerramentaDevolvidas) {
		this.emprestimoFerramentaDevolvidas = emprestimoFerramentaDevolvidas;
	}

	public void setEmprestimoFerramentas(List<EmprestimoFerramenta> emprestimoFerramentas) {
		this.emprestimoFerramentas = emprestimoFerramentas;
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

	public List<Funcionario> getFuncionarioAlmoxarifados() {
		return funcionarioAlmoxarifados;
	}

	public void setFuncionarioAlmoxarifados(List<Funcionario> funcionarioAlmoxarifados) {
		this.funcionarioAlmoxarifados = funcionarioAlmoxarifados;
	}

	public List<Funcionario> getFuncionarioFabricas() {
		return funcionarioFabricas;
	}

	public void setFuncionarioFabricas(List<Funcionario> funcionarioFabricas) {
		this.funcionarioFabricas = funcionarioFabricas;
	}

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

	public List<Ferramenta> getFerramentasStatus() {
		return ferramentasStatus;
	}

	public void setFerramentasStatus(List<Ferramenta> ferramentasStatus) {
		this.ferramentasStatus = ferramentasStatus;
	}

	public List<EmprestimoFerramenta> getEmprestimoFerramentasLista() {
		return emprestimoFerramentasLista;
	}

	public void setEmprestimoFerramentasLista(List<EmprestimoFerramenta> emprestimoFerramentasLista) {
		this.emprestimoFerramentasLista = emprestimoFerramentasLista;
	}

	public void novo() {
		emprestimoFerramenta = new EmprestimoFerramenta();
	}

	public void novoFuncionario() {
		funcionarioAlmoxarifado = new Funcionario();

	}

	public void novoEmprestimo() {
		emprestimoFerramenta = new EmprestimoFerramenta();
		ferramentas = new ArrayList<>();
		emprestimoFerramentas = new ArrayList<>();
		listarStatusNaoEmprestado();

	}
	public void novoTela() {
		try {
			local_ferr = "";
			funcionarioAlmoxarifado = new Funcionario();
			funcionarioFabrica = new Funcionario();
			ferramenta = new Ferramenta();
			emprestimoFerramenta = new EmprestimoFerramenta();
			devolucaoFerramentaEstragada = new DevolucaoFerramentaEstragada();
			ferramentas = new ArrayList<>();
			emprestimoFerramentas = new ArrayList<>();
			emprestimoFerramentaEmprestado = new ArrayList<>();
			emprestimoFerramentaDevolvidas = new ArrayList<>();
			devolucoesFerramentasEstragas = new ArrayList<>();
			listarStatusNaoEmprestado();
			Messages.addGlobalInfo("Nova tela com sucesso!!");
		} catch (Exception e) {
			Messages.addGlobalError("Erro Novo Emprestimo!!");
			// TODO: handle exception
		}
	}

	@PostConstruct
	public void listaEmprestimos() {
		try {
			EmprestimoFerramentaDAO emprestimoFerramentaDAO = new EmprestimoFerramentaDAO();
			emprestimoFerramentasLista = emprestimoFerramentaDAO.listar();
			novoEmprestimo();
			

		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void listarStatusNaoEmprestado() {
		try {
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramentasStatus = ferramentaDAO.listarStatus("não-emprestado");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao salvar: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void listarNomeStatus() {
		try {
			emprestimoFerramentaEmprestado = new ArrayList<>();
			emprestimoFerramentaDevolvidas = new ArrayList<>();
			devolucoesFerramentasEstragas = new ArrayList<>();
			EmprestimoFerramentaDAO emprestimoFerramentaDAO = new EmprestimoFerramentaDAO();
			emprestimoFerramentaEmprestado = emprestimoFerramentaDAO.listarNomeStatus(funcionarioFabrica.getNome(),
					"emprestado");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	/**
	 * função que puxa da tabela o funcionario
	 * 
	 * @param event
	 */
	public void puxarFuncionarioAlmoxTable(ActionEvent event) {

		funcionarioAlmoxarifado = (Funcionario) event.getComponent().getAttributes()
				.get("funcEmprFerrSelecionadoAlmox");
		// novo();

	}

	/**
	 * função que puxa da tabela o funcionario
	 * 
	 * @param event
	 */
	public void puxarFuncionarioFabriTable(ActionEvent event) {

		funcionarioFabrica = (Funcionario) event.getComponent().getAttributes().get("funcEmprFerrSelecionadoFabri");
		emprestimoFerramenta = new EmprestimoFerramenta();
		// novoEmprestimo();
		/*
		 * emprestimoFerramentas = new ArrayList<>(); ferramentas = new ArrayList<>();
		 */

	}

	/**
	 * função que puxa da tabela o ferramenta
	 * 
	 * @param event
	 */
	public void puxarFerrTable(ActionEvent event) {

		ferramenta = (Ferramenta) event.getComponent().getAttributes().get("ferrEmprFerrSelecionado");
		Addsalvar();

	}

	public void Addsalvar() {
		try {
			
				ferramenta.setStatus("emprestado");
				ferramenta.setLocal_ferr(local_ferr);
				ferramentas.add(ferramenta);
				ferramentasStatus.remove(ferramenta);
				emprestimoFerramenta.setDt_saida_emp(new Date());
				emprestimoFerramenta.setFuncionarioAlmoxarifado(funcionarioAlmoxarifado);
				emprestimoFerramenta.setFuncionarioFabrica(funcionarioFabrica);
				emprestimoFerramenta.setFerramenta(ferramenta);
				emprestimoFerramentas.add(emprestimoFerramenta);
				emprestimoFerramenta = new EmprestimoFerramenta();
				ferramenta = new Ferramenta();
				JSFUtil.addMensagemSucesso("Emprestimo Ferramneta adicionada a lista com Sucesso!!!");
			

		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao Emprestar Ferramenta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void removeEmprestimo(ActionEvent evento) {

		emprestimoFerramenta = (EmprestimoFerramenta) evento.getComponent().getAttributes()
				.get("ferrEmprFerrSelecionado");
		FerramentaDAO ferramentaDAO = new FerramentaDAO();
		ferramenta = ferramentaDAO.buscarPorString(emprestimoFerramenta.getFerramenta().getCodigoBarra());
		ferramenta.setStatus("não-emprestado");
		emprestimoFerramenta.setFerramenta(ferramenta);
		ferramentas.remove(ferramenta);
		ferramentasStatus.add(ferramenta);
		emprestimoFerramentas.remove(emprestimoFerramenta);
		emprestimoFerramenta = new EmprestimoFerramenta();
		ferramenta = new Ferramenta();
	}

	public void entregaEmprestimo(ActionEvent evento) {

		try {
			ferramenta = new Ferramenta();
			emprestimoFerramenta = (EmprestimoFerramenta) evento.getComponent().getAttributes()
					.get("EmprFerrSelecionado");
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramenta = ferramentaDAO.buscarPorString(emprestimoFerramenta.getFerramenta().getCodigoBarra());
			ferramenta.setStatus("não-emprestado");
			ferramentas.add(ferramenta);
			emprestimoFerramenta.setFerramenta(ferramenta);
			emprestimoFerramenta.setDt_entrega(new Date());		
			emprestimoFerramentaDevolvidas.add(emprestimoFerramenta);
			emprestimoFerramentaEmprestado.remove(emprestimoFerramenta);			
			emprestimoFerramenta = new EmprestimoFerramenta();
			ferramenta = new Ferramenta();

			JSFUtil.addMensagemSucesso("Devolução do emprestimo Ferramenta adicionada a lista com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao devolver Ferramenta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void removeEntregaEmprestimo(ActionEvent evento) {

		try {
			emprestimoFerramenta = (EmprestimoFerramenta) evento.getComponent().getAttributes()
					.get("removeEmprFerrSelecionado");
			FerramentaDAO ferramentaDAO = new FerramentaDAO();
			ferramenta = ferramentaDAO.buscarPorString(emprestimoFerramenta.getFerramenta().getCodigoBarra());
			ferramenta.setStatus("emprestado");
			ferramentas.add(ferramenta);
			emprestimoFerramenta.setFerramenta(ferramenta);		
			emprestimoFerramentaDevolvidas.remove(emprestimoFerramenta);
			emprestimoFerramentaEmprestado.add(emprestimoFerramenta);			
			emprestimoFerramenta = new EmprestimoFerramenta();
			ferramenta = new Ferramenta();

			JSFUtil.addMensagemSucesso("Devolução do emprestimo Ferramenta removida a lista com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao devolver Ferramenta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}

	}
	public void novoFerrEstragada(ActionEvent evento) {
		devolucaoFerramentaEstragada = new DevolucaoFerramentaEstragada();
		emprestimoFerramenta = (EmprestimoFerramenta) evento.getComponent().getAttributes()
				.get("estragFerrSelecionado");
	}

public void entregaferramentaEstragada() {

	try {
		
		
		
		FerramentaDAO ferramentaDAO = new FerramentaDAO();
		ferramenta = ferramentaDAO.buscarPorString(emprestimoFerramenta.getFerramenta().getCodigoBarra());
		ferramenta.setStatus("estragada");
		ferramentas.add(ferramenta);
		emprestimoFerramenta.setFerramenta(ferramenta);
		emprestimoFerramenta.setDt_entrega(dt_entrega);		
		emprestimoFerramentaDevolvidas.add(emprestimoFerramenta);
		emprestimoFerramentaEmprestado.remove(emprestimoFerramenta);
		devolucaoFerramentaEstragada.setEmprestimoFerramenta(emprestimoFerramenta);
		devolucaoFerramentaEstragada.setDescricao(descricaoEstragada);
		devolucoesFerramentasEstragas.add(devolucaoFerramentaEstragada);
		emprestimoFerramenta = new EmprestimoFerramenta();
		devolucaoFerramentaEstragada = new DevolucaoFerramentaEstragada();
		ferramenta = new Ferramenta();

		JSFUtil.addMensagemSucesso("Devolução do emprestimo Ferramenta estrada adicionada a lista com Sucesso!!!");
	} catch (Exception e) {
		JSFUtil.addMensagemErro("erro ao devolver Ferramenta: e.getMessage() " + e.getMessage());
		e.printStackTrace();
	}
}
	public void salvar() {

		try {
			for (EmprestimoFerramenta emprestimoFerramenta : emprestimoFerramentas) {
				EmprestimoFerramentaDAO emprestimoFerramentaDAO = new EmprestimoFerramentaDAO();
				emprestimoFerramenta.getFerramenta().setStatus("emprestado");
				emprestimoFerramenta.setDevolucao(false);
				emprestimoFerramentaDAO.salvar(emprestimoFerramenta);

			}
			for (Ferramenta ferramenta : ferramentas) {
				FerramentaDAO ferramentaDAO = new FerramentaDAO();
				ferramentaDAO.salvarMerge(ferramenta);
			}
			novoTela();
			JSFUtil.addMensagemSucesso("Emprestimo Ferramenta salvo com Sucesso!!!");

		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao Emprestar Ferramneta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void merge() {
		try {
			for(EmprestimoFerramenta emprestimoFerramenta: emprestimoFerramentaDevolvidas) {
				emprestimoFerramenta.setDevolucao(true);
				emprestimoFerramenta.setDt_entrega(new Date());
				EmprestimoFerramentaDAO emprestimoFerramentaDAO = new EmprestimoFerramentaDAO();
				emprestimoFerramentaDAO.salvarMerge(emprestimoFerramenta);
			}
			for (Ferramenta ferramenta : ferramentas) {
				FerramentaDAO ferramentaDAO = new FerramentaDAO();
				ferramentaDAO.salvarMerge(ferramenta);
			}
			for(DevolucaoFerramentaEstragada devolucaoFerramentaEstragada: devolucoesFerramentasEstragas) {
				DevolucaoFerramentaEstragadaDAO devolucaoFerramentaEstragadaDAO = new DevolucaoFerramentaEstragadaDAO();
				devolucaoFerramentaEstragadaDAO.salvarMerge(devolucaoFerramentaEstragada);
			}
			novoTela();
			JSFUtil.addMensagemSucesso("Emprestimo Ferramenta devolvido com Sucesso!!!");
		} catch (Exception e) {
			JSFUtil.addMensagemErro("erro ao devolver Ferramneta: e.getMessage() " + e.getMessage());
			e.printStackTrace();
		}
	}
}

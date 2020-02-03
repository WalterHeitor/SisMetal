package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.OrdemServicoInsumoDAO;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.doumain.Insumo;
import br.com.sismetal.doumain.OrdemServico;
import br.com.sismetal.doumain.OrdemServicoInsumo;

//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OrdemServicoInsumoBeans {

	private OrdemServicoInsumo ordemServicoInsumo;
	private List<OrdemServicoInsumo> ordemServicoInsumos;
	private Insumo insumo;
	private List<Insumo> insumos;
	private OrdemServico ordemServico;
	private List<OrdemServico> ordemServicos;
	private Funcionario funcionarioGerente;
	private Funcionario funcionarioFabrica;

	public OrdemServicoInsumo getOrdemServicoInsumo() {
		return ordemServicoInsumo;
	}

	public void setOrdemServicoInsumo(OrdemServicoInsumo ordemServicoInsumo) {
		this.ordemServicoInsumo = ordemServicoInsumo;
	}

	public List<OrdemServicoInsumo> getOrdemServicoInsumos() {
		return ordemServicoInsumos;
	}

	public void setOrdemServicoInsumos(List<OrdemServicoInsumo> ordemServicoInsumos) {
		this.ordemServicoInsumos = ordemServicoInsumos;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public List<Insumo> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}
	
	public Funcionario getFuncionarioGerente() {
		return funcionarioGerente;
	}

	public void setFuncionarioGerente(Funcionario funcionarioGerente) {
		this.funcionarioGerente = funcionarioGerente;
	}

	public Funcionario getFuncionarioFabrica() {
		return funcionarioFabrica;
	}

	public void setFuncionarioFabrica(Funcionario funcionarioFabrica) {
		this.funcionarioFabrica = funcionarioFabrica;
	}
//--------------------------------------------novo()
	public void novoInsumo() {
		insumo = new Insumo();
	}
	public void novoOrdemSInsumo() {
		ordemServicoInsumo = new OrdemServicoInsumo();
	}
	public void novoListInsumo() {
		ordemServicoInsumos = new ArrayList<>();
	}
	@PostConstruct
	public void novo() {
		novoOrdemSInsumo();
		novoListInsumo();
	}
//-------------------------------------------- fim novo()
	public void puxarFuncionarioGerente(ActionEvent event) {

		funcionarioGerente = (Funcionario) event.getComponent().getAttributes()
				.get("funcSelecionado");
	}
	public void puxarFuncionarioFabrica(ActionEvent event) {

		funcionarioFabrica = (Funcionario) event.getComponent().getAttributes()
				.get("funcSelecionado");
	}
	public void puxarOS(ActionEvent event) {

		ordemServico = (OrdemServico) event.getComponent().getAttributes()
				.get("OSSelecionado");
	}
	public void salvar() {

		try {

			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {

			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {

			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
	public void puxarInsumo(ActionEvent event) {
		try {
			novoInsumo();
			insumo = (Insumo) event.getComponent().getAttributes().get("InsumoSelecionado");
			Messages.addFlashGlobalInfo("insumo buscado com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar puxar o Insumo!!!");
			e.printStackTrace();
		}
	}

	//@PostConstruct
	public void listar() {
		try {
			OrdemServicoInsumoDAO ordemServicoInsumoDAO = new OrdemServicoInsumoDAO();
			ordemServicoInsumos = ordemServicoInsumoDAO.listar();

		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
	public void addInsOs() {
		ordemServicoInsumo.setInsumo(insumo);
		ordemServicoInsumos.add(ordemServicoInsumo);
		novoInsumo();
	}
}

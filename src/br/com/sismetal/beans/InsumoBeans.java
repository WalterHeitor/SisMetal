package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.InsumoDAO;
import br.com.sismetal.doumain.Insumo;

@ViewScoped
@ManagedBean
public class InsumoBeans {

	private Insumo insumo;
	private List<Insumo> insumos;

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

	public void novo() {
		insumo = new Insumo();
	}

	public void novoListInsumo() {
		insumos = new ArrayList<>();
	}

	public void salvar() {
		try {
			InsumoDAO insumoDAO = new InsumoDAO();
			insumoDAO.salvar(insumo);
			insumos = insumoDAO.listar();
			novo();
			Messages.addFlashGlobalInfo("Insumo Salvo com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o Insumo!!!");
			e.printStackTrace();
		}
	}

	public void editar() {

		try {
			novo();
			InsumoDAO insumoDAO = new InsumoDAO();
			insumoDAO.salvar(insumo);
			insumos = insumoDAO.listar();
			novo();
			Messages.addFlashGlobalInfo("Insumo Editado com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar editar o Insumo!!!");
			e.printStackTrace();
		}
	}

	public void puxarEditar(ActionEvent event) {
		try {
			novo();
			insumo = (Insumo) event.getComponent().getAttributes().get("Insumo_SelecionadoEd");
			
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar puxar o Insumo!!!");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent event) {
		try {
			novo();
			insumo = (Insumo) event.getComponent().getAttributes().get("Insumo_SelecionadoEx");
			InsumoDAO insumoDAO = new InsumoDAO();
			insumoDAO.excluir(insumo);
			Messages.addFlashGlobalInfo("Insumo Excluido com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar deletar o Insumo!!!");
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			novoListInsumo();
			InsumoDAO insumoDAO = new InsumoDAO();
			insumos = insumoDAO.listar();
			novo();
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar listar Insumo!!!");
			e.printStackTrace();
		}
	}
}

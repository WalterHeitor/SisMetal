package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.InsumoDAO;
import br.com.sismetal.dao.OrdemServicoInsumoDAO;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.doumain.Insumo;
import br.com.sismetal.doumain.OrdemServico;
import br.com.sismetal.doumain.OrdemServicoInsumo;

//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OrdemServicoInsumoBeans {

	private boolean rend = false;
	private boolean rend2 = false;
	private OrdemServicoInsumo ordemServicoInsumo;
	private List<OrdemServicoInsumo> ordemServicoInsumos;
	private Insumo insumo;
	private List<Insumo> insumos;
	private List<Insumo> insumosSave;
	private OrdemServico ordemServico;
	private List<OrdemServico> ordemServicos;
	private Funcionario funcionarioGerente;
	private Funcionario funcionarioFabrica;
	private Funcionario funcionarioAlmoxarife;
	private String acao = "";
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public boolean isRend() {
		return rend;
	}

	public void setRend(boolean rend) {
		this.rend = rend;
	}

	public boolean isRend2() {
		return rend2;
	}

	public void setRend2(boolean rend2) {
		this.rend2 = rend2;
	}

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

	public List<Insumo> getInsumosSave() {
		return insumosSave;
	}

	public void setInsumosSave(List<Insumo> insumosSave) {
		this.insumosSave = insumosSave;
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
	
public Funcionario getFuncionarioAlmoxarife() {
		return funcionarioAlmoxarife;
	}

	public void setFuncionarioAlmoxarife(Funcionario funcionarioAlmoxarife) {
		this.funcionarioAlmoxarife = funcionarioAlmoxarife;
	}

	//--------------------------------------------novo()
	public void novoRend() {
		
		try {
			rend = true;
			acao = "novo";
			novo();
			Messages.addFlashGlobalInfo("Rendernizado com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar rendenizar!!!");
			e.printStackTrace();
		}
		
	}
	
	public void novoInsumo() {
		insumo = new Insumo();
	}
	public void novoOrdemSInsumo() {
		ordemServicoInsumo = new OrdemServicoInsumo();
	}
	public void novoListInsumo() {
		ordemServicoInsumos = new ArrayList<>();
		
		
	}
	//@PostConstruct
	public void novo() {
		insumos = new ArrayList<>();
		insumosSave = new ArrayList<>();
		InsumoDAO insumoDAO = new InsumoDAO();
		insumos = insumoDAO.listar();
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
	public void puxarFuncionarioAlmoxarifado(ActionEvent event) {

		funcionarioAlmoxarife = (Funcionario) event.getComponent().getAttributes()
				.get("funcSelecionado");
	}
	public void puxarOS(ActionEvent event) {

		ordemServico = (OrdemServico) event.getComponent().getAttributes()
				.get("OSSelecionado");
		
	}
	public void salvar() {

		try {
			OrdemServicoInsumoDAO ordemServicoInsumoDAO = new OrdemServicoInsumoDAO();
			for(OrdemServicoInsumo ordemServicoInsumo: ordemServicoInsumos) {
				ordemServicoInsumoDAO.salvar(ordemServicoInsumo);
			}
			InsumoDAO insumoDAO = new InsumoDAO();
			for(Insumo insSave: insumosSave) {
				insumoDAO.salvarMerge(insSave);
			}
			novoRend();
			rend = false;
			Messages.addFlashGlobalInfo("Ordem de serviço Salvo com Sucesso!!!");
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
	public void checkOS() {
		try {
			
			if(funcionarioFabrica == null) {
				Messages.addFlashGlobalError("Preencha o funcionario !!!");
			}
			
			if(funcionarioGerente == null) {
				Messages.addFlashGlobalError("Preencha o gerente !!!");
			}
			if(ordemServico == null) {
				Messages.addFlashGlobalError("Preencha a Ordem Serviço !!!");
			}
			if(ordemServicoInsumo.getDtEntrInsumo() == null) {
				Messages.addFlashGlobalError("Preencha a data !!!");
			}
			if(funcionarioFabrica != null && funcionarioGerente != null && 
					ordemServico != null && ordemServicoInsumo.getDtEntrInsumo() != null) {
				rend2 = true;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
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
		
		
		try {
			Insumo insumo2 = new Insumo();
			float qtd = 0;
			boolean ins = false;
			ordemServicoInsumo.setOrdemServico(ordemServico);
			ordemServicoInsumo.setFuncionarioGerente(funcionarioGerente);
			ordemServicoInsumo.setFuncionarioFabrica(funcionarioFabrica);
			ordemServicoInsumo.setInsumo(insumo);
System.out.println("1- "+insumo.getQuantidade());
			qtd = insumo.getQuantidade() - ordemServicoInsumo.getQtdInsumo();
			ordemServicoInsumo.setPreco(insumo.getPreco());;

			if(qtd < 0) {
				Messages.addFlashGlobalWarn("A quantidade requisitada e superior a do estoque");
			}else {
				for(OrdemServicoInsumo insumo1: ordemServicoInsumos ) {
					if(insumo.getId_insumo().equals(insumo1.getInsumo().getId_insumo())) {
						ins = true;
						insumo1.setQtdInsumo(insumo1.getQtdInsumo()+ordemServicoInsumo.getQtdInsumo());
						System.out.println("1 - ins for"+ins);
					}
				}
				if(ins == true) {
					
					insumo.setQuantidade(qtd);
					novoInsumo();
					novoOrdemSInsumo();
					System.out.println("2 - ins true"+ins);
				}else {
					insumo.setQuantidade(qtd);				
					ordemServicoInsumos.add(ordemServicoInsumo);
					System.out.println("add.ordemServ");
					insumo2 = insumo;
					insumosSave.add(insumo2);
					novoInsumo();
					novoOrdemSInsumo();
					System.out.println("3 - ins false"+ins);
				}				
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void remover(ActionEvent event) {
		try {
			novoOrdemSInsumo();
			ordemServicoInsumo = (OrdemServicoInsumo) event.getComponent().getAttributes().get("remIns");		
			insumo = (Insumo) event.getComponent().getAttributes().get("InsumoSelecionado");
			for(Insumo insumo1 : insumos) {
				if(insumo1.getId_insumo().equals(ordemServicoInsumo.getInsumo().getId_insumo())) {
					insumo1.setQuantidade(ordemServicoInsumo.getQtdInsumo() + insumo1.getQuantidade());
					ordemServicoInsumos.remove(ordemServicoInsumo);
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
}

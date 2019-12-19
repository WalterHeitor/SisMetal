package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sismetal.dao.ClienteDAO;
import br.com.sismetal.doumain.Cliente;

//@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBeans {

	private Cliente cliente;
	private List<Cliente>clientes;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void novo() {
		cliente = new Cliente();
	}
	
	public void novoLista() {
		clientes = new ArrayList<>();
	}
	
	public void salvar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.salvar(cliente);
			novo();
			clientes = clienteDAO.listar();	
			Messages.addFlashGlobalInfo("Cliente Salvo com Sucesso!!!");			
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
	public void puxarCliente(ActionEvent event) {
		try {
			novo();
			cliente = (Cliente) event.getComponent().getAttributes().get("cliEditarSelecionado");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar selecionar o cliente!!!");
			e.printStackTrace();
		}
	}
	public void excluir(ActionEvent event) {
		try {
			novo();
			cliente = (Cliente) event.getComponent().getAttributes().get("cliExcluirSelecionado");
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);
			clientes = clienteDAO.listar();	
			Messages.addFlashGlobalInfo("Cliente Deletado com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar Deletar o cliente!!!");
			e.printStackTrace();
		}
	}
	public void editar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.salvarMerge(cliente);
			novo();
			clientes = clienteDAO.listar();	
			Messages.addFlashGlobalInfo("Cliente editado com Sucesso!!!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Ocorreu u erro ao tentar salvar o cliente!!!");
			e.printStackTrace();
		}
	}
	@PostConstruct
	public void listar() {
	try {
//		novo();
			clientes = new ArrayList<>();
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
			novo();
	} catch (Exception e) {
		Messages.addFlashGlobalError("Ocorreu u erro ao tentar listar o cliente!!!");
		e.printStackTrace();
	}	
	}
	
}

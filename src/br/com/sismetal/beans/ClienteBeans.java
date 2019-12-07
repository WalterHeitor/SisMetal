package br.com.sismetal.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
	}
	@PostConstruct
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		clientes = clienteDAO.listar();
		novo();
	}
	
}

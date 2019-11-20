package teste;

import java.util.List;
import java.util.Set;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import br.com.sismetal.dao.EmprestimoFerramentaDAO;
import br.com.sismetal.dao.FerramentaDAO;
import br.com.sismetal.dao.FuncionarioDAO;
import br.com.sismetal.dao.TelefoneDAO;
import br.com.sismetal.doumain.EmprestimoFerramenta;
import br.com.sismetal.doumain.Ferramenta;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.doumain.Telefone;


public class testeFuncionarioDAO {
	
	public void listarStatus() {
		FerramentaDAO ferramentaDAO = new FerramentaDAO();
		List<Ferramenta>ferramentasStatus = ferramentaDAO.listarStatus("não-emprestado");
		for(Ferramenta ferramenta: ferramentasStatus) {
			System.out.println(ferramenta);
		}
	}
	
	public void listarPorNome() {
		EmprestimoFerramenta emprestimoFerramenta = new EmprestimoFerramenta();
		emprestimoFerramenta.getFuncionarioFabrica().setNome("walter");
		EmprestimoFerramentaDAO emprestimoFerramentaDAO = new EmprestimoFerramentaDAO();
		List<EmprestimoFerramenta>emprestimoFerramentas = emprestimoFerramentaDAO.listarNome(emprestimoFerramenta);
		for(EmprestimoFerramenta emprestimoFerramenta1: emprestimoFerramentas) {
			System.out.println(emprestimoFerramenta1);
		}
	}
	
	public void listarPorNomeStatus() {
		
		EmprestimoFerramenta emprestimoFerramenta = new EmprestimoFerramenta();
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("walter heitor");
		emprestimoFerramenta.setFuncionarioFabrica(funcionario);;
		Ferramenta ferramenta = new Ferramenta();
		ferramenta.setStatus("emprestado");
		emprestimoFerramenta.setFerramenta(ferramenta);
		EmprestimoFerramentaDAO emprestimoFerramentaDAO = new EmprestimoFerramentaDAO();
		List<EmprestimoFerramenta>emprestimoFerramentas = emprestimoFerramentaDAO.listarNomeStatus(emprestimoFerramenta.getFuncionarioFabrica().getNome(),
				emprestimoFerramenta.getFerramenta().getStatus());
		for(EmprestimoFerramenta emprestimoFerramenta1: emprestimoFerramentas) {
			System.out.println("CCCCC"+emprestimoFerramenta1);
		}
	}
	
	public void salvar() {
		
		//Funcionario fun1 = new Funcionario("0123456", "talita", 1, "798337hh400991", "supervisorii", "tatita@hotmail.com", "010fccff33e578",tel2);
		Funcionario func2 = new Funcionario("0215060970", "walter heitor", "fabrica", "79809499191", "caldereiro", "ativo", "walhei33@hotmail.com", "010578");
		FuncionarioDAO fdao = new FuncionarioDAO();
		fdao.salvar(func2);
		Telefone tel2 = new Telefone();
		tel2.setNum_telefone("3431-1770");
		tel2.setFuncionario(func2);
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		telefoneDAO.salvar(tel2);
		
		
		
		//Telefone tel = new Telefone("937910101", fun1);

		//TelefoneDAO telefoneDAO = new TelefoneDAO();
	//	telefoneDAO.salvar(tel);
	//	System.out.println(tel+ "AAAAATELAAa");
		
	}
	
	public void buscar() {
		String codigo = "012345";
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario fun1 = fdao.buscarPorString(codigo);
		fun1.toString();
		System.out.println(fun1.getNome()+" "+ fun1.getCargo_func());
	}
	
	public void listar() {
		FuncionarioDAO fdao = new FuncionarioDAO();
		List<Funcionario> funcionarios = fdao.listar();
		
		for(Funcionario funcionario: funcionarios) {
			System.out.println(funcionario);
		}
	}
	
	public void salvarSenha() {
		Funcionario f = new Funcionario();
		f.setMatricula("0229106528");
		f.setNome("Jeferson");
		f.setCpf_func("555.555.555-55");
		f.setEmail_func("jeferson@gmail");
		f.setCargo_func("Soldador");
		f.setSetor("fabrica");
		f.setStatus_func("Ativo");
		f.setSenhaSemCriptografia("123456");
		SimpleHash hash = new SimpleHash("md5", f.getSenhaSemCriptografia());
		f.setSenha(hash.toHex());
		FuncionarioDAO fdao = new FuncionarioDAO();
		fdao.salvar(f);
		System.out.println("funcionario salvo com sucesso");		
	}
	@Test
	public void autenticar() {
		String email ="jeferson@gmail";
		String senha ="123456";
		System.out.println("teste");
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario f = fdao.autenticar(email, senha);
		System.out.println("Funcionario Autentica:  "+f);
	}
}

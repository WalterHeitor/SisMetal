package teste;

import org.junit.Test;

import br.com.sismetal.dao.FuncionarioDAO;
import br.com.sismetal.dao.TelefoneDAO;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.doumain.Telefone;

public class testeTelefoneDAO {
	@Test
	public void testeTel() {
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionario = funcionarioDAO.buscarPorString("0123456");
		System.out.println(funcionario);
		/*TelefoneDAO telefoneDAO = new TelefoneDAO();
		Telefone telefone = new Telefone();
		telefone = telefoneDAO.buscarPorMatricula(funcionario.getMatricula());
		System.out.println(telefone);*/
	}
}

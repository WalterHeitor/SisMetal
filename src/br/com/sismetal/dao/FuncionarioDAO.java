package br.com.sismetal.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.util.HibernateUtil;

public class FuncionarioDAO extends GenericDAO<Funcionario>{

	public Funcionario autenticar(String email_func, String senha) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			//consulta.createAlias("Funcionario", "f");
			consulta.add(Restrictions.eq("email_func",email_func));
			
			SimpleHash hash = new SimpleHash("md5",senha);
			consulta.add(Restrictions.eq("senha", hash.toHex()));
			Funcionario resultado = (Funcionario) consulta.uniqueResult();
			
			return resultado;
		} catch (RuntimeException erro) {
			System.out.println("ERRO:  "+erro);
			throw erro;
		}finally {
			sessao.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarFuncAtivo() {
		
		String status_func = "Ativo";
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.add(Restrictions.eq("status_func", status_func));
			
			List<Funcionario> resultado = new ArrayList<>();
			resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			System.out.println("Erro: "+ e);
		}finally {
			sessao.close();
		}
		return null;
	}
	
}

package br.com.sismetal.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.sismetal.doumain.Telefone;
import br.com.sismetal.util.HibernateUtil;

public class TelefoneDAO extends GenericDAO<Telefone>{

	public Telefone buscarPorMatricula(String matricula) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		Telefone telefone = null;
		try {
			Query	consulta = 	sessao.getNamedQuery("Telefone.buscrPorMatricula");
			consulta.setString("matricula", matricula);
			telefone = (Telefone) consulta.uniqueResult();
			System.out.println("buscado com sucesso");
			} catch (Exception e) {
				System.out.println("erro ao salvar "+e.getMessage());
			}
			finally {
				sessao.close();
			}	
		return telefone;
		
	}
}

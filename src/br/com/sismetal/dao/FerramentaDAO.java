package br.com.sismetal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.sismetal.doumain.Ferramenta;
import br.com.sismetal.util.HibernateUtil;

public class FerramentaDAO extends GenericDAO<Ferramenta>{

	
	public List<Ferramenta>listarStatus(String status){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			String hql = "from Ferramenta f where f.status = ?";
			Query consulta = sessao.createQuery(hql);
			consulta.setParameter(0, status);
			
			@SuppressWarnings("unchecked")
			List<Ferramenta>ferramentas = consulta.list();
			return ferramentas;
		
		} catch (Exception e) {
			System.out.println("erro ao listar por nome: "+e);
			e.printStackTrace();
		}
		return null;
	
	}
}

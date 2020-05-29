package br.com.sismetal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
			throw e;
		}finally {
			sessao.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Ferramenta>listarEstragadas(){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			String status = "estragada";
			Criteria consulta = sessao.createCriteria(Ferramenta.class);
			consulta.add(Restrictions.eq("status", status));
			List<Ferramenta>ferramentas = consulta.list();
			return ferramentas;
		} catch (Exception e) {
			System.out.println("erro ao listar por status: "+e);
			e.printStackTrace();
			throw e;
		}finally {
			sessao.close();
		}
		
	}
}

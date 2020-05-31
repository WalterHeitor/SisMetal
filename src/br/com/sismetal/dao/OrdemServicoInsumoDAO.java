package br.com.sismetal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.sismetal.doumain.OrdemServico;
import br.com.sismetal.doumain.OrdemServicoInsumo;
import br.com.sismetal.doumain.Projeto;
import br.com.sismetal.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class OrdemServicoInsumoDAO extends GenericDAO<OrdemServicoInsumo>{

	public List<OrdemServicoInsumo>listarFiltroOS(OrdemServico ordemServico){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			
			String hql = "from OrdemServicoInsumo osi where osi.ordemServico.id_ordem_servico = ?";
			Query consulta = session.createQuery(hql);
			consulta.setParameter(0, ordemServico.getId_ordem_servico());
			List<OrdemServicoInsumo>ordemServicoInsumos = consulta.list();
			return ordemServicoInsumos;
		} catch (Exception e) {
			System.out.println("erro ao listar por OS: "+e);
			e.printStackTrace();
		}
		return null;
	}
	
	public List<OrdemServicoInsumo>listarFiltroPJ(Projeto projeto){
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			
			String hql = "from OrdemServicoInsumo osi where osi.ordemServico.projeto.id_projeto = ?";
			Query consulta = session.createQuery(hql);
			consulta.setParameter(0, projeto.getId_projeto());
			List<OrdemServicoInsumo>ordemServicoInsumos = consulta.list();
			return ordemServicoInsumos;
		} catch (Exception e) {
			System.out.println("erro ao listar por Projeto: "+e);
			e.printStackTrace();
		}
		return null;
	}
}

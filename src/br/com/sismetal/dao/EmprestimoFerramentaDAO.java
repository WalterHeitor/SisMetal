package br.com.sismetal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.sismetal.doumain.EmprestimoFerramenta;
import br.com.sismetal.doumain.Funcionario;
import br.com.sismetal.util.HibernateUtil;
@SuppressWarnings("unchecked")
public class EmprestimoFerramentaDAO extends GenericDAO<EmprestimoFerramenta>{

	public List<EmprestimoFerramenta>listarNome(EmprestimoFerramenta emprestimoFerramenta){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			String hql = "from EmprestimoFerramenta ep where ep.funcionarioFabrica.nome = ?";
			Query consulta = sessao.createQuery(hql);
			consulta.setParameter(0, emprestimoFerramenta.getFuncionarioFabrica().getNome());
			
			List<EmprestimoFerramenta>emprestimoFerramentas = consulta.list();
			return emprestimoFerramentas;
		
		} catch (Exception e) {
			System.out.println("erro ao listar por nome: "+e);
			e.printStackTrace();
		}
		return null;
	
	}
	public List<EmprestimoFerramenta>listarNomeFunc(Funcionario funcionario){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			String hql = "from EmprestimoFerramenta ep where ep.funcionarioFabrica.nome = ? and ep.devolucao = ?";
			Query consulta = sessao.createQuery(hql);
			consulta.setParameter(0, funcionario.getNome());
			consulta.setParameter(1, false);
			
			List<EmprestimoFerramenta>emprestimoFerramentas = consulta.list();
			return emprestimoFerramentas;
		
		} catch (Exception e) {
			System.out.println("erro ao listar por nome: "+e);
			e.printStackTrace();
		}
		return null;
	
	}
	public List<EmprestimoFerramenta>listarNomeStatus(String nome, String ferramenta){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			
			String hql =" from EmprestimoFerramenta ep where ep.funcionarioFabrica.nome = ? and ep.ferramenta.status = ? and ep.devolucao = ?";
			
			Query consulta = sessao.createQuery(hql);
			consulta.setParameter(0, nome);
			consulta.setParameter(1, ferramenta);
			consulta.setParameter(2, false);
			
		
			
			List<EmprestimoFerramenta>emprestimoFerramentas = consulta.list();
			return emprestimoFerramentas;
		
		} catch (Exception e) {
			System.out.println("erro ao listar por nome: "+e);
			e.printStackTrace();
		}
		return null;
	
	}
	
	public List<EmprestimoFerramenta>listarDevFalse(EmprestimoFerramenta emprestimoFerramenta){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			String hql = "from EmprestimoFerramenta ep where ep.devolucao = ?";
			Query consulta = sessao.createQuery(hql);
			consulta.setParameter(0, false);
			
			List<EmprestimoFerramenta>emprestimoFerramentas = consulta.list();
			return emprestimoFerramentas;
		
		} catch (Exception e) {
			System.out.println("erro ao listar por devolução: "+e);
			e.printStackTrace();
		}
		return null;
	
	}
	


}

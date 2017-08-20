package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import HibernateUtil.HibernateUtil;
import POJO.MyRole;


@Repository
public class MyRoleDAOImp implements MyRoleDAO{

	@Override
	public List<MyRole> getListRole() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		List<MyRole> list = new ArrayList<>();
		
		String HQL = "select b from role b";
		list = ses.createQuery(HQL).list();
		
		ses.getTransaction().commit();
		return list;
	}

	@Override
	public MyRole getRoleID(String id) {
		// TODO Auto-generated method stub
		
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		MyRole result = new MyRole();
		
		String HQL = "select b from role b where b.id = ?";
		result = (MyRole) ses.createQuery(HQL).setParameter(0, id).uniqueResult();
		
		ses.getTransaction().commit();
		return result;
	}

	
	@Override
	public MyRole getRoleUsername(String username) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		MyRole result = new MyRole();
		
		String HQL = "select b from role b where b.username = ?";
		result = (MyRole) ses.createQuery(HQL).setParameter(0, username).uniqueResult();
		
		ses.getTransaction().commit();
		return result;
	}
	
	
}

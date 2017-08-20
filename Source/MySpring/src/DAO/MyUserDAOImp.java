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
import POJO.MyUser;

@Repository
public class MyUserDAOImp implements MyUserDAO{

	@Override
	public List<MyUser> getListUser() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		List<MyUser> list = new ArrayList<>();
		
		String HQL = "select b from user b";
		list = ses.createQuery(HQL).list();
		
		ses.getTransaction().commit();
		return list;
		
	}

	@Override
	public MyUser getUser(String username) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		MyUser result = new MyUser();
		
		String HQL = "select b from user b where b.username = ?";
		result = (MyUser) ses.createQuery(HQL).setParameter(0, username).uniqueResult();
		
		ses.getTransaction().commit();
		return result;
	}

	@Override
	public void updateUser(MyUser update) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		ses.update(update);
		
		ses.getTransaction().commit();
	}
	
	
}


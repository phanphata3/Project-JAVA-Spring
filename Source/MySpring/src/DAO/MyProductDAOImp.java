package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import HibernateUtil.HibernateUtil;
import POJO.MyProduct;


@Repository
public class MyProductDAOImp implements MyProductDAO {

	@Override
	public List<MyProduct> getListProduct() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		String HQL = "select b from product b";
		List<MyProduct> list = new ArrayList<>();
		list = ses.createQuery(HQL).list();
		
		ses.getTransaction().commit();
		return list;
		
	}

	@Override
	public MyProduct getProduct(String id) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		String HQL = "select b from product b where b.id = ?";
		MyProduct result = new MyProduct();
		result = (MyProduct) ses.createQuery(HQL).setParameter(0, id).uniqueResult();
		
		ses.getTransaction().commit();
		return result;
	}

	@Override
	public void removeProduct(String id) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		String HQL = "delete from product b where b.id = ?";
		
		ses.createQuery(HQL).setParameter(0, id);
		ses.getTransaction().commit();
	}

	
	@Override
	public void removeProduct(MyProduct remove) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		ses.delete(remove);
		ses.getTransaction().commit();
	}
	
	
	@Override
	public void updateProduct(MyProduct update) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		ses.saveOrUpdate(update);
		ses.getTransaction().commit();
	}

	@Override
	public void addProduct(MyProduct add) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSessionFactory().openSession();
		ses.getTransaction().begin();
		
		ses.save(add);
		ses.getTransaction().commit();
	}

	
}

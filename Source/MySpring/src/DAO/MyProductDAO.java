package DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import POJO.MyProduct;

public interface MyProductDAO {
	
	public List<MyProduct> getListProduct();
	public MyProduct getProduct(String id);
	public void removeProduct(String id);
	public void removeProduct(MyProduct remove);
	public void updateProduct(MyProduct update);
	public void addProduct(MyProduct add);
	
}

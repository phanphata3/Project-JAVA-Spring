package Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.MyProductDAO;
import POJO.MyProduct;

@Service
public class MyProductServiceImp implements MyProductService {
	
	@Autowired
	MyProductDAO myProduct;
	
	@Transactional
	@Override
	public List<MyProduct> getListProduct() {
		// TODO Auto-generated method stub
		return myProduct.getListProduct();
	}

	@Transactional
	@Override
	public MyProduct getProduct(String id) {
		// TODO Auto-generated method stub
		return myProduct.getProduct(id);
	}

	@Transactional
	@Override
	public void removeProduct(String id) {
		// TODO Auto-generated method stub
		myProduct.removeProduct(id);
	}

	@Transactional
	@Override
	public void removeProduct(MyProduct remove) {
		// TODO Auto-generated method stub
		myProduct.removeProduct(remove);
	}

	@Transactional
	@Override
	public void updateProduct(MyProduct update) {
		// TODO Auto-generated method stub
		myProduct.updateProduct(update);
	}

	@Transactional
	@Override
	public void addProduct(MyProduct add) {
		// TODO Auto-generated method stub
		myProduct.addProduct(add);
	}

}

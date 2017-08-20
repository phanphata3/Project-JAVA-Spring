package Services;

import java.util.List;

import POJO.MyProduct;

public interface MyProductService {
	public List<MyProduct> getListProduct();
	public MyProduct getProduct(String id);
	public void removeProduct(String id);
	public void removeProduct(MyProduct remove);
	public void updateProduct(MyProduct update);
	public void addProduct(MyProduct add);
}

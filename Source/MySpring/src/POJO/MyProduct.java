package POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "product")
//@Table (name = "product")
public class MyProduct implements Serializable{
	
	@Id
	@Column (name = "id")
	private String id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "info")
	private String info;
	
	@Column (name = "price")
	private int price;
	
	
	public MyProduct()
	{}
	
	public MyProduct(String id, String name, String info, int price)
	{
		this.id = id;
		this.name = name;
		this.info = info;
		this.price = price;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setInfo(String info)
	{
		this.info = info;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getInfo()
	{
		return info;
	}
	
	public Integer getPrice()
	{
		return price;
	}

	
	
}

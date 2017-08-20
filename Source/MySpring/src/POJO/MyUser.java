package POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="user")
//@Table (name="user")
public class MyUser implements Serializable{
	
	@Id
	@Column (name="username")
	private String username;
	
	@Column (name="pass")
	private String pass;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "phone")
	private String phone;
	
	
	public MyUser()
	{}
	
	public MyUser(String username, String pass, String name, String address, String email, String phone)
	{
		this.username = username;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPass()
	{
		return pass;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPhone()
	{
		return phone;
	}
}

package POJO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "role")
//@Table(name = "role")
public class MyRole implements Serializable {
	
	@Id
	@Column (name = "id")
	private String id;
	
	@Column (name = "username")
	private String username;
	
	@Column (name = "role")
	private String role;
	
	
	public MyRole()
	{}
	
	public MyRole(String id, String username, String role)
	{
		this.id = id;
		this.username = username;
		this.role = role;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getRole()
	{
		return role;
	}
}

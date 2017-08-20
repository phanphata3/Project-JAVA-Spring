package data;

public class Contact {
	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	
	public void setFirstname(String name)
	{
		this.firstname = name;
	}
	
	public void setLastname(String name)
	{
		this.lastname = name;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	
	public String getFirstname()
	{
		return this.firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getTelephone()
	{
		return telephone;
	}
}

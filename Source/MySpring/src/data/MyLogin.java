package data;

public class MyLogin {
	private String username;
	private String password;
	private String password1;
	private String password2;
	
	
	public MyLogin()
	{}
	
	public MyLogin(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setPassword1(String password1)
	{
		this.password1 = password1;
	}
	
	public void setPassword2(String password2)
	{
		this.password2 = password2;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getPassword1()
	{
		return password1;
	}
	
	public String getPassword2()
	{
		return password2;
	}
}

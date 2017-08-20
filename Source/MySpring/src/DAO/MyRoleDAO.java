package DAO;


import java.util.List;

import org.springframework.stereotype.Repository;

import POJO.MyRole;


public interface MyRoleDAO {
	
	public List<MyRole> getListRole();
	public MyRole getRoleID(String id);
	public MyRole getRoleUsername(String username);
}

package DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import POJO.MyUser;


public interface MyUserDAO {

	public List<MyUser> getListUser();
	public MyUser getUser(String username);
	public void updateUser(MyUser update);

}

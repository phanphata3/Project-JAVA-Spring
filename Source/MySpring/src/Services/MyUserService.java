package Services;

import java.util.List;

import POJO.MyUser;

public interface MyUserService {
	public List<MyUser> getListUser();
	public MyUser getUser(String username);
	public void updateUser(MyUser update);
}

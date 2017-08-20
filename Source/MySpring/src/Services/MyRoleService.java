package Services;

import java.util.List;

import POJO.MyRole;

public interface MyRoleService {
	public List<MyRole> getListRole();
	public MyRole getRoleID(String id);
	public MyRole getRoleUsername(String username);
}

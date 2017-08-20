package Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.MyRoleDAO;
import POJO.MyRole;

@Service
public class MyRoleServiceImp implements MyRoleService {

	@Autowired
	MyRoleDAO myRole;
	
	@Transactional
	@Override
	public List<MyRole> getListRole() {
		// TODO Auto-generated method stub
		return myRole.getListRole();
	}

	@Transactional
	@Override
	public MyRole getRoleID(String id) {
		// TODO Auto-generated method stub
		return myRole.getRoleID(id);
	}

	@Transactional
	@Override
	public MyRole getRoleUsername(String username) {
		// TODO Auto-generated method stub
		return myRole.getRoleUsername(username);
	}

}

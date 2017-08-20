package Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.MyUserDAO;
import POJO.MyUser;

@Service
public class MyUserServiceImp implements MyUserService {
	
	@Autowired
	MyUserDAO myUser;
	
	@Transactional
	@Override
	public List<MyUser> getListUser() {
		// TODO Auto-generated method stub
		return myUser.getListUser();
	}

	@Transactional
	@Override
	public MyUser getUser(String username) {
		// TODO Auto-generated method stub
		return myUser.getUser(username);
	}

	@Transactional
	@Override
	public void updateUser(MyUser update) {
		// TODO Auto-generated method stub
		myUser.updateUser(update);
	}

}

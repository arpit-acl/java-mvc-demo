package mongo.crud.demo.components.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongo.crud.demo.components.user.User;
import mongo.crud.demo.components.user.UserDaoImpl;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	UserDaoImpl userDao;
	@Override
	public User isUserExist(String email) {
		return userDao.find(email, "email");
		// TODO Auto-generated method stub
	}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void register(User user) {
		userDao.add(user);
	}
}

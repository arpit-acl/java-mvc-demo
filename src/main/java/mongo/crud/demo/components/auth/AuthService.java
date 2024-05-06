package mongo.crud.demo.components.auth;

import mongo.crud.demo.components.user.User;

public interface AuthService {
	public User isUserExist(String email);

	public void register(User user);

	public User login(User user);
}

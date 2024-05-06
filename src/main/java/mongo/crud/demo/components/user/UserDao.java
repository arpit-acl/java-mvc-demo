package mongo.crud.demo.components.user;

import java.util.List;

public interface UserDao {
	public List<User> list();
	public User add(User user);
	public Boolean update(User user);
	public Boolean delete(User user);
	public User find(String value,String field);
}

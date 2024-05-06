package mongo.crud.demo.components.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
	@Autowired
	UserDaoImpl userDao;
}

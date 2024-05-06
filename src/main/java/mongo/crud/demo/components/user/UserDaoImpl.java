package mongo.crud.demo.components.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	

	@Autowired
	MongoTemplate mongoTemplate;
	
	UserDaoImpl() {
		System.out.println("Collection Checking");
//		if(!mongoTemplate.collectionExists(User.class)) {
//			mongoTemplate.createCollection(User.class);
//		}
	}
	
	
	@Override
	public List<User> list() {
//		mongoTemplate()
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User add(User user) {
		
		mongoTemplate.save(user);
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public Boolean update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(String value, String field) {
		// TODO Auto-generated method stub
		User user = mongoTemplate.findOne(new Query(Criteria.where(field).is(value)), User.class);
		System.out.println("user" + user);
		return user;
	}

}

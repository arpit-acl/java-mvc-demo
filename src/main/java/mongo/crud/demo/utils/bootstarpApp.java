package mongo.crud.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import mongo.crud.demo.components.user.User;

public class bootstarpApp {
	
	public static void seedCollection (MongoTemplate mongoTemplate) {
		if(!mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.createCollection(User.class);
		}
	}
}

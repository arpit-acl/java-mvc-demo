package mongo.crud.demo.config;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AbstractModel {
	
	@DBRef(lazy = false)
	ObjectId createdBy;
	
	@DBRef(lazy = false)
	ObjectId updatedBy;
	
	@CreatedDate
	Date createdAt;
	
	Date updatedAt;
}

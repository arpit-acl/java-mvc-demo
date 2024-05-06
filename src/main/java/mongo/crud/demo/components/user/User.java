package mongo.crud.demo.components.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import mongo.crud.demo.config.AbstractModel;


@Document(collection = "users")
public class User extends AbstractModel{
	
	@Id
	private String _id;
	
	private String email;
	
	private String name;
	
//	@JsonIgnore
	private String password;
	
	
	
	public User(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	
	public String getId() {
		return _id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
        // Hash the password before storing it
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", email=" + email + ", name=" + name + " ]";
	}

    public boolean checkPassword(String password) {
        // Check if the provided password matches the hashed password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, this.password);
    }
    
    
}

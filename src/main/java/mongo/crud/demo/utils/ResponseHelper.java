

package mongo.crud.demo.utils;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResponseHelper {
	
	private boolean success;
	private Object data;
	private String message;



	
	public ResponseHelper() {
		super();
	}

	public ResponseHelper(boolean success, Object data, String message, String language) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;		
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	public boolean getSuccess() {
		return success;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		
	@Override
	public String toString() {
		return "ResponseHelper [success=" + success + ", data=" + data + ", message=" + message + "]";
	}
	
	public  ResponseEntity<Object> badRequest() {
		return new ResponseEntity<Object>(this, HttpStatus.BAD_REQUEST);
	}
	
	public  ResponseEntity<Object> ok() {
		return new ResponseEntity<Object>(this, HttpStatus.OK);
	}
}

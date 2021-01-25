package co.za.sandabakery.service;

import java.util.List;

import co.za.sandabakery.io.entity.UserEntity;
import co.za.sandabakery.ui.model.requests.SignUpUser;
import co.za.sandabakery.ui.model.requests.UserLogIn;
import co.za.sandabakery.ui.model.responses.UserModelResp;



public interface UserService  {
	
	UserModelResp createUser(SignUpUser user);
	boolean isLoggedIn(UserLogIn loginDetails);
	UserModelResp updateUser(String customerId,SignUpUser user);
	String deleteUser(String customerId);
	List<UserEntity> getUsers();
	UserEntity getUser(String customerId);
	UserEntity getUserByEmail(String emailAddress);
	
	List<String> getRoles(UserLogIn loginDetails);

}

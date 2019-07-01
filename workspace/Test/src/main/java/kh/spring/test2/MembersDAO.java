package kh.spring.test2;

import org.springframework.stereotype.Repository;


@Repository
public class MembersDAO {

public String isLoginAvailable(String email, String pw) {
	return null;
}

public boolean isEmailExist(String email) {
	return false;
}

public int memberOut(String email, String pw) {
	return 1;
}

}
package mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired    
    private SecurityService securityService;
        
    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }
    
    public boolean registerUser(String userId, String name, String password) {
        if (securityService.authenticate(userId, password)) {
            return userRepository.saveUser(userId, name);
        }
        System.out.println("등록 실패: 비밀번호가 유효하지 않음 " + "ID: " + userId + " 이름: " +name);
        return false;
    }
}
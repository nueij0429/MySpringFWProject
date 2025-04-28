package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Value("${userId}")
	private String testUserId;

	@Value("${userName}")
	private String testUserName;

	@Value("${userPassword}")
	private String testUserPassword;

	
	@Test
	void testUserService() {
		assertNotNull(userService);
		assertNotNull(userService.getUserRepository());
		//userService.getUserRepository().getDbtype() => String 타입 값은 MySQL
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		
		//SecurityService(어노테이션으로 주입) 확인
		assertNotNull(userService.getSecurityService());
		
		assertTrue(userService.registerUser("123", "홍길동", "12345"));
		assertFalse(userService.registerUser("456", "김철수", ""));
	}

}

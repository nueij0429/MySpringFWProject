package mylab.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class CustomerSpringTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testGetCustomerInfo() {
        CustomerVO customer = customerService.getCustomerInfo(1);
        assertNotNull(customer);
        System.out.println("[고객 정보] 이름: " + customer.getName() + ", 이메일: " + customer.getEmail());
    }

    @Test
    public void testGetAllCustomerList() {
        List<CustomerVO> list = customerService.getAllCustomerList();
        assertNotNull(list);
        assertFalse(list.isEmpty());
        System.out.println("[전체 고객 수] " + list.size());
        list.forEach(c -> System.out.println(c.getId() + ": " + c.getName()));
    }
    
}
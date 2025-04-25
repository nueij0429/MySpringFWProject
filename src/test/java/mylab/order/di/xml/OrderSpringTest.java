package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	
	@Autowired
	ShoppingCart cart;
	
	@Autowired
	OrderService service;
	
	@Test
	void testShoppingCart() {
		assertNotNull(cart);
		assertEquals(2, cart.getProducts().size());
		System.out.println("상품 개수: " + cart.getProducts().size());
		
		assertEquals(40000, cart.getTotalPrice());
		
		for(Product product : cart.getProducts()) {
			System.out.println(product);
		}
		System.out.println("전체 상품 가격(testShoppingCart): " + cart.getTotalPrice());
		System.out.println("");
	}
	
	@Test
	void testOrderService() {
		assertNotNull(service);
		assertEquals(40000, service.calculateOrderTotal());
		
		for(Product product : service.getShoppingCart().getProducts()) {
			System.out.println(product);
		}
		System.out.println("전체 상품 가격(testOrderService): " + service.calculateOrderTotal());
	}
}